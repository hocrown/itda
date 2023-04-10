package com.project.itda.timeline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.itda.timeline.model.TimeLineModel;
import com.project.itda.timeline.model.TimeLineReplyModel;

@Repository
@Mapper
public interface ITimeLineReplyRepository {
	
	//특정 게시물의 전체 댓글 조회
	List<TimeLineReplyModel> getReplyList(@Param("postSeq") int postSeq);
	
	//댓글 작성
	void insertReply(TimeLineReplyModel timeLineReplyModel);
	
	//댓글 수정
	void updateReply(TimeLineReplyModel timeLineReplyModel);
	
	//댓글 삭제
	void deleteReply(int replySeq);
	
	// 특정 게시물의 댓글 수
	int countPostOneReply(int postSeq);
	
}