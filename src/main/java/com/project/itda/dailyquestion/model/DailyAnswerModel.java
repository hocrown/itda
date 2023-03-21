package com.project.itda.dailyquestion.model;

import lombok.Data;

@Data
public class DailyAnswerModel {
	private int dailyAnswerSeq;
	private String userId;
	private int familySeq;
	private String Answer;
	private int ansDate;
}