package com.project.itda.dailyquestion.model;

import java.util.Date;

import lombok.Data;

@Data
public class FamilyAnswerModel {
    private String userId;
    private String userName;
    private String answer;
    private Date ansDate;
}
