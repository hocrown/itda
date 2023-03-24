package com.project.itda.dailyquestion.service;

import com.project.itda.dailyquestion.model.DailyQuestionModel;

public interface IDailyQuestionService {
	
	void insertQuestion(DailyQuestionModel dailyquestion);
	DailyQuestionModel fetchDailyQuestion();
}
