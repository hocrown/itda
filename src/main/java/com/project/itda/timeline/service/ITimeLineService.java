package com.project.itda.timeline.service;

import java.util.List;

import com.project.itda.timeline.model.TimeLineModel;

/**
 * 
 * @author 박주영
 * @since 2023-04-05
 * 게시글 정보를 조회/입력/수정/삭제 하기 위한 서비스 클래스 입니다.
 *
 */

public interface ITimeLineService {
	
	//게시글 전체 목록
	List<TimeLineModel> getList(int familySeq);
	
	//게시글 내용
	List<TimeLineModel> getContents(int timeLineSeq);
	
	//게시글 추가
	void insertPost(TimeLineModel timeLineModel);
	
	//게시글 수정
	void updatePost(TimeLineModel timeLineModel);
	
	//게시글 삭제
	void deletePost(int timelineSeq);
	
}//end class