package com.project.itda.timeline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.itda.timeline.model.TimeLineModel;
import com.project.itda.timeline.model.TimeLineReplyModel;

@Service
public class TimeLineReplyService implements ITimeLineReplyService {

	@Override
	public List<TimeLineReplyModel> getReplyList(int postSeq) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertReply(TimeLineModel timeLineModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReply(int postSeq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int replyCount(int postSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

}//end class