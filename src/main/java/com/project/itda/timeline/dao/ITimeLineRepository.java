package com.project.itda.timeline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.itda.timeline.model.TimeLineModel;
import com.project.itda.timeline.model.TimeLineReplyModel;

@Repository
@Mapper
public interface ITimeLineRepository {
	
	//게시글 전체 목록
	List<TimeLineModel> getPostList(int familySeq);
	
	//게시글 내용
	TimeLineModel getContent(int postSeq);
	
	//게시글 추가
	void insertPost(TimeLineModel timeLineModel);
	
	//게시글 수정
	void updatePost(TimeLineModel timeLineModel);
	
	//게시글 삭제
	void deletePost(int postSeq);
	
}//end class