package com.project.itda.bucketlist.model;

import java.util.Date;
import lombok.Data;

@Data
public class BucketListModel {
	private int bucketSeq;
	private String userId;
	private Date regDate;
	private String title;
	private String contents;
	private Date goalDate;
	private String type;
	private int familySeq;
	private String visible;
	private String filename;
	private String filepath;
	private Date finishDate;
}
