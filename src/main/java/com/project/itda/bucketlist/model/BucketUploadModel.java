package com.project.itda.bucketlist.model;

import lombok.Data;

@Data
public class BucketUploadModel {
	private int fileSeq;
	private int bucketSeq;
	private String fileName;
	private long fileSize;
	private String fileContentType;
	private byte[] fileData;
}
