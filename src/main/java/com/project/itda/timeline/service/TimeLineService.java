package com.project.itda.timeline.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.timeline.dao.ITimeLineRepository;
import com.project.itda.timeline.model.TimeLineModel;
import com.project.itda.timeline.model.TimeLineReplyModel;

@Service
public class TimeLineService implements ITimeLineService {

	@Autowired
	ITimeLineRepository timeLineRepository;
	
	@Override
	public List<TimeLineModel> getPostList(int familySeq) {
		List<TimeLineModel> postList = timeLineRepository.getPostList(familySeq);
		return postList;
	}

	@Override
	public TimeLineModel getContent(int postSeq) {
		return timeLineRepository.getContent(postSeq);
	}

	@Override
	public void insertPost(TimeLineModel timeLineModel){

		timeLineRepository.insertPost(timeLineModel);
	}

	@Override
	public void updatePost(TimeLineModel timeLineModel) {

		timeLineRepository.updatePost(timeLineModel);
	}
	
	@Override
	public void updatePostTwo(TimeLineModel timeLineModel) {

		timeLineRepository.updatePostTwo(timeLineModel);
	}
	
	
	@Override
	public void deletePost(int postSeq) {
		timeLineRepository.deletePost(postSeq);
	}
	
}//end class
