package com.project.itda.dailyquestion.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.itda.common.model.FamilyModel;
import com.project.itda.common.service.UserService;
import com.project.itda.dailyquestion.model.DailyAnswerModel;
import com.project.itda.dailyquestion.model.DailyQuestionModel;
import com.project.itda.dailyquestion.model.FamilyAnswerModel;
import com.project.itda.dailyquestion.model.FamilyQuestionModel;
import com.project.itda.dailyquestion.model.FamilyQuestionView;
import com.project.itda.dailyquestion.service.DailyAnswerService;
import com.project.itda.dailyquestion.service.DailyQuestionService;
import com.project.itda.dailyquestion.service.FamilyQuestionService;

@Controller
public class DailyQuestionController {
    
	@Autowired
    private DailyQuestionService dailyQuestionService;
    
    @Autowired
    private FamilyQuestionService familyQuestionService;

    @Autowired
    private DailyAnswerService dailyAnswerService;
    
    @Autowired
    private UserService userService;
	
//	@GetMapping("/dailymain")
//	public String dailyMain(Model model, HttpSession session) {
//	    String userId = (String) session.getAttribute("userId");
//	    FamilyQuestionModel familyQuestion = (FamilyQuestionModel) session.getAttribute("todayFamilyQuestion"); 
//	    int questionSeq = familyQuestion.getDailyQuestionSeq();
//	    DailyAnswerModel dailyAnswer = dailyAnswerService.getDailyAnswerByUserId(questionSeq, userId);
//	    if (dailyAnswer == null) {
//	    	
//	    }
//	    model.addAttribute("dailyAnswer", dailyAnswer);
//		return "dailyquestion/dailyMain";
//	}
	
	@GetMapping("/dailyquestion/answerform")
	public String dailyAnswer(Model model) {
	
		return "dailyquestion/dailyAnswer";
	}
	
	@GetMapping("/dailyquestion/dailylist")
	public String dailyList(Model model) {
	
		return "dailyquestion/dailyList";
	}
	
	@GetMapping("/dailyquestion/monthlypage1")
	public String dailyMonthlyStickerPage1(Model model) {
	
		return "dailyquestion/dailyMonthlyStickerPage1";
	}
	@GetMapping("/dailymain")
	public String dailyQuestionPage(Model model, HttpSession session) {
	    int familySeq = (Integer) session.getAttribute("famSeq");
	    String userId = (String) session.getAttribute("userId");

	    List<FamilyQuestionModel> getFamilyQuestion =  familyQuestionService.getQuestionAndAskedDateByFamilySeq(familySeq);

	    FamilyQuestionModel latestFamilyQuestion = getFamilyQuestion.get(0);
	    int dailyQuestionSeq = latestFamilyQuestion.getDailyQuestionSeq();

	    List<FamilyAnswerModel> familyAnswers = dailyAnswerService.getFamilyAnswers(familySeq, dailyQuestionSeq);

	    model.addAttribute("familyQuestions", getFamilyQuestion);
	    model.addAttribute("familyAnswers", familyAnswers);

	    FamilyQuestionModel familyQuestion = (FamilyQuestionModel) session.getAttribute("todayFamilyQuestion"); 
	    int questionSeq = familyQuestion.getDailyQuestionSeq();
	    DailyAnswerModel dailyAnswer = dailyAnswerService.getDailyAnswerByUserId(questionSeq, userId);
	    if (dailyAnswer == null) {

	    }
	    model.addAttribute("dailyAnswer", dailyAnswer);

	    return "dailyquestion/dailyMain";
	}

	
	@GetMapping("/get-question")
	public void getDailyQuestion(@RequestParam String userId, HttpSession session) {
	        
	    FamilyModel family = userService.getFamilyByUserId(userId);
	        
	    if (family == null) {
	        // 가족 정보가 없는 경우 가족 승인 요청 페이지 띄워주기.
	    }

	    LocalDate today = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String todayStr = formatter.format(today);
	    int familySeq = family.getFamilySeq();
	    
	    int isAsked = familyQuestionService.selectByFamSeqAndAskedDate(familySeq, todayStr);
	    
	    if(isAsked == 0) {
	    	DailyQuestionModel todayQuestion = dailyQuestionService.getRandomQuestion(familySeq,todayStr);
	    	FamilyQuestionModel familyQuestion;
	        // 해당 가족에 대한 해당 질문이 없는 경우
	        familyQuestion = new FamilyQuestionModel();
	        familyQuestion.setFamilySeq(familySeq);
	        familyQuestion.setDailyQuestionSeq(todayQuestion.getDailyQuestionSeq());
	        familyQuestion.setAnswer("N");
	        familyQuestion.setAskedDate(new Date());
	        familyQuestionService.insert(familyQuestion);
	        FamilyQuestionModel todayFamilyQuestion = familyQuestionService.todayFamilyQuestion(familySeq, todayStr);
	        session.setAttribute("todayFamilyQuestion", todayFamilyQuestion);
	    } else {
	    	FamilyQuestionModel todayFamilyQuestion = familyQuestionService.todayFamilyQuestion(familySeq, todayStr);
	    	session.setAttribute("todayFamilyQuestion", todayFamilyQuestion);
	    }
    }
	
    @PostMapping("/dailyquestion/answer")
    public String saveDailyAnswer(DailyAnswerModel dailyAnswer, HttpSession session) {

    	FamilyQuestionModel familyQuestion = (FamilyQuestionModel) session.getAttribute("todayFamilyQuestion");
    	int dailyQuestionSeq = familyQuestion.getDailyQuestionSeq();
    	String userId = (String) session.getAttribute("userId");
    	int familySeq = familyQuestion.getFamilySeq();
    	dailyAnswer.setFamilySeq(familySeq);
    	dailyAnswer.setUserId(userId);
    	dailyAnswer.setDailyQuestionSeq(dailyQuestionSeq);
        dailyAnswerService.saveDailyAnswer(dailyAnswer);
        return "redirect:/dailymain";
    }
    

}
