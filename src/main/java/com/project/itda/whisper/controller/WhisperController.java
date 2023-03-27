package com.project.itda.whisper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WhisperController {
	
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
	
	@GetMapping("/whisper/write")
	public String whisperWrite(Model model) {
	
		return "whisper/whisperWrite";
	}
}
