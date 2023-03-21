package com.project.itda.dailyquestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.dailyquestion.dao.IDailyAnswerRepository;

@Service
public class DailyAnswerService implements IDailyAnswerService {

	@Autowired
	IDailyAnswerRepository dailyAnswerDao;
}
