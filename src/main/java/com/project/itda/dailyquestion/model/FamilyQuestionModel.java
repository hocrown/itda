package com.project.itda.dailyquestion.model;

import lombok.Data;

@Data
public class FamilyQuestion {
	private int familyQuestionSeq;
	private int familySeq;
	private int dailyQuestionSeq;
	private String answer;
}
