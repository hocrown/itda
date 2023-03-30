package com.project.itda.dailyquestion.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.dailyquestion.dao.IDailyAnswerRepository;
import com.project.itda.dailyquestion.model.DailyAnswerModel;
import com.project.itda.dailyquestion.model.FamilyAnswerModel;
import com.project.itda.dailyquestion.model.FamilyQuestionView;

@Service
public class DailyAnswerService implements IDailyAnswerService {

	@Autowired
	IDailyAnswerRepository dailyAnswerRepository;
	
	@Override
    public void saveDailyAnswer(DailyAnswerModel dailyAnswer) {
        dailyAnswerRepository.saveDailyAnswer(dailyAnswer);
    }
	
	@Override
	public DailyAnswerModel getDailyAnswerByUserId(int questionSeq, String userId) {
		DailyAnswerModel dailyAnswer = dailyAnswerRepository.getDailyAnswerByUserId(questionSeq, userId);
		return dailyAnswer;
	}


	@Override
	public List<DailyAnswerModel> getAnswersByFamilySeqAndDailyQuestionSeq(int familySeq, int dailyQuestionSeq) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<FamilyAnswerModel> getFamilyAnswers(int familySeq, int dailyQuestionSeq) {
		List<FamilyAnswerModel> getFamilyAnswers = dailyAnswerRepository.getFamilyAnswers(familySeq, dailyQuestionSeq);
		return getFamilyAnswers;
	}

}
