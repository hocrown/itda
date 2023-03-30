package com.project.itda.dailyquestion.model;

import java.util.Date;

import lombok.Data;

@Data
public class FamilyQuestionView {

    private String question;
    private Date askedDate;
    private String questionOrder;
    private int dailyQuestionSeq;
}
