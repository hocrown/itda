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

	@GetMapping("/landing")
	public String landingPage() {
		return "landingPage";
	}
	
	@GetMapping("/")
	public String intro1() {
		return "intro1";
	}
	
	@GetMapping("/intro2")
	public String intro2() {
		return "intro2";
	}
	
	@GetMapping("/intro3")
	public String intro3() {
		return "intro3";
	}
	
	@GetMapping("/intro4")
	public String intro4() {
		return "intro4";
	}
	
	@GetMapping("/intro5")
	public String intro5() {
		return "intro5";
	}
	
	@GetMapping("/intro6")
	public String intro6() {
		return "intro6";
	}
	
	@GetMapping("/intro7")
	public String intro7() {
		return "intro7";
	}
	
	@GetMapping("/mainimg")
	public String mainImg(Model model) {
		return "mainImg";
	}
	
	@GetMapping("/mainlist")
	public String mainList(Model model) {
		
		return "mainList";
	}
	
}