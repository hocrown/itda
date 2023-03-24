package com.project.itda;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "main";
	}
	
  @GetMapping("/signup")
  public String signup() {
    return "signup";
  }

  @PostMapping("/signup/complete")
  public String signupComplete() {
    return "redirect:/login.jsp";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

}