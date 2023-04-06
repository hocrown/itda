package com.project.itda.timeline.model;

import java.util.Date;
import lombok.Data;

@Data
public class TimeLineFileModel {
	private String fileName;
	private String filepath;
	private int timeLineSeq;
	private Date regDate;
}