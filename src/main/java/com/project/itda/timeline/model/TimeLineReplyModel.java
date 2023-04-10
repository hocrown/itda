package com.project.itda.timeline.model;

import java.util.Date;
import lombok.Data;

@Data
public class TimeLineReplyModel {
	private int replySeq;
	private String replyContent;
	private Date replyDate;
	private int postSeq;
	private String userId;
	private int replyCount; //댓글수
}//end class

