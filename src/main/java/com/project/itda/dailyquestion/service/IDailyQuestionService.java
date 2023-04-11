package com.project.itda.dailyquestion.service;

import java.util.List;

import com.project.itda.dailyquestion.model.DailyQuestionModel;

public interface IDailyQuestionService {

	DailyQuestionModel getRandomQuestion(int familySeq, String todayStr);
	List<DailyQuestionModel> getAllQuestion();
	void insertQuestion(DailyQuestionModel dailyQuestion);
	
}
