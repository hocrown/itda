package com.project.itda.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.admin.dao.IStatisticsRepository;
import com.project.itda.admin.model.JoinCountModel;

@Service
public class StatisticsService implements IStatisticsService {
	
	@Autowired
	IStatisticsRepository statisticsRepository;
	
	@Override
	public List<JoinCountModel> getJoinedMembersByMonth() {
		
        return statisticsRepository.selectJoinCount();
    }
	
	@Override
	public void insertVisitor(String userId) {
		statisticsRepository.insertVisitor(userId);
	}

	@Override
	public List<Map<String, Object>> getWeeklyVisitors() {
		
		return statisticsRepository.getWeeklyVisitors();
	}
	
	
	
}
