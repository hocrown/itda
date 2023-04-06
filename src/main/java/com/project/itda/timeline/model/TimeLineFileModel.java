package com.project.itda.timeline.model;

import lombok.Data;

@Data
public class TimeLineFileModel {
	private int fileSeq;
	private int timeLineId; //첨부파일이 있는 게시글의 아이디(글 번호)
	private String fileName; //파일 이름
	private String filepath; //파일 경로
}//end class