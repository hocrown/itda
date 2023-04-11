package com.project.itda.dailyquestion.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.dailyquestion.dao.IDailyAnswerRepository;
import com.project.itda.dailyquestion.dao.IDailyQuestionRepository;
import com.project.itda.dailyquestion.dao.IFamilyQuestionRepository;
import com.project.itda.dailyquestion.model.DailyAnswerModel;
import com.project.itda.dailyquestion.model.DailyQuestionModel;

@Service
public class DailyQuestionService implements IDailyQuestionService {

	@Autowired
	IDailyQuestionRepository dailyQuestionRepository;
	@Autowired
	IFamilyQuestionRepository familyQuestion;
	@Autowired
	IDailyAnswerRepository dailyAnswer;
	
	
	@Override
	public DailyQuestionModel getRandomQuestion(int familySeq, String todayStr) {
		DailyQuestionModel randomQuestion = dailyQuestionRepository.getRandomQuestion(familySeq, todayStr);
		return randomQuestion;
	}


	@Override
	public List<DailyQuestionModel> getAllQuestion() {
		List<DailyQuestionModel> allDailyQuestion = dailyQuestionRepository.getAllQuestion();
		return allDailyQuestion;
	}


	@Override
	public void insertQuestion(DailyQuestionModel dailyQuestion) {
		dailyQuestionRepository.insertQuestion();
	}
}
