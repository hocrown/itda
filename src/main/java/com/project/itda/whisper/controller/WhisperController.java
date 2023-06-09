package com.project.itda.whisper.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.itda.common.dao.IUserRepository;
import com.project.itda.common.model.UserModel;
import com.project.itda.whisper.service.IWhisperService;
import com.project.itda.whisper.model.WhisperModel;
/**
 * 
 * @author 윤준호
 * @since 2023-04-03
 *
 */
@Controller
public class WhisperController {
	
	@Autowired
	IUserRepository userService;
	
	@Autowired
	IWhisperService whisperService;
	
	@GetMapping("/whisper/inboximg")
	public String whisperInboxImg(HttpSession session, Model model) {
	
		String userId = (String) session.getAttribute("userId");
		List<WhisperModel> whisperList = whisperService.getWhisperList(userId);
		model.addAttribute("whisperList", whisperList);
		
		return "whisper/whisperInboxImg";
	}
	
	
	@GetMapping("/whisper/inboxlist")
	public String whisperInboxList(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
	    List<WhisperModel> whisperList = whisperService.getInboxList(userId);
	    
	    Map<Date, List<WhisperModel>> whisperByDate = whisperList.stream()
	    	    .collect(Collectors.groupingBy(w -> w.getSendDate()));

	    model.addAttribute("whisperByDate", whisperByDate);
		
		return "whisper/whisperInboxList";	
	}
	
	/**
	 * 
	 * @param whisperSeq 식별하기 위한 식별자
	 * @param model
	 * @return whisper 내용
	 * 
	 * 속마음 상세보기 메서드.
	 * type이 'bomb' 인 경우, 확인할 시 deleteWhipser를 통해 삭제하도록 한다.
	 */
	@GetMapping("/whisper/detail/{whisperSeq}")
	public String whisperDetail(@PathVariable("whisperSeq") int whisperSeq, Model model) {
		WhisperModel whisperDetail = whisperService.getWhisperDetail(whisperSeq);
	    if (whisperDetail != null && "bomb".equals(whisperDetail.getWhisperType())) {
	        whisperService.deleteWhisper(whisperSeq);
	    } else {
	        whisperService.checkWhisper(whisperSeq);
	    }
		model.addAttribute("whisper", whisperDetail);
		return "whisper/whisperDetail";
	}
	
	
	@GetMapping("/whisper/outbox")
	public String whisperOutbox(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		List<WhisperModel> whisperList = whisperService.getOutboxList(userId);
		
		Map<Date, List<WhisperModel>> whisperByDate = whisperList.stream()
				.collect(Collectors.groupingBy(w -> w.getSendDate()));
		
		model.addAttribute("whisperByDate", whisperByDate);
		
		return "whisper/whisperOutbox";
	}
	
	@GetMapping("/whisper/writeform")
	public String whisperWrite(HttpSession session, Model model) {
		int famSeq = (int) session.getAttribute("famSeq");
		//가족 Id 불러오기 , 이름 출력
		List<UserModel> myFamily = userService.selectFamilyMembers(famSeq);
		//작성자 이름 설정
		UserModel loginUser = (UserModel) session.getAttribute("loginUser");
		String myName = loginUser.getUserName();
		
		model.addAttribute("myFamily", myFamily);
		model.addAttribute("myName",myName);
		
		return "whisper/whisperWrite";
	}
	
	@GetMapping("/whisper/main")
	public String whisperMain(HttpSession session, Model model) {
		
		String userId = (String) session.getAttribute("userId");
		List<WhisperModel> whisperList = whisperService.getWhisperList(userId);
		model.addAttribute("whisperList", whisperList);
		
		return "whisper/whisperInboxImg";
	}
	
	/**
	 * 
	 * @param receiver 메세지 수신자
	 * @param message 전달 메세지
	 * @param option 전달 옵션
	 * @param senderNickname 메세지 발신자
	 * @param date 메세지 전송 날짜
	 * @param whisper 모델 객체
	 * @param session
	 * @return
	 * 
	 * 메세지 작성 메서드. 각 타입별로 visible을 설정하고 예약 메세지의 경우 0 으로 설정하여, 오라클 job scheduler를 통해 지정 날짜에 visible이 1로 변하게 된다.
	 */
	@ResponseBody
	@PostMapping("/whisper/send")
	public Map<String, Object> sendWhisper(@RequestParam String receiver, @RequestParam String message, 
            @RequestParam(name="option") String option, 
            @RequestParam(name="senderNickname") String senderNickname,
            @RequestParam(name="date", required = false) String date,
            WhisperModel whisper, HttpSession session) {
		UserModel loginUser = (UserModel) session.getAttribute("loginUser");
		String sender = loginUser.getUserId();
		String whisperType = "";
		int visible;
		Map<String, Object> map = new HashMap<>();
		try {
			// 옵션 값에 따라 whisperType 설정
			if (option.equals("bomb")) {
			whisperType = "bomb";
			visible = 1;
			} else if (option.equals("reservation")) {
			whisperType = "reservation";
			visible = 0;
			} else {
			whisperType = "direct";
			visible = 1;
			}
			whisper.setSender(sender);
			whisper.setWhisperType(whisperType);
			whisper.setVisible(visible);
			
	        // date 값이 전달되지 않은 경우, 오늘 날짜로 설정
	        Date reserveDate = null;
	        if (date == null || date.isEmpty()) {
	            reserveDate = new Date();
	        } else {
	            reserveDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
	        }
	        whisper.setReserveDate(reserveDate);
			whisperService.insertWhisper(whisper);
			map.put("result","success");
			map.put("message", "속마음이 전송되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "error");
			map.put("message", "전송 실패. 다시 시도해주세요.");
		}
		
		return map;
		
	}
	
	@ResponseBody
	@PostMapping("/whisper/delete")
	public void deleteWhisper(@RequestParam int whisperSeq) {
	    whisperService.deleteWhisper(whisperSeq);
	}
	
}
