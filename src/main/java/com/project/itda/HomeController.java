package com.project.itda;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String landingPage(Model model) {
		model.addAttribute("message", "Welcome");
		return "landingPage";
	}
	
	@GetMapping("/mainimg")
	public String mainImg(Model model) {
		
		return "mainImg";
	}
	
	@GetMapping("/mainlist")
	public String mainList(Model model) {
		
		return "mainList";
	}
	
	@GetMapping("/alarm")
	public String alarm(Model model) {
		return "alarmList";
	}

}