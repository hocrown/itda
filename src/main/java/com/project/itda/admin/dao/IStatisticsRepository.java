package com.project.itda.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.admin.model.JoinCountModel;

@Repository
@Mapper
public interface IStatisticsRepository {
	List<JoinCountModel> selectJoinCount();
	List<Map<String, Object>> getWeeklyVisitors();
	void insertVisitor(String userId);
}
