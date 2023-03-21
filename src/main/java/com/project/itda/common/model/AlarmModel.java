package com.project.itda.common.model;

import java.util.Date;

import lombok.Data;

@Data
public class AlarmModel {
	private int alarmSeq;
	private String receiver;
	private Date alarmDate;
	private int checked;

}
