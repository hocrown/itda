package com.project.itda.common.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.itda.common.model.UserModel;
import com.project.itda.common.service.IUserService;
import com.project.itda.dailyquestion.controller.DailyQuestionController;

@Controller
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	DailyQuestionController dailyQuestionController;
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@GetMapping("/user/login")
	public String login(Model model) {

		return "user/login";
	}

	@PostMapping("/user/login")
	@ResponseBody
	public Map<String, Object> login(@RequestBody UserModel user, HttpSession session, Model model) {
		Map<String, Object> map = new HashMap<>();

		try {
			UserModel loginUser = userService.selectUser(user.getUserId(), user.getUserPw());
			if (loginUser != null && loginUser.getUserId() != null) {
				session.setAttribute("userId", loginUser.getUserId());
				session.setAttribute("loginUser", loginUser);
				session.setAttribute("famSeq", loginUser.getFamilySeq());
				 // DailyQuestionController의 getDailyQuestion() 메소드 호출
	            String loginUserId = loginUser.getUserId();

	            dailyQuestionController.getDailyQuestion(loginUserId, session);
	            
				map.put("result", "success");
			} else {
				map.put("result", "fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "error");
		}
		return map;
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

	/**
	 * @author 윤준호
	 * @since 2023-03-27
	 * @param userId
	 * @return map 유저의 id가 중복된 값인지 검증하여, 결과문을 result에 담아서 넘겨준다.
	 */
	@RequestMapping(value = "/user/checkid", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkId(@RequestParam("userId") String userId) {
		Map<String, Object> map = new HashMap<>();
		try {
			// userId 중복 체크
			int isExist = userService.checkUserId(userId);
			if (isExist == 1) {
				map.put("result", "fail");
			} else {
				map.put("result", "success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "error");
		}
		return map;
	}

	/**
	 * @author 윤준호
	 * @since 2023-03-27
	 * @param famCode 생성된 가족 코드
	 * @return ajax 요청에 대한 응답으로 success 를 전달한다.
	 */
	@RequestMapping(value = "/user/approve", method = RequestMethod.PUT)
	@ResponseBody
	public String approveFamCode(@RequestParam String famCode) {
		userService.approveFamCode(famCode);
		return "success";
	}

	/**
	 * @author 윤준호
	 * @since 2023-03-27
	 * @param user 회원가입 폼에서 작성된 user정보(sessionStorage를 통해 취합 후, ajax로 전달)
	 * @return ajax 요청에 대한 응답으로 insertUser 성공 시, success를 전달 
	 */
	@PostMapping("/user/signup")
	@ResponseBody
	@Transactional
	public String insertUser(@RequestBody UserModel user) {
		try {
			// 생년월일을 바탕으로 나이 계산 후 userModel에 설정
			LocalDate birthdate = LocalDate.of(user.getYear(), user.getMonth(), user.getDay());
			LocalDate today = LocalDate.now();
			int age = Period.between(birthdate, today).getYears();
			user.setUserAge(age);
			user.setUserBirth(birthdate);
			// insertFamily 메소드로 family 테이블에 데이터를 입력합니다.
			String userId = user.getUserId();
			String famCode = user.getFamCode();
			// 가족그룹의 생성자인지 검증
			if ("yes".equals(user.getApprove())) {
				userService.insertFamily(userId, famCode);
			}
			int famSeq = userService.selectFamilySeq(famCode);
			// insertUser 메소드로 itda_user 테이블에 데이터를 입력합니다.
			user.setFamilySeq(famSeq);
			userService.insertUser(user);
			// 데이터 입력에 성공하면 "success" 문자열을 반환합니다.
			return "success";
		} catch (DuplicateKeyException e) {
			// 중복된 데이터 입력 시 "duplicate" 문자열을 반환합니다.
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "duplicate";
		} catch (Exception e) {
			e.printStackTrace();
			// 기타 예외 발생 시 "fail" 문자열을 반환합니다.
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "fail";
		}
	}
	
	@GetMapping("/user/mypage")
	public String myPage(Model model) {

		return "user/myPage";
	}
	
	@GetMapping("/user/myinfo")
	public String myInfo(Model model) {

		return "user/myInfo";
	}
	
	@GetMapping("/user/myfaminfo")
	public String myFamInfo(Model model) {

		return "user/myFamInfo";
	}
	
}
