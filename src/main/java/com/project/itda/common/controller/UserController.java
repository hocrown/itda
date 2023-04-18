package com.project.itda.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.common.model.FamilyModel;
import com.project.itda.common.model.NickNameModel;
import com.project.itda.common.model.UserModel;
import com.project.itda.common.service.IUserService;
import com.project.itda.dailyquestion.controller.DailyQuestionController;
import com.project.itda.dailyquestion.model.DailyQuestionModel;
import com.project.itda.dailyquestion.service.IDailyQuestionService;

@Controller
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	DailyQuestionController dailyQuestionController;
	
	@Autowired
	IDailyQuestionService dailyService;
	
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
			// NickName 설정 (초기에는 사용자 이름으로 임의로 설정)
			user.setNickName(user.getUserName());
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
	
/*-----------------------ㅡMy Page---------------------------*/	
	@GetMapping("/user/mypage")
	public String myPage(Model model) {

		return "user/myPage";
	}
	
	@GetMapping("/user/myinfo")
	public String myInfo(HttpSession session, Model model) {
		UserModel loginUser = (UserModel) session.getAttribute("loginUser");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		LocalDate localDate = loginUser.getUserBirth();
		String dateStr = localDate.format(dateFormat);

		model.addAttribute("dateStr", dateStr);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		String dateDot = localDate.format(formatter);
		   
		 byte[] fileData = loginUser.getUserImageData();
		    if (fileData == null) {
		        fileData = getDefaultPrivateProfileImage();
		    }
		    String base64ImageData = Base64.getEncoder().encodeToString(fileData);
	    
		
        model.addAttribute("dateDot", dateDot);
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("base64ImageData", base64ImageData);
		return "user/myInfo";
	}
	
	private byte[] getDefaultPrivateProfileImage() {
		try {
	        File file = new File("src/main/resources/static/image/profile.png");
	        FileInputStream fis = new FileInputStream(file);
	        byte[] imageData = new byte[(int) file.length()];
	        fis.read(imageData);
	        fis.close();
	        return imageData;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new byte[0];
	    }
	}
	
	private String getDefaultProfileImage() {
	    try {
	        File file = new File("src/main/resources/static/image/profile.png");
	        FileInputStream fis = new FileInputStream(file);
	        byte[] imageData = new byte[(int) file.length()];
	        fis.read(imageData);
	        fis.close();
	        return Base64.getEncoder().encodeToString(imageData);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "";
	    }
	}

	private byte[] getDefaultFamilyImage() {
		try {
	        File file = new File("src/main/resources/static/image/profile.png");
	        FileInputStream fis = new FileInputStream(file);
	        byte[] imageData = new byte[(int) file.length()];
	        fis.read(imageData);
	        fis.close();
	        return imageData;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new byte[0];
	    }
	}
	
	@GetMapping("/user/myfaminfo")
	public String myFamInfo(HttpSession session, Model model) {
	    UserModel loginUser = (UserModel) session.getAttribute("loginUser");
	    
	    List<UserModel> familyMember = userService.getFamilyMembersWithNickName(loginUser);
	    List<String> encodedProfileImages = new ArrayList<>();
	    String defaultProfileImage = getDefaultProfileImage();
	    for (UserModel member : familyMember) {
	        byte[] imageData = member.getUserImageData();
	        String encodedImageData;
	        if (imageData != null) {
	            encodedImageData = Base64.getEncoder().encodeToString(imageData);
	        } else {
	            encodedImageData = defaultProfileImage;
	        }
	        encodedProfileImages.add(encodedImageData);
	    }
	    
	    String famCode = userService.getFamCode(loginUser.getFamilySeq());
	    
	    model.addAttribute("famCode", famCode);
	    model.addAttribute("familyMember", familyMember);
	    model.addAttribute("profileImage", encodedProfileImages);
	        
	    return "user/myFamInfo";
	}
	
	
	@GetMapping("/user/requestbox")
	public String requestBox() {

		return "user/requestBox";
	}
	
	@ResponseBody
	@PostMapping("/user/requestquestion")
	public String requestQuestion(HttpSession session, @RequestBody DailyQuestionModel requestQuestion) {
		UserModel loginuser = (UserModel) session.getAttribute("loginUser");
		int familySeq = loginuser.getFamilySeq();
		String userId = loginuser.getUserId();
		System.out.println(requestQuestion.getType());
		int visible = requestQuestion.getType().equals("family") ? 1 : 0;
		System.out.println(visible);
		requestQuestion.setVisible(visible);
		requestQuestion.setWriter(userId);
		requestQuestion.setFamilySeq(familySeq);
		
		dailyService.insertQuestion(requestQuestion);
		
		return "질문 등록이 완료되었습니다.";
	}
	
	
	@PostMapping("/user/updateUserInfo")
	@ResponseBody
	public String updateUserInfo(String userPw, String userAddress, String userAddressDetail,
	        String userPhone, String email, String nickName, MultipartFile file, HttpSession session) {
	    try {
	        UserModel user = (UserModel) session.getAttribute("loginUser");
	        user.setUserPw(userPw);
	        user.setEmail(email);
	        user.setUserAddress(userAddress);
	        user.setUserAddressDetail(userAddressDetail);
	        user.setUserPhone(userPhone);
	        user.setNickName(nickName);

	       
	        
	        if (file != null && !file.isEmpty()) {
	            String filename = file.getOriginalFilename();
	            user.setUserImageName(filename);
	            user.setUserImageData(file.getBytes());
	        } else if (user.getUserImageData() != null && user.getUserImageData().length > 0) {
	            // 이미지를 업데이트하지 않는 경우, 기존의 이미지 파일 이름과 데이터를 사용합니다.
	            user.setUserImageName(user.getUserImageName());
	            user.setUserImageData(user.getUserImageData());
	        } else {
	            // 기존 이미지가 없는 경우 기본 이미지를 사용합니다.
	            user.setUserImageName("defaultProfile.png");
	            user.setUserImageData(getDefaultPrivateProfileImage());
	        }

	        userService.updateUserInfo(user);

	        return "success";
	    } catch (Exception e) {
	        e.printStackTrace();

	        return "fail";
	    }
	}
	
	 // 가족 프로필 이미지 업로드
    @PostMapping("/user/updateFamilyProfile")
    @ResponseBody
    public Map<String, Object> updateFamilyProfile(@RequestPart("profileImage") MultipartFile profileImage, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        try {
        	String userId = (String) session.getAttribute("userId");
            FamilyModel family = userService.getFamilyByUserId(userId);

            if (profileImage != null && !profileImage.isEmpty()) {
                String filename = profileImage.getOriginalFilename();
                family.setFamilyFileName(filename);
                family.setFamilyFileData(profileImage.getBytes());
            } else if (family.getFamilyFileData() != null && family.getFamilyFileData().length > 0) {
                family.setFamilyFileName(family.getFamilyFileName());
                family.setFamilyFileData(family.getFamilyFileData());
            } else {
                family.setFamilyFileName("defaultProfile.png");
                family.setFamilyFileData(getDefaultFamilyImage());
            }

            userService.updateFamilyProfile(family);

            response.put("success", true);
            response.put("imageUrl", family.getFamilyFileName());
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("imageUrl", "");
        }
        return response;
    }
	
    // 가족 멤버 닉네임 수정
    @PostMapping("/user/updateFamilyMemberNickname")
    @ResponseBody
    public Map<String, Object> updateFamilyMemberNickname(@RequestParam("targetUserId") String targetUserId, @RequestParam("targetNickName") String targetNickName, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        try {
            UserModel loginUser = (UserModel) session.getAttribute("loginUser");

            if (loginUser.getUserId().equals(targetUserId)) {
                loginUser.setNickName(targetNickName);
                userService.updateUserInfo(loginUser);
            } else {
            	String userId = (String) session.getAttribute("userId");
                boolean success = userService.updateFamilyNickName(targetUserId, targetNickName, userId);
                if (!success) {
                    response.put("success", false);
                    response.put("message", "닉네임 수정에 실패했습니다.");
                    return response;
                }
            }

            response.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "닉네임 수정 중 오류가 발생했습니다");
        }
        return response;
    }
	
	
	
	@RequestMapping("/user/logout")
	public String logout(HttpSession session) {
	// 세션을 만료시킴
	session.invalidate();
	// 첫 페이지로 리다이렉트
	return "redirect:/";
	}
	
}
