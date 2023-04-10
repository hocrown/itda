package com.project.itda.bucketlist.model;

import java.util.Date;
import lombok.Data;

@Data
public class BucketReplyModel {
	private int bucketReplySeq;
	private int bucketSeq;
	private Date regDate;
	private String replyContents;
	private String userId;
	private String userName;
}
