package com.project.itda.timeline.model;

import lombok.Data;

@Data
public class TimeLineModel {
	private int timelineSeq;
	private String userId;
	private String tlContent;
	private int emotion;
}
