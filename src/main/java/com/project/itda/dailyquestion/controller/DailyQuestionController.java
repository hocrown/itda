package com.project.itda.dailyquestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.itda.dailyquestion.model.DailyQuestionModel;
import com.project.itda.dailyquestion.service.DailyQuestionService;

@Controller
public class DailyQuestionController {

	@Autowired
	DailyQuestionService dailyQuestionService;
	
	@GetMapping("/dailyquestion")
	@ResponseBody
	public ResponseEntity<DailyQuestionModel> getDailyQuestion(){
		DailyQuestionModel dailyQuestion = dailyQuestionService.fetchDailyQuestion();
		if (dailyQuestion !=null) {
			return ResponseEntity.ok(dailyQuestion);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
