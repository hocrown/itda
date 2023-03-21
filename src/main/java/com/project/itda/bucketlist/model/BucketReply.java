package com.project.itda.bucketlist.model;

import java.util.Date;
import lombok.Data;

@Data
public class BucketReply {
	private int bucketReplySeq;
	private int bno;
	private Date regDate;
	private String replyContents;
	private String type;
	private int timeLineSeq;
}
