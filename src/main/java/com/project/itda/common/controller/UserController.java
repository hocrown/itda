package com.project.itda.common.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.itda.common.model.UserModel;
import com.project.itda.common.service.IUserService;


@Controller
public class UserController {
	
	@Autowired
	IUserService userService;

	
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
	
	@PostMapping("/api/invite-code")
	@ResponseBody
	public void saveInviteCode(@RequestBody String inviteCode) {
		
	}

	@PostMapping("/api/user/checkId")
    public boolean checkId(@RequestBody Map<String, String> request) {
        String userId = request.get("userId");
        return !userService.isUserIdDuplicated(userId);
    }
}