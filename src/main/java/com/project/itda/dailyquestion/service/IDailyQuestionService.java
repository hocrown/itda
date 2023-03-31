package com.project.itda.dailyquestion.service;

import com.project.itda.dailyquestion.model.DailyQuestionModel;

public interface IDailyQuestionService {

	DailyQuestionModel getRandomQuestion(int familySeq, String todayStr);
	
}
