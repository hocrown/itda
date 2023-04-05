package com.project.itda.timeline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.timeline.dao.ITimeLineRepository;
import com.project.itda.timeline.model.TimeLineModel;

@Service
public class TimeLineService implements ITimeLineService {
	
	@Autowired
	ITimeLineRepository timeLineDao;

	@Override
	public List<TimeLineModel> getList() {
		List<TimeLineModel> timeLineList = timeLineDao.getList();
		return timeLineList;
	}

	@Override
	public List<TimeLineModel> getContents(int timeLineSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPost(TimeLineModel timeLineModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePost(TimeLineModel timeLineModel) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deletePost(int timelineSeq) {
		// TODO Auto-generated method stub
		
	}

}