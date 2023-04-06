package com.project.itda.timeline.model;

import java.util.Date;
import lombok.Data;

@Data
public class TimeLineReplyModel {
	private int replySeq;
	private String replyContents;
	private int timelineSeq;
	private Date regDate;
	private TimeLineModel post;
	
}//end class

