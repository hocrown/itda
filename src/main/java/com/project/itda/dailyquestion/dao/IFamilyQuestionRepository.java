package com.project.itda.dailyquestion.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.itda.common.model.FamilyModel;
import com.project.itda.dailyquestion.model.DailyQuestionModel;
import com.project.itda.dailyquestion.model.FamilyQuestionModel;
import com.project.itda.dailyquestion.model.FamilyQuestionView;

@Repository
@Mapper
public interface IFamilyQuestionRepository {
	List<FamilyModel> selectAll();

	@Transactional
	void insert(FamilyQuestionModel familyQusetion);

	int selectByFamSeqAndAskedDate(@Param("familySeq") int familySeq, @Param("todayStr") String todayStr);

	DailyQuestionModel selectByFamilySeqAndDate(int familySeq, Date date);
	
	FamilyQuestionModel todayFamilyQuestion(@Param("familySeq") int familySeq, @Param("todayStr") String todayStr);

	int getDailyQuestionSeqByFamilySeqAndAskedDate(int familySeq, Date today);
	
	List<FamilyQuestionModel> getQuestionAndAskedDateByFamilySeq(int familySeq);
	
}
