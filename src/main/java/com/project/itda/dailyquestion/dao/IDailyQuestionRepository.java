package com.project.itda.dailyquestion.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.dailyquestion.model.DailyQuestionModel;

@Repository
@Mapper
public interface IDailyQuestionRepository {

	DailyQuestionModel getRandomQuestion(int familySeq, String todayStr);

}
