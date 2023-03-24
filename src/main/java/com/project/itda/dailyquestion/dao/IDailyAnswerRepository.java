package com.project.itda.dailyquestion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IDailyAnswerRepository {

	List<Integer> findAnsweredQuestionIdsByFamily(@Param("familySeq") int familySeq);
}
