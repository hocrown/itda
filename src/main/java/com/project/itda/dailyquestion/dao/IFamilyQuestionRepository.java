package com.project.itda.dailyquestion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.common.model.FamilyModel;
import com.project.itda.dailyquestion.model.FamilyQuestionModel;

@Repository
@Mapper
public interface IFamilyQuestionRepository {

	Object selectByFamilySeqAndDailyQuestionSeq(int familySeq, int dailyQuestionSeq);

	void insert(FamilyQuestionModel familyQ);

	List<FamilyModel> selectAll();

}
