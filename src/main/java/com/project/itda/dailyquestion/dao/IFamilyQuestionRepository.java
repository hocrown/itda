package com.project.itda.dailyquestion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.itda.common.model.FamilyModel;
import com.project.itda.dailyquestion.model.FamilyQuestionModel;

@Repository
@Mapper
public interface IFamilyQuestionRepository {
	List<FamilyModel> selectAll();

	@Transactional
	void insert(FamilyQuestionModel familyQusetion);

	int selectByFamSeqAndAskedDate(@Param("familySeq") int familySeq, @Param("todayStr") String todayStr);

	FamilyQuestionModel todayFamilyQuestion(@Param("familySeq") int familySeq);

	List<FamilyQuestionModel> getQuestionByFamilySeq(int familySeq);
	
	FamilyQuestionModel familyDailyQuestionByQuestionOrder(@Param("familySeq") int familySeq, @Param("questionOrder") int questionOrder);
	
	
}
