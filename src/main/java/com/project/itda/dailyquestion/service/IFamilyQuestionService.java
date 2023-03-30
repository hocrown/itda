package com.project.itda.dailyquestion.service;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.itda.dailyquestion.model.FamilyQuestionModel;
import com.project.itda.dailyquestion.model.FamilyQuestionView;

public interface IFamilyQuestionService {
	
	void insert(FamilyQuestionModel familyQuestion);
	int selectByFamSeqAndAskedDate(@Param("familySeq") int familySeq, @Param("todayStr") String todayStr);
	FamilyQuestionModel todayFamilyQuestion(@Param("familySeq") int familySeq, @Param("todayStr") String todayStr);
	int getDailyQuestionSeqByFamilySeqAndAskedDate(int familySeq, Date today);
	List<FamilyQuestionModel> getQuestionAndAskedDateByFamilySeq(int familySeq);
}
