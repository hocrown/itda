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
	List<TimeLineModel> getList();
	List<TimeLineModel> getContents(int timeLineSeq);
	void insertPost(TimeLineModel timeLineModel);
	void updatePost(TimeLineModel timeLineModel);
	void deletePost(int timelineSeq);
}