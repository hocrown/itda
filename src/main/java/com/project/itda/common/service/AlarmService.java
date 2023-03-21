package com.project.itda.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.common.dao.IAlarmRepository;

@Service
public class AlarmService implements IAlarmService {

	@Autowired
	IAlarmRepository alarmDao;
	
}
