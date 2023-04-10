package com.project.itda.timeline.model;

import java.util.Date;
import lombok.Data;

@Data
public class TimeLineReplyModel {
	private int replySeq;
	private int postSeq;
	private Date replyDate; //댓글 날짜
	private String replyContent; //댓글 내용
	private String userId; //사용자 아이디
	private String userName; //사용자 닉네임(DB에 없어)
}//end class