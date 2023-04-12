package com.project.itda.timeline.model;

import java.sql.Date;

import lombok.Data;

@Data
public class TimeLineModel {
	private int postSeq; //게시글 ID
	private String content; //게시글 내용
	private Date createDate; //게시글 작성일
	private int familySeq; //가족 ID
	private String userId; //개인 ID
	private String filename; //파일 이름
	private String filepath; //파일 경로
	private String userName;
	private int replyCount;
	private int visible;
}//end class