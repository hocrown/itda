package com.project.itda.timeline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.timeline.dao.ITimeLineRepository;

@Service
public class TimeLineService implements ITimeLineService {
	
	@Autowired
	ITimeLineRepository timeLineDao;

}
