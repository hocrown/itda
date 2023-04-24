package com.project.itda.timeline.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TimeLineModel {
	private int postSeq; //게시글 ID
	private String content; //게시글 내용
	private Date createDate; //게시글 작성일
	private int familySeq; //가족 ID
	private String userId; //개인 ID
	private String fileName; //파일 이름
	private byte[] fileData; //파일 경로
	private String encodedFileData;
	private String userName;
	private MultipartFile file;
	private int replyCount;
	private int visible;
}//end class