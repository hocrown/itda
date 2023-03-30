package com.project.itda.dailyquestion.model;

import java.util.List;

import lombok.Data;

@Data
public class DailyQuestionModel {
	public DailyQuestionModel(DailyQuestionModel todayFamilyQuestion, List<DailyAnswerModel> dailyAnswers) {
	}
	private int dailyQuestionSeq;
	private String question;
	private String qusetionType;
	private int familySeq;
}
