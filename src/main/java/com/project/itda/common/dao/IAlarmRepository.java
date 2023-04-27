package com.project.itda.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.common.model.AlarmModel;

@Repository
@Mapper
public interface IAlarmRepository {

	void insertAlarm(AlarmModel alarm);
	List<AlarmModel> getAlarmList(String userId);
	void updateChecked(String userId);
	Integer getUncheckedAlarmCount(String userId);
	
}
