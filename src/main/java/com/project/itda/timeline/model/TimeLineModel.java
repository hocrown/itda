package com.project.itda.timeline.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TimeLineModel {
	 private int timeLineSq;
	 private String content;
	 private String regDate;
	 
	 private int replyNumber;
	 private int replystep;
	 
	 private MultipartFile file;
	 private int fileSeq;
 
}