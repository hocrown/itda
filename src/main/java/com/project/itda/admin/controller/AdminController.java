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
	
	@GetMapping("/admin/login")
	public String adminLogin(Model model, HttpSession session) {
		
		
		return "admin/adminLogin";
	}
	
	@GetMapping("/admin/questionmanagementlist")
	public String adminQuestionManagement(Model model, HttpSession session) {
		List<DailyQuestionModel> question = dailyQuestionService.getAllQuestion();
		model.addAttribute("questions", question);
		return "admin/questionManagementList";
	}
	
	@GetMapping("/getQuestions")
	@ResponseBody
	public List<DailyQuestionModel> getQuestions() {
		List<DailyQuestionModel> questions = dailyQuestionService.getAllQuestion();
		System.out.println(questions);
		return questions;
	}
	
}
