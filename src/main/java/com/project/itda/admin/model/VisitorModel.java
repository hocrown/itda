package com.project.itda.admin.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class VisitorModel {

	private int visitorSeq;
	private String userId;
	private Timestamp visitDate;

}
