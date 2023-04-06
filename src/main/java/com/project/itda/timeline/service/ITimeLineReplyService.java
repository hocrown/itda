package com.project.itda.timeline.service;

import java.util.List;

import com.project.itda.timeline.model.TimeLineReplyModel;

/**
 * 
 * @author 박주영
 * @since 2023-04-05
 * 댓글 정보를 조회/입력/수정/삭제 하기 위한 서비스 클래스 입니다.
 *
 */

public interface ITimeLineReplyService {
	
	//포스팅 댓글
	List<TimeLineReplyModel> getPostReply(int timeLineSeq);
	
	//댓글 추가하기
	void insertreply(TimeLineReplyModel timeLineModel);
	
	//댓글 삭제하기
	void deletereply(int timelineSeq);
}