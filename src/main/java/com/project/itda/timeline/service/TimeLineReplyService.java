package com.project.itda.timeline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.timeline.dao.ITimeLineReplyRepository;
import com.project.itda.timeline.model.TimeLineReplyModel;

@Service
public class TimeLineReplyService implements ITimeLineReplyService {
	
	@Autowired
	ITimeLineReplyRepository timeLineReplyRepository;

	@Override
	public List<TimeLineReplyModel> getPostReply(int timeLineSeq) {
		List<TimeLineReplyModel> reply = timeLineReplyRepository.getPostReply(timeLineSeq);
		
		return reply;
	}

	@Override
	public void insertreply(TimeLineReplyModel timeLineModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletereply(int timelineSeq) {
		// TODO Auto-generated method stub
		
	}



}