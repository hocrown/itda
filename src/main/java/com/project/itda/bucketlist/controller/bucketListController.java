package com.project.itda.bucketlist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.bucketlist.model.BucketReplyModel;
import com.project.itda.bucketlist.service.IBucketListService;
import com.project.itda.common.CheckAuth;
import com.project.itda.common.model.UserModel;
import com.project.itda.common.service.IUserService;

@Controller
public class bucketListController {

	@Autowired
	IBucketListService bucketlistService;

	@Autowired
	IUserService userService;
	
	
	// 버킷리스트 출력
	@GetMapping("/bucket/bucketview")
	public String BucketListView(Model model, HttpSession session) {
		// 세션으로부터 familySeq를 받아옴
		int familySeq = (int) session.getAttribute("famSeq");
		// 받아온 해당 Seq 가족에 대한 버킷리스트를 bucketlist에 담아줌.
		List<BucketListModel> bucketlist = bucketlistService.getFamilyBucket(familySeq);
		List<String> base64ImageDataList = new ArrayList<>();
		for (BucketListModel bucket : bucketlist) {
	        byte[] fileData = bucket.getFileData();
	        String base64ImageData = Base64.getEncoder().encodeToString(fileData);
	        base64ImageDataList.add(base64ImageData);
	    }
		model.addAttribute("bucketlist", bucketlist);
		model.addAttribute("base64ImageDataList", base64ImageDataList);
		Date currentDate = new Date();
		model.addAttribute("currentDate", currentDate);
		List<UserModel> myFam = userService.getFamilyMembers(familySeq);
		model.addAttribute("myFam", myFam);

		return "bucketList/bucketListView";
	}

	// 가족 버킷리스트 상세 정보
	@GetMapping("/bucket/bucketdetail")
	public String bucketDetail(Model model, HttpSession session, @RequestParam("bucketSeq") int bucketSeq) {
		//로그인 유저인지 검증
		CheckAuth.checkLogin(session);
		
		// 이전 페이지에서 클릭한 bucket의 Seq를 요청하여 해당 bucket에 대한 상세 정보를 담아둠
		BucketListModel bucketOne = bucketlistService.getBucketDetail(bucketSeq);
		
		
		    byte[] fileData = bucketOne.getFileData();
	        String base64ImageData = Base64.getEncoder().encodeToString(fileData);
	    
		int familySeq = (int) session.getAttribute("famSeq");
		int writerFamilySeq = bucketOne.getFamilySeq();
		
		//로그인 한 유저가 접근할 수 있는 bucketList인지 검증
		CheckAuth.checkFamilyMember(session, writerFamilySeq);
		// 해당 버킷리스트에 달린 댓글들의 정보를 담아둠
		List<BucketReplyModel> reply = bucketlistService.getBucketReply(bucketSeq);
		// bucketOne이라는 이름으로 전송
		model.addAttribute("bucketOne", bucketOne);
		// reply라는 이름으로 전송
		model.addAttribute("reply", reply);
		List<UserModel> myFam = userService.getFamilyMembers(familySeq);
		model.addAttribute("myFam", myFam);
		int replyCount = bucketlistService.countBucketOneReply(bucketSeq);
		model.addAttribute("replyCount", replyCount);
		model.addAttribute("base64ImageData", base64ImageData);
		return "bucketList/bucketDetail";
	}
	
	
	
	// 유저ID에 따른 버킷리스트 목록 -> ajax로 데이터 보내기
	@GetMapping("/bucket/bucketlistz")
	@ResponseBody
	public List<BucketListModel> getBucketListByUserId(@RequestParam String userId) {
		System.out.println(userId);
		// userId를 이용해서 bucketList를 가져오는 로직 구현
		List<BucketListModel> bucketList = bucketlistService.getPersonalBucket(userId);
		System.out.println(bucketList);
		return bucketList;
	}

