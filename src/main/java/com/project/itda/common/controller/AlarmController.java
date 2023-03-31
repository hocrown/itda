package com.project.itda.common.controller;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.itda.common.NotificationRequest;
import com.project.itda.common.dao.IAlarmRepository;
import com.project.itda.common.model.AlarmModel;

@Controller
public class AlarmController {
	
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
    @Autowired
    private IAlarmRepository alarmService;

    @MessageMapping("/notifications")
    public void sendNotificationToUser(NotificationRequest request) {
        String userId = request.getTargetUserId();
        String notification = request.getNotification();
        messagingTemplate.convertAndSendToUser(userId, "/queue/notifications", notification);
    }
    
    @RequestMapping(value = "/sendAlarm", method = RequestMethod.POST)
    @ResponseBody
    public void sendAlarm(@RequestBody AlarmModel alarm) {
        alarmService.insertAlarm(alarm);
    }
    
}