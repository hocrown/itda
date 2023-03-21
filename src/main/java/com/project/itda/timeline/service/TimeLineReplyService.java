package com.project.itda.timeline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.timeline.dao.ITimeLineReplyRepository;

@Service
public class TimeLineReplyService implements ITimeLineService {

		@Autowired
		ITimeLineReplyRepository timeLineDao;
}