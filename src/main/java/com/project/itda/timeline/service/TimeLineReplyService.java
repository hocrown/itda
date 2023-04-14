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
	public List<TimeLineReplyModel> getReplyList(int postSeq) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertReply(TimeLineReplyModel timeLineReplyModel) {
		timeLineReplyRepository.insertReply(timeLineReplyModel);
	}

	@Override
	public void updateReply(TimeLineReplyModel timeLineReplyModel) {
		timeLineReplyRepository.updateReply(timeLineReplyModel);
	}
	
	@Override
	public void deleteReply(int replySeq) {
		timeLineReplyRepository.deleteReply(replySeq);
	}
	
	@Override
	public int countPostOneReply(int postSeq) {
		int replyCount = timeLineReplyRepository.countPostOneReply(postSeq);
		return replyCount;
	}
	

}//end class