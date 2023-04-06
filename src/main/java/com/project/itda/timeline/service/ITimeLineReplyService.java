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
	List<TimeLineReplyModel> getPostReply(int timeLineSeq);
	void insertreply(TimeLineReplyModel timeLineModel);
	void deletereply(int timelineSeq);
}