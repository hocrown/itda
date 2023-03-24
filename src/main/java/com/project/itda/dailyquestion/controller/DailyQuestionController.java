package com.project.itda.dailyquestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DailyQuestionController {
	
	@GetMapping("/dailyquestion/dailymain")
	public String dailyMain(Model model) {
	
		return "dailyquestion/dailyMain";
	}
}
