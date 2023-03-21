package com.project.itda.bucketlist.model;

import java.util.Date;
import lombok.Data;

@Data
public class BucketListModel {
	private int bucketSeq;
	private String userId;
	private Date regDate;
	private String title;
	private String familyBucketContents;
	private Date goalDate;
	private String type;
}
