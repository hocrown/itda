package com.project.itda.timeline.model;

import java.util.Date;
import lombok.Data;

@Data
public class TimeLineModel {
	private int timelineSeq;
	private String userId;
	private Date regDate;
	private String contents;
	private int familySeq;
}