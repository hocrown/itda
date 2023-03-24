package com.project.itda.common.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.itda.common.model.UserModel;
import com.project.itda.common.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService;

	@GetMapping("/user/login")
	public String login(Model model) {
	
		return "user/login";
	}
	
	@GetMapping("/user/signupfamcode")
	public String signupFamCode(Model model) {
	
		return "user/signupFamCode";
	}
	
	@GetMapping("/user/signupstep1")
	public String signupStep1(Model model) {
	
		return "user/signupStep1";
	}
	
	@GetMapping("/user/signupstep2")
	public String signupStep2(Model model) {
	
		return "user/signupStep2";
	}
	
	@GetMapping("/user/signupstep3")
	public String signupStep3(Model model) {
	
		return "user/signupStep3";
	}
	
	@RequestMapping(value="/user/insert", method=RequestMethod.GET)
	public String insertUser(Model model) {
		model.addAttribute("user", new UserModel());
		return "user/form";
	}
	
	@RequestMapping(value="/user/insert", method=RequestMethod.POST)
	public String insertUser(UserModel user, BindingResult result, HttpSession session, Model model) {
//		if(result.hasErrors()) {
//			model.addAttribute("user", user);
//			return "user/form";
//		}
//		try {
//			if(!user.getPassword().equals(user.getPassword2())) {
//				model.addAttribute("member", user);
//				model.addAttribute("message", "MEMBER_PW_RE");
//				return "member/form";
//			}
			userService.insertUser(user);
//		}catch(DuplicateKeyException e) {
//			user.setUserId(null);
//			model.addAttribute("member", user);
//			model.addAttribute("message", "ID_ALREADY_EXIST");
//			return "member/form";
//		}
//		session.invalidate();
		return "home";
	}
	

	
	
}
