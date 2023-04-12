package com.project.itda.dailyquestion.model;

import lombok.Data;

@Data
public class DailyQuestionModel {

	private int dailyQuestionSeq;
	private String question;
	private String qusetionType;
	private int familySeq;
	private int visible;
	private String writer;
}
