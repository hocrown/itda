package com.project.itda.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.itda.admin.service.IAdminService;
import com.project.itda.dailyquestion.model.DailyQuestionModel;
import com.project.itda.dailyquestion.service.IDailyQuestionService;

@Controller
public class AdminController {
	
	@Autowired
	IDailyQuestionService dailyQuestionService;
	
	@Autowired
	IAdminService adminService;
	
	//로그인 페이지
	@GetMapping("/admin/login")
	public String adminLogin(Model model, HttpSession session) {
		
		
		return "admin/adminLogin";
	}
	
	//질문목록 페이지
	@GetMapping("/admin/questionmanagementlist")
	public String adminQuestionManagement(Model model, HttpSession session) {
		List<DailyQuestionModel> question = dailyQuestionService.getAllQuestion();
		model.addAttribute("questions", question);
		return "admin/questionManagementList";
	}
	
	//질문목록 불러오기
	@GetMapping("/getQuestions")
	@ResponseBody
	public List<DailyQuestionModel> getQuestions() {
		List<DailyQuestionModel> questions = dailyQuestionService.getAllQuestion();
		System.out.println(questions);
		return questions;
	}
	
	//하루질문 등록 액션
	@PostMapping("/insertQuestion")
	public String insertQuestionAction(DailyQuestionModel dailyQuestionModel) {
		
		dailyQuestionModel.setType("common");
		dailyQuestionModel.setVisible(1);
		dailyQuestionModel.setWriter("ITDA");
		
		dailyQuestionService.insertQuestion(dailyQuestionModel);
		System.out.println("Updating question with ID: " + dailyQuestionModel.getDailyQuestionSeq() + " and new text: " + dailyQuestionModel.getQuestion());
		  
		return "redirect:/admin/questionmanagementlist";
	}
	
	//하루질문 내용 수정 액션
	@PostMapping("/updateQuestion")
	public String updateQuestionAction(DailyQuestionModel dailyQuestionModel) {
		adminService.updateQuestion(dailyQuestionModel);
		System.out.println("Updating question with ID: " + dailyQuestionModel.getDailyQuestionSeq() + " and new text: " + dailyQuestionModel.getQuestion());
		  
		return "redirect:/admin/questionmanagementlist";
	}
	
	//하루질문 상태 수정 액션
	@PostMapping("/updateStatus")
	public String updateStatusAction(DailyQuestionModel dailyQuestionModel) {
		adminService.updateStatus(dailyQuestionModel);
		System.out.println("Updating question with ID: " + dailyQuestionModel.getDailyQuestionSeq() + " and new status: " + dailyQuestionModel.getVisible());
		  
		return "redirect:/admin/questionmanagementlist";
	}
	
	//하루질문 삭제 액션
	@PostMapping("/deleteQuestions")
	public String deleteQuestionsAction(@RequestBody List<Integer> dailyQuestionSeqs) {
	    int deletedCount = adminService.deleteQuestions(dailyQuestionSeqs);
	    System.out.println("Deleted " + deletedCount + " questions with IDs: " + dailyQuestionSeqs);

	    return "redirect:/admin/questionmanagementlist";
	}
	
	
	//요청질문 페이지
	@GetMapping("/admin/requestedquestionlist")
	public String requestedQuestionList(Model model, HttpSession session) {

		return "admin/requestedQuestionList";
	}
	
	//잇다소식관리 페이지
	@GetMapping("/admin/newsmanagementlist")
	public String adminNewsManagement(Model model, HttpSession session) {
		
		
		return "admin/newsManagementList";
	}
	

	
}
