package com.project.itda.dailyquestion.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.dailyquestion.model.DailyAnswerModel;
import com.project.itda.dailyquestion.model.FamilyAnswerModel;
import com.project.itda.dailyquestion.model.FamilyQuestionView;

@Repository
@Mapper
public interface IDailyAnswerRepository {

	void saveDailyAnswer(DailyAnswerModel dailyAnswer);
	
	DailyAnswerModel getDailyAnswerByUserId(int questionSeq, String userId);

	List<DailyAnswerModel> getAnswersByFamilySeqAndDailyQuestionSeq(int familySeq, int dailyQuestionSeq);

	List<FamilyAnswerModel> getFamilyAnswers(int familySeq, int dailyQuestionSeq);
}
