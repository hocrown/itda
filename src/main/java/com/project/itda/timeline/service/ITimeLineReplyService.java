package com.project.itda.timeline.service;

import java.util.List;

import com.project.itda.timeline.model.TimeLineReplyModel;

/**
 * 
 * @author 박주영
 * @since 2023-04-10
 * 댓글 정보를 조회/입력/수정/삭제 하기 위한 서비스 클래스 입니다.
 *
 */

public interface ITimeLineReplyService {
	
	//특정 게시물의 전체 댓글 조회
	List<TimeLineReplyModel> getReplyList(int postSeq);
	
	//댓글 작성
	void insertReply(TimeLineReplyModel timeLineReplyModel);
	
	//댓글 수정
	public void updateReply(TimeLineReplyModel timeLineReplyModel);
	
	//댓글 삭제
	void deleteReply(int replySeq);
	
	// 특정 게시물의 댓글 수
	int countPostOneReply(int postSeq);

}