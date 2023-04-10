package com.project.itda.timeline.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.timeline.model.TimeLineModel;
import com.project.itda.timeline.model.TimeLineReplyModel;

/**
 * 
 * @author 박주영
 * @since 2023-04-05
 * 게시글 정보를 조회/입력/수정/삭제 하기 위한 서비스 클래스 입니다.
 *
 */

public interface ITimeLineService {
	
	//게시글 전체 목록
	List<TimeLineModel> getPostList(int familySeq);
	
	//게시글 내용
	TimeLineModel getContent(int postSeq);
	
	//댓글
	List<TimeLineModel> getTimeLineReply(int PostSeq);
	
	//게시글 추가
	void insertPost(TimeLineModel timeLineModel, MultipartFile file) throws Exception;
	
	//게시글 수정
	void updatePost(TimeLineModel timeLineModel, MultipartFile file) throws Exception;
	
	//게시글 삭제
	void deletePost(int postSeq);
	
	
	//댓글 수 업데이트
	void updateRivewCount(String postId);
	
	//게시글 검색
	TimeLineModel postSearch(String keyword);
	
	//내용 검색 결과
	List<TimeLineModel> getContentSearch(@Param("keyword") String keyword);
	
	//작성자 검색 결과
	List<TimeLineModel> getuserId(@Param("keyword") String keyword);

	List<TimeLineReplyModel> getPostReply(int postSeq);
	
	
}//end class