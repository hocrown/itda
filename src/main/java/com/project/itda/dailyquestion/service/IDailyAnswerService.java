package com.project.itda.dailyquestion.service;

import java.util.List;

import com.project.itda.dailyquestion.model.DailyAnswerModel;
import com.project.itda.dailyquestion.model.FamilyAnswerModel;
import com.project.itda.dailyquestion.model.FamilyQuestionView;

public interface IDailyAnswerService {

	void saveDailyAnswer(DailyAnswerModel dailyAnswer);
	
	DailyAnswerModel getDailyAnswerByUserId(int questionSeq, String userId);
	
	List<DailyAnswerModel> getAnswersByFamilySeqAndDailyQuestionSeq(int familySeq, int dailyQuestionSeq);

	List<FamilyAnswerModel> getFamilyAnswers(int familySeq, int dailyQuestionSeq);

}
