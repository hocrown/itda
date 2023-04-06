package com.project.itda.dailyquestion.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.itda.common.model.FamilyModel;
import com.project.itda.common.model.UserModel;
import com.project.itda.common.service.UserService;
import com.project.itda.dailyquestion.model.DailyAnswerModel;
import com.project.itda.dailyquestion.model.DailyQuestionModel;
import com.project.itda.dailyquestion.model.FamilyAnswerModel;
import com.project.itda.dailyquestion.model.FamilyQuestionModel;
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
    
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@GetMapping("/dailyquestion/answerform")
	public String dailyAnswer(Model model) {
	
		return "dailyquestion/dailyAnswer";
	}
	
	@GetMapping("/dailyquestion/dailylist")
	public String dailyList(Model model, HttpSession session) {
		int familySeq = (Integer) session.getAttribute("famSeq");
		List<FamilyQuestionModel> familyQuestions =  familyQuestionService.getQuestionAndAskedDateByFamilySeq(familySeq);
		
	    for (FamilyQuestionModel question : familyQuestions) {
	        int dailyQuestionSeq = question.getDailyQuestionSeq();
	        int answeredCount = dailyAnswerService.countAnsweredFamilyMember(familySeq, dailyQuestionSeq);
	        int familyMemberCount = userService.countFamilyMember(familySeq);

	        boolean allAnswered = answeredCount == familyMemberCount;

	        question.setAllAnswered(allAnswered);
	        question.setAnsweredCount(answeredCount);
	        question.setFamilyMemberCount(familyMemberCount);
	    }
		model.addAttribute("familyQuestions", familyQuestions);
		return "dailyquestion/dailyList";
	}
	
	@GetMapping("/dailyquestion/familybylist")
	public String familyDailyQuestionByList(@RequestParam("dailyQuestionSeq") int dailyQuestionSeq, 
			@RequestParam("familySeq") int familySeq, 
			@RequestParam("questionOrder") int questionOrder, Model model, HttpSession session) {
		FamilyQuestionModel getFamilyQuestion =  familyQuestionService.familyDailyQuestionByQuestionOrder(familySeq, questionOrder);
		List<FamilyAnswerModel> familyAnswers = dailyAnswerService.getFamilyAnswers(familySeq, dailyQuestionSeq);
	    int answeredCount = dailyAnswerService.countAnsweredFamilyMember(familySeq, dailyQuestionSeq);
	    int familyMemberCount = userService.countFamilyMember(familySeq);
	    int questionSeq = getFamilyQuestion.getDailyQuestionSeq();
	    String userId = (String) session.getAttribute("userId");
	    
	    DailyAnswerModel dailyAnswer = dailyAnswerService.getDailyAnswerByUserId(questionSeq, userId);
	    
	    if (dailyAnswer == null) {

	    }
	    //출력할 내용들 모델에 담음.
	    model.addAttribute("dailyAnswer", dailyAnswer);
		model.addAttribute("familyQuestion", getFamilyQuestion);
		model.addAttribute("familyAnswers", familyAnswers);
	    model.addAttribute("answeredCount", answeredCount);
	    model.addAttribute("familyMemberCount", familyMemberCount);
		
		return "dailyquestion/dailyDay";
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
	    int answeredCount = dailyAnswerService.countAnsweredFamilyMember(familySeq, dailyQuestionSeq);
	    int familyMemberCount = userService.countFamilyMember(familySeq);

	    List<FamilyAnswerModel> familyAnswers = dailyAnswerService.getFamilyAnswers(familySeq, dailyQuestionSeq);

	    
	    FamilyQuestionModel familyQuestion = familyQuestionService.todayFamilyQuestion(familySeq);
	    
	    int questionSeq = familyQuestion.getDailyQuestionSeq();
	    DailyAnswerModel dailyAnswer = dailyAnswerService.getDailyAnswerByUserId(questionSeq, userId);
	    
	    if (dailyAnswer == null) {

	    }
	    //출력할 내용들 모델에 담음.
	    model.addAttribute("familyQuestions", getFamilyQuestion);
	    model.addAttribute("familyAnswers", familyAnswers);
	    model.addAttribute("answeredCount", answeredCount);
	    model.addAttribute("familyMemberCount", familyMemberCount);
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
	        FamilyQuestionModel todayFamilyQuestion = familyQuestionService.todayFamilyQuestion(familySeq);
	        session.setAttribute("todayFamilyQuestion", todayFamilyQuestion);
	        
	        //웹소켓 활용 알림 메시지 전송
	        
	        // 해당 familySeq에 해당하는 유저들의 ID 목록을 가져옵니다.
            List<String> userIds = userService.getFamilyUserIds(familySeq); 
            String notification = "오늘의 질문이 등록됐어요.";
            for (String loginUserId : userIds) {
            	 messagingTemplate.convertAndSendToUser(loginUserId, "/queue/notifications", notification);
            }
	    } else {
	    	FamilyQuestionModel todayFamilyQuestion = familyQuestionService.todayFamilyQuestion(familySeq);
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
    
    @GetMapping("/dailyquestion/monthly")
    public String monthlyFamilyQuestion(DailyAnswerModel dailyAnswer, HttpSession session) {
    	return "dailyquestion/dailyMonthlyStickerPage1";
    }
    

}
