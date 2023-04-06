package com.project.itda.timeline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.timeline.model.TimeLineModel;
import com.project.itda.timeline.model.TimeLineReplyModel;

@Repository
@Mapper
public interface ITimeLineReplyRepository {
	
	//댓글 출력
	List<TimeLineReplyModel> getPostReply(int timeLineSeq);
	
	//댓글 작성
	void insertreply(TimeLineModel timeLineModel);
	
	//댓글 삭제
	void deletereply(int timelineSeq);
	
}
