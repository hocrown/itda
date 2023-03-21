package com.project.itda.dailyquestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.dailyquestion.dao.IDailyQuestionRepository;

@Service
public class DailyQuestionService implements IDailyQuestionService {

	@Autowired
	IDailyQuestionRepository dailyQuestionDao;
}
