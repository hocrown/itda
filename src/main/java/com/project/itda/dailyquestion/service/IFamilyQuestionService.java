package com.project.itda.dailyquestion.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.itda.dailyquestion.model.FamilyQuestionModel;

public interface IFamilyQuestionService {
	
	void insert(FamilyQuestionModel familyQuestion);
	int selectByFamSeqAndAskedDate(@Param("familySeq") int familySeq, @Param("todayStr") String todayStr);
	List<FamilyQuestionModel> getQuestionAndAskedDateByFamilySeq(int familySeq);
	FamilyQuestionModel familyDailyQuestionByQuestionOrder(@Param("familySeq") int familySeq, @Param("questionOrder") int questionOrder);
	FamilyQuestionModel todayFamilyQuestion(@Param("familySeq") int familySeq);

}
