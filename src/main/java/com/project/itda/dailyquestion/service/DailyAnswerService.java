package com.project.itda.dailyquestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.dailyquestion.dao.IDailyAnswerRepository;
import com.project.itda.dailyquestion.model.DailyAnswerModel;
import com.project.itda.dailyquestion.model.FamilyAnswerModel;

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
	public List<FamilyAnswerModel> getFamilyAnswers(int familySeq, int dailyQuestionSeq) {
		List<FamilyAnswerModel> getFamilyAnswers = dailyAnswerRepository.getFamilyAnswers(familySeq, dailyQuestionSeq);
		return getFamilyAnswers;
	}
	
	@Override
	public int countAnsweredFamilyMember(int familySeq, int dailyQuestionSeq) {
		int answeredFamilyMemberCount = dailyAnswerRepository.countAnsweredFamilyMember(familySeq, dailyQuestionSeq);		
		return answeredFamilyMemberCount;
	}

	@Override
	public DailyAnswerModel getMyAnswer(String userId, int dailyQuestionSeq) {
		DailyAnswerModel myAnswer = dailyAnswerRepository.getMyAnswer(userId, dailyQuestionSeq);
		return myAnswer;
	}

	@Override
	public int countCompletedQuestion(int year, int month, int familySeq) {
		int result = dailyAnswerRepository.countCompletedQuestion(year, month, familySeq);
		return result;
	}

}
