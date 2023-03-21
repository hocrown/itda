package com.project.itda.dailyquestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.dailyquestion.dao.IFamilyQuestionRepository;

@Service
public class FamilyQuestionService implements IFamilyQuestionService {

	@Autowired
	IFamilyQuestionRepository familyQustionDao;
}
