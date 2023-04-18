package com.project.itda;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.function.ServerRequest.Headers;

@Controller
public class HomeController {

	@GetMapping("/")
	public String landingPage(Model model) {
		model.addAttribute("message", "Welcome");
		return "landingPage";
	}
	
	@GetMapping("/mainimg")
	public String mainImg(Model model) {
		HttpHeaders header = new HttpHeaders(); 
		return "mainImg";
	}
	
	@GetMapping("/mainlist")
	public String mainList(Model model) {
		
		return "mainList";
	}
}