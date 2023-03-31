package com.project.itda.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.common.dao.IAlarmRepository;
import com.project.itda.common.model.AlarmModel;

@Service
public class AlarmService implements IAlarmService {

	@Autowired
	IAlarmRepository alarmDao;

	@Override
	public void insertAlarm(AlarmModel alarm) {
		alarmDao.insertAlarm(alarm);
	}
	
}
