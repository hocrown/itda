package com.project.itda.timeline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.timeline.dao.ITimeLineRepository;
import com.project.itda.timeline.model.TimeLineModel;

@Service
public class TimeLineService implements ITimeLineService {
	
	@Autowired
	ITimeLineRepository timeLineRepository;

//	@Override
//	public List<TimeLineModel> getList(int familySeq) {
//		List<TimeLineModel> timeLineList = timeLineRepository.getList();
//		return timeLineList;

	@Override
	public List<TimeLineModel> getList(int familySeq) {
		return timeLineRepository.getList();
	}
	
	@Override
	public List<TimeLineModel> getContents(int timeLineSeq) {
		return timeLineRepository.getContents(timeLineSeq);
	}

	@Override
	public void insertPost(TimeLineModel timeLineModel) {
		timeLineRepository.insertPost(timeLineModel);
	}

	@Override
	public void updatePost(TimeLineModel timeLineModel) {
		timeLineRepository.updatePost(timeLineModel);
	}
	
	@Override
	public void deletePost(int timelineSeq) {
		timeLineRepository.deletePost(timelineSeq);
	}

}//end class