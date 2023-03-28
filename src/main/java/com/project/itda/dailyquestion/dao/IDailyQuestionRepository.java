package com.project.itda.dailyquestion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.dailyquestion.model.DailyQuestionModel;

@Repository
@Mapper
public interface IDailyQuestionRepository {

	List<DailyQuestionModel> selectAll();
	void sendDailyQuestion();

}
