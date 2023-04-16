package com.project.itda.admin.service;

import java.util.List;

import com.project.itda.dailyquestion.model.DailyQuestionModel;

public interface IAdminService {
	public void updateQuestion(DailyQuestionModel dailyQuestionModel); // 하루질문 내용 수정
	public void updateStatus(DailyQuestionModel dailyQuestionModel); // 하루질문 상태 수정
	public int deleteQuestions(List<Integer> dailyQuestionSeqs);
}
