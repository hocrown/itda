package com.project.itda.common.model;

import java.sql.Date;

import lombok.Data;

@Data
public class AlarmModel {
	private int alarmSeq;
	private String userId;
	private Date alarmDate;
	private int checked;
	private String message;
	private String type;

}
