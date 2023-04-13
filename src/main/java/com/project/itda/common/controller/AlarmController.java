package com.project.itda.common.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.itda.common.AlarmRequest;
import com.project.itda.common.dao.IAlarmRepository;
import com.project.itda.common.model.AlarmModel;

@Controller
public class AlarmController {
	
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
    @Autowired
    private IAlarmRepository alarmService;

    @MessageMapping("/alarm/{userId}")
    public void sendAlarmToUser(AlarmRequest request) {
        String userId = request.getUserId();
        String alarm = request.getAlarm();
        messagingTemplate.convertAndSendToUser(userId, "/queue/alarm", alarm);
    }
    
    @RequestMapping(value = "/sendAlarm", method = RequestMethod.POST)
    @ResponseBody
    public void sendAlarm(@RequestBody AlarmModel alarm) {
        alarmService.insertAlarm(alarm);
    }
    
	@GetMapping("/alarmlist")
	public String alarmList(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		List<AlarmModel> alarmList =alarmService.getAlarmList(userId);
		model.addAttribute("alarmList", alarmList);
		return "alarmList";
	}
    
}