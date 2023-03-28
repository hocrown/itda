package com.project.itda.common.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.itda.common.model.FamilyModel;
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
	
	@PostMapping("/user/login")
	public String userLogin(Model model) {
		return null;
		
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
	
	@GetMapping("/user/back")
	public String backStep(Model model, @RequestParam(name = "famCode") String famCode) {
		model.addAttribute("famCode", famCode);
		return "user/signupFamCode";
	}
	
	@GetMapping("/user/back1")
	public String backStep1(Model model, @RequestParam(name = "id") String id) {
		model.addAttribute("id", id);
		return "user/signupStep1";
	}
	@GetMapping("/user/back2")
	public String backStep2(Model model) {
		return "user/signupStep2";
	}

	@RequestMapping(value="/user/checkid", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> checkId(@RequestParam("userId") String userId){
		Map<String, Object> map = new HashMap<>();
		try {
			//userId 중복 체크
			int isExist = userService.checkUserId(userId);
			if(isExist == 1) {
				map.put("result", "fail");
			} else {
				map.put("result", "success");
			}
		}catch (Exception e) {
			e.printStackTrace();
			map.put("result", "error");
		}
		return map;
	}
	
	
	
	@RequestMapping(value="/user/approve", method=RequestMethod.PUT)
	@ResponseBody
	public String approveFamCode(@RequestParam String famCode) {
	    userService.approveFamCode(famCode);
	    return "success";
	}
	    
	@PostMapping("/user/signup")
	@ResponseBody
	@Transactional
	public String insertUser(@RequestBody UserModel user) {
	    try {
	        // 생년월일을 바탕으로 나이 계산 후 userModel에 설정
	        LocalDate birthdate = LocalDate.of(user.getYear(), user.getMonth(), user.getDay());
	        LocalDate today = LocalDate.now();
	        int age = Period.between(birthdate, today).getYears();
	        System.out.println(age);
	        user.setUserAge(age);
	        user.setUserBirth(birthdate);
	        // insertFamily 메소드로 family 테이블에 데이터를 입력합니다.
	        String userId = user.getUserId();
	        System.out.println(userId);
	        System.out.println(user.getFamCode());
	        String famCode = user.getFamCode();
	        userService.insertFamily(userId, famCode);
	        System.out.println("insertFam 성공");
	        int famSeq = userService.selectFamilySeq(userId); 
	        System.out.println("selectFamSeq"+famSeq);
	        // insertUser 메소드로 itda_user 테이블에 데이터를 입력합니다.
	        user.setFamilySeq(famSeq);
	        System.out.println(user.getFamilySeq());
	        userService.insertUser(user);
	        System.out.println("insertUser성공");
	        // 데이터 입력에 성공하면 "success" 문자열을 반환합니다.
	        return "success";
	    } catch (DuplicateKeyException e) {
	        // 중복된 데이터 입력 시 "duplicate" 문자열을 반환합니다.
	        return "duplicate";
	    } catch (Exception e) {
	    	e.printStackTrace();
	        // 기타 예외 발생 시 "fail" 문자열을 반환합니다.
	        return "fail";
	    }
	}
}
