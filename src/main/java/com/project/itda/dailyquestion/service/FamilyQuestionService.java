package com.project.itda.dailyquestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.dailyquestion.dao.IFamilyQuestionRepository;
import com.project.itda.dailyquestion.model.FamilyQuestionModel;

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
	public FamilyQuestionModel todayFamilyQuestion(int familySeq) {
		FamilyQuestionModel todayFamilyQuestion = familyQuestionRepository.todayFamilyQuestion(familySeq);
		return todayFamilyQuestion;
	}

	@Override
	public List<FamilyQuestionModel> getQuestionListByFamilySeq(int familySeq) {
		List<FamilyQuestionModel> getFamilyQuestion = familyQuestionRepository.getQuestionByFamilySeq(familySeq);
		return getFamilyQuestion;
	}

	@Override
	public FamilyQuestionModel familyDailyQuestionByQuestionOrder(int familySeq, int questionOrder) {
		FamilyQuestionModel familyDailyQuestion = familyQuestionRepository.familyDailyQuestionByQuestionOrder(familySeq, questionOrder);
		return familyDailyQuestion;
	}
	

	
}
