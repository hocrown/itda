package com.project.itda.dailyquestion.model;

import java.util.Date;

import lombok.Data;

@Data
public class FamilyQuestionModel {
	private int familyQuestionSeq;
	private int familySeq;
	private int dailyQuestionSeq;
	private String answer;
	private Date askedDate;
	private String question;
	private String questionOrder;
	private boolean allAnswered;
	private int answeredCount;
	private int familyMemberCount;
}