	// 버킷리스트 삭제 시 보이지 않도록 처리
	@GetMapping("/bucket/invisibleaction")
	public String invisibleBucketAction(@RequestParam("bucketSeq") int bucketSeq) {
		bucketlistService.BucketInvisible(bucketSeq);

		return "redirect:/bucket/bucketview";
	}

	// 버킷리스트 등록 페이지
	@GetMapping("/bucket/addbucket")
	public String addBucket(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		
		return "bucketList/addBucket";
	}

	// 버킷리스트 등록 액션
	@PostMapping("/bucket/addbucketaction")
	public String addFamilyBucketAction(HttpSession session, BucketListModel bucketListModel) throws IOException {

		String userId = (String) session.getAttribute("userId");
		int famSeq = (int) session.getAttribute("famSeq");

		bucketListModel.setUserId(userId);
		bucketListModel.setFamilySeq(famSeq);
		
		MultipartFile mfile = bucketListModel.getFile();
		
		bucketListModel.setFileName(mfile.getOriginalFilename());
		bucketListModel.setFileData(mfile.getBytes());
		
		bucketlistService.addBucketList(bucketListModel);
		
		return "redirect:/bucket/bucketview";
	}

	
	// 버킷리스트 수정 페이지
	@GetMapping("/bucket/modifybucket")
	public String modifyBucket(@RequestParam("bucketSeq") int bucketSeq, Model model) {
		BucketListModel bucketOne = bucketlistService.getBucketDetail(bucketSeq);
		byte[] fileData = bucketOne.getFileData();
        String base64ImageData = Base64.getEncoder().encodeToString(fileData);

		model.addAttribute("bucketOne", bucketOne);
		model.addAttribute("base64ImageData", base64ImageData);
		return "bucketList/modifyBucket";
	}
	
	// 버킷리스트 수정 액션
	@PostMapping("/bucket/modifyaction")
	public String modifyBucketAction(BucketListModel bucketListModel) throws Exception {
		
		MultipartFile mfile = bucketListModel.getFile();
		
		bucketListModel.setFileName(mfile.getOriginalFilename());
		bucketListModel.setFileData(mfile.getBytes());
		
		bucketlistService.updateBucket(bucketListModel);
		
		return "redirect:/bucket/bucketview";
	}

	// 버킷리스트 완료처리
	@GetMapping("/bucket/successaction")
	public String successBucketAction(@RequestParam("bucketSeq") int bucketSeq) {
		bucketlistService.BucketSuccess(bucketSeq);

		return "redirect:/bucket/bucketview";
	}
		
	// --------------------------------------------------------------------------------------------------------

	
	// 댓글 등록 액션
	@PostMapping("/bucket/addbucketreplyaction")
	public String addBucketReplyAction(HttpSession session , @RequestParam("bucketSeq") int bucketSeq, BucketReplyModel bucketReplyModel) {

		String userId = (String) session.getAttribute("userId");

		bucketReplyModel.setUserId(userId);
		bucketReplyModel.setBucketSeq(bucketSeq);
		bucketlistService.addBucketReply(bucketReplyModel);
		
		return "redirect:/bucket/familybucketdetail?bucketSeq=" + bucketSeq;
	}
	
	
	// 댓글 수정
	@PostMapping("/bucket/modifyreplyaction")
	public String modifyReplyAction(BucketReplyModel bucketReplyModel, @RequestParam("bucketSeq") int bucketSeq) {
		bucketlistService.updateReply(bucketReplyModel);
		
		return "redirect:/bucket/familybucketdetail?bucketSeq=" + bucketSeq;
	}
	
	// 댓글 삭제
	@PostMapping("/bucket/deletereplyaction")
	public String deleteReplyAction(int bucketReplySeq, @RequestParam("bucketSeq") int bucketSeq) {
		bucketlistService.deleteReply(bucketReplySeq);
		
		return "redirect:/bucket/familybucketdetail?bucketSeq=" + bucketSeq;
	}

}
