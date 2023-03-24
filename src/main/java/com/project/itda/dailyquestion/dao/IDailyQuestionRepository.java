package com.project.itda.dailyquestion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.itda.dailyquestion.model.DailyQuestionModel;

@Repository
@Mapper
public interface IDailyQuestionRepository {
	
	
	void insertQuestion(DailyQuestionModel dailyquestion);
	List<DailyQuestionModel> findUnusedQuestions(@Param("usedQuestionIds") List<Integer> usedQuestionIds, @Param("limit") int limit);
}
