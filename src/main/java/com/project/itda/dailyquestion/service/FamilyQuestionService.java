package com.project.itda.dailyquestion.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.dailyquestion.dao.IFamilyQuestionRepository;
import com.project.itda.dailyquestion.model.FamilyQuestionModel;
import com.project.itda.dailyquestion.model.FamilyQuestionView;

@Service
public class FamilyQuestionService implements IFamilyQuestionService {

	@Autowired
	IFamilyQuestionRepository familyQuestionRepository;


	@Override
	public void insert(FamilyQuestionModel familyQuestion) {
		familyQuestionRepository.insert(familyQuestion);
	}
	
	@Override
	public int selectByFamSeqAndAskedDate(int familySeq, String todayStr) {
	    Integer result = familyQuestionRepository.selectByFamSeqAndAskedDate(familySeq, todayStr);
	    return result != null ? result : 0;
	}

	@Override
	public FamilyQuestionModel todayFamilyQuestion(int familySeq, String todayStr) {
		FamilyQuestionModel todayFamilyQuestion = familyQuestionRepository.todayFamilyQuestion(familySeq, todayStr);
		return todayFamilyQuestion;
	}

	@Override
	public int getDailyQuestionSeqByFamilySeqAndAskedDate(int familySeq, Date today) {

		return 0;
	}

	@Override
	public List<FamilyQuestionModel> getQuestionAndAskedDateByFamilySeq(int familySeq) {
		List<FamilyQuestionModel> getFamilyQuestion = familyQuestionRepository.getQuestionAndAskedDateByFamilySeq(familySeq);
		return getFamilyQuestion;
	}



}
