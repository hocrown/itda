package com.project.itda.common.service;

import java.util.List;

import com.project.itda.common.model.AlarmModel;

public interface IAlarmService {

	void insertAlarm(AlarmModel alarm);
	List<AlarmModel> getAlarmList(String userId);
	void updateChecked(String userId);
	int getUncheckedAlarmCount(String userId);

}
