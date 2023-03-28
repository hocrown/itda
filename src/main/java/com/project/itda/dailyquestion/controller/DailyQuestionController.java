package com.project.itda.dailyquestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DailyQuestionController {
	
	@GetMapping("/dailymain")
	public String dailyMain(Model model) {
	
		return "dailyquestion/dailyMain";
	}
	
	@GetMapping("/dailyquestion/dailyanswer")
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
}
