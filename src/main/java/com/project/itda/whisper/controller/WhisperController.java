package com.project.itda.whisper.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.itda.common.dao.IUserRepository;
import com.project.itda.common.model.UserModel;
import com.project.itda.whisper.model.WhisperModel;

@Controller
public class WhisperController {
	
	@Autowired
	IUserRepository userRepository;
	
	@GetMapping("/whisper/inboximg")
	public String whisperInboxImg(Model model) {
	
		return "whisper/whisperInboxImg";
	}
	
	@GetMapping("/whisper/inboxlist")
	public String whisperInboxList(Model model) {
	
		return "whisper/whisperInboxList";
	}
	
	@GetMapping("/whisper/detail")
	public String whisperDetail(Model model) {
	
		return "whisper/whisperDetail";
	}
	
	@GetMapping("/whisper/outbox")
	public String whisperOutbox(Model model) {
	
		return "whisper/whisperOutbox";
	}
	
	@GetMapping("/whisper/writeform")
	public String whisperWrite(HttpSession session, Model model) {
		int famSeq = (int) session.getAttribute("famSeq");
		//가족 Id 불러오기 , 이름 출력
		List<UserModel> myFamily = userRepository.selectFamilyMembers(famSeq);
		//작성자 이름 설정
		UserModel loginUser = (UserModel) session.getAttribute("loginUser");
		String myName = loginUser.getUserName();
		
		model.addAttribute("myFamily", myFamily);
		model.addAttribute("myName",myName);
		
		return "whisper/whisperWrite";
	}
	
	@GetMapping("/whisper/main")
	public String whisperMain() {
		
		return "whisper/whisperInboxImg";
	}
	
	@PostMapping("/whisper/send")
	public Map<String, Object> sendWhisper(@RequestParam String receiver, @RequestParam String message, 
            @RequestParam(defaultValue = "direct") String option, 
            @RequestParam(required = false) String date, WhisperModel whisper, HttpSession session) {
		UserModel loginUser = (UserModel) session.getAttribute("loginUser");
		String sender = loginUser.getUserId();
		String whisperType = "";
		Map<String, Object> map = new HashMap<>();
		
		// 옵션 값에 따라 whisperType 설정
		if (option.equals("bomb")) {
		whisperType = "bomb";
		} else if (option.equals("reservation")) {
		whisperType = "reservation";
		} else {
		whisperType = "direct";
		}
		whisper.setWhisperType(whisperType);
		whisper.setSender(sender);
		return map;
		
	}
	
}
