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
	
	//게시글 검색
	TimeLineModel postSearch(String keyword);
	
	//내용 검색 결과
	List<TimeLineModel> getContentSearch(@Param("keyword") String keyword);
	
	//작성자 검색 결과
	List<TimeLineModel> getuserId(@Param("keyword") String keyword);
	
	//게시글 댓글 가져오기
	List<TimeLineReplyModel> getPostReply(int postSeq);
	
}//end class