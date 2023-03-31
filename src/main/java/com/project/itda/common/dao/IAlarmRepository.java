package com.project.itda.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.common.model.AlarmModel;

@Repository
@Mapper
public interface IAlarmRepository {

	void insertAlarm(AlarmModel alarm);
}
