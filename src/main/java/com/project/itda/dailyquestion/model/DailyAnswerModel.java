package com.project.itda.dailyquestion.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DailyAnswerModel {
	private int dailyAnswerSeq;
	private String userId;
	private int familySeq;
	private String Answer;
	private int ansDate;
	private int dailyQuestionSeq;
}