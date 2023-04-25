package com.project.itda.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.itda.dailyquestion.model.DailyQuestionModel;

@Repository
@Mapper
public interface IAdminRepository {
	void updateQuestion(DailyQuestionModel dailyQuestionModel);
	void updateStatus(DailyQuestionModel dailyQuestionModel);
	int deleteQuestions(@Param("dailyQuestionSeqs") List<Integer> dailyQuestionSeqs);
}
