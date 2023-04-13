package com.project.itda.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.itda.dailyquestion.model.DailyQuestionModel;
import com.project.itda.dailyquestion.service.IDailyQuestionService;

@Controller
public class AdminController {
	
	@Autowired
	IDailyQuestionService dailyQuestionService;
	
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
	
	//통계 페이지
	@GetMapping("/admin/statistics")
	public String adminStatistics(Model model, HttpSession session) {
		
		
		return "admin/statistics";
	}	
	
}
