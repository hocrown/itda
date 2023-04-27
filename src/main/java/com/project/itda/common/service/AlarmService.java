package com.project.itda.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.common.dao.IAlarmRepository;
import com.project.itda.common.model.AlarmModel;

@Service
public class AlarmService implements IAlarmService {

	@Autowired
	IAlarmRepository alarmRepository;

	@Override
	public void insertAlarm(AlarmModel alarm) {
		alarmRepository.insertAlarm(alarm);
	}

	@Override
	public List<AlarmModel> getAlarmList(String userId) {
		List<AlarmModel> alarmList = alarmRepository.getAlarmList(userId);
		return alarmList;
	}

	@Override
	public void updateChecked(String userId) {
		alarmRepository.updateChecked(userId);
	}

	@Override
	public int getUncheckedAlarmCount(String userId) {
		Integer alarmCount = alarmRepository.getUncheckedAlarmCount(userId);
		return (alarmCount != null) ? alarmCount : 0;
	}

}
