package com.project.itda.admin.service;

import java.util.List;
import java.util.Map;

import com.project.itda.admin.model.JoinCountModel;

public interface IStatisticsService {
	public List<JoinCountModel> getJoinedMembersByMonth();
	public void insertVisitor(String userId);
	public List<Map<String, Object>> getWeeklyVisitors();
}
