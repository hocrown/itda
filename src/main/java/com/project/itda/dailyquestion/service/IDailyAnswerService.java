package com.project.itda.dailyquestion.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.itda.dailyquestion.model.DailyAnswerModel;
import com.project.itda.dailyquestion.model.FamilyAnswerModel;

public interface IDailyAnswerService {

	void saveDailyAnswer(DailyAnswerModel dailyAnswer);
	
	DailyAnswerModel getDailyAnswerByUserId(int questionSeq, String userId);
	
	List<FamilyAnswerModel> getFamilyAnswers(int familySeq, int dailyQuestionSeq);

	int countAnsweredFamilyMember(@Param("familySeq") int familySeq, @Param("dailyQuestionSeq") int dailyQuestionSeq);
}
