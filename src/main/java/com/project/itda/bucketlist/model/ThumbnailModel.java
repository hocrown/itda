package com.project.itda.bucketlist.model;

import lombok.Data;

@Data
public class ThumbnailModel {
	private int thumbnailSeq;
	private int bno;
	private String fileName;
	private String fileSize;
	private String fileContentType;
	private String fileData;
}
