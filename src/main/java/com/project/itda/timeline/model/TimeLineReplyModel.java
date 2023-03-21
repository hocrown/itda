package com.project.itda.timeline.model;

import java.util.Date;
import lombok.Data;

@Data
public class TimeLineReplyModel {
	private int replySeq;
	private Date regDate;
	private String replyContents;
	private String type;
	private int timelineSeq;
}
