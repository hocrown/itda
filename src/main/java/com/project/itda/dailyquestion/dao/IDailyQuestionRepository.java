package com.project.itda.dailyquestion.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.dailyquestion.model.DailyQuestionModel;

@Repository
@Mapper
public interface IDailyQuestionRepository {

	DailyQuestionModel getRandomQuestion(int familySeq, String todayStr);
	List<DailyQuestionModel> getAllQuestion();
	void insertQuestion(DailyQuestionModel dailyQuestion);
}
