package com.project.itda.bucketlist.controller;

import java.io.File;
import java.io.FileInputStream;
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

		// 이미지 데이터를 Base64로 인코딩하여 저장할 리스트 생성
		List<String> base64ImageDataList = new ArrayList<>();

		// 버킷리스트의 각 항목에 대해 이미지 데이터를 Base64로 인코딩하고 리스트에 추가
		for (BucketListModel bucket : bucketlist) {
			byte[] fileData = bucket.getFileData();
			String base64ImageData = Base64.getEncoder().encodeToString(fileData);
			base64ImageDataList.add(base64ImageData);
		}

		// 모델에 버킷리스트 및 이미지 데이터 리스트 추가
		model.addAttribute("bucketlist", bucketlist);
		model.addAttribute("base64ImageDataList", base64ImageDataList);

		// 현재 날짜를 모델에 추가
		Date currentDate = new Date();
		model.addAttribute("currentDate", currentDate);

		// 가족 구성원 정보를 가져옴
		List<UserModel> myFam = userService.getFamilyMembers(familySeq);

		// 모델에 가족 구성원 정보 추가
		model.addAttribute("myFam", myFam);

		// 버킷리스트 뷰 페이지 반환
		return "bucketList/bucketListView";
	}

	// 유저ID에 따른 버킷리스트 목록 -> ajax로 데이터 보내기
	@GetMapping("/bucket/bucketlistz")
	@ResponseBody
	public List<BucketListModel> getBucketListByUserId(@RequestParam(required = false) String userId) {
		// userId에 대한 bucketList를 가져옴
		List<BucketListModel> bucketList = bucketlistService.getPersonalBucket(userId);
		return bucketList;
	}

	// 가족 버킷리스트 상세 정보
	@GetMapping("/bucket/bucketdetail")
	public String bucketDetail(Model model, HttpSession session, @RequestParam("bucketSeq") int bucketSeq) {
		// 로그인 유저인지 검증
		CheckAuth.checkLogin(session);

		// 선택한 버킷시퀀스를 사용하여 상세 정보를 가져옴
		BucketListModel bucketOne = bucketlistService.getBucketDetail(bucketSeq);

		// 버킷의 이미지 데이터를 base64로 인코딩
		byte[] fileData = bucketOne.getFileData();
		String base64ImageData = Base64.getEncoder().encodeToString(fileData);

		// 세션에서 가족 시퀀스 번호를 가져옴
		int familySeq = (int) session.getAttribute("famSeq");
		int writerFamilySeq = bucketOne.getFamilySeq();
		String loginUser = (String) session.getAttribute("userId");
		// 로그인한 사용자가 접근할 수 있는 버킷리스트인지 확인
		CheckAuth.checkFamilyMember(session, writerFamilySeq);

		// 선택한 버킷리스트에 달린 댓글 정보를 가져옴
		List<BucketReplyModel> reply = bucketlistService.getBucketReply(bucketSeq);
		
		model.addAttribute("loginUser", loginUser);

		// bucketOne을 모델에 추가
		model.addAttribute("bucketOne", bucketOne);

		// reply를 모델에 추가
		model.addAttribute("reply", reply);

		// 가족 멤버 정보를 가져옴
		List<UserModel> myFam = userService.getFamilyMembers(familySeq);
		model.addAttribute("myFam", myFam);

		// 선택한 버킷리스트의 댓글 개수를 가져옴
		int replyCount = bucketlistService.countBucketOneReply(bucketSeq);
		model.addAttribute("replyCount", replyCount);

		// base64로 인코딩된 이미지 데이터를 모델에 추가
		model.addAttribute("base64ImageData", base64ImageData);

		return "bucketList/bucketDetail";
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

		return "bucketList/addBucket";
	}
	
	private byte[] getDefaultBucketImage() {
		try {
	        File file = new File("src/main/resources/static/image/itdaLogo.png");
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

	// 버킷리스트 등록 액션
	@PostMapping("/bucket/addbucketaction")
	public String addFamilyBucketAction(HttpSession session, BucketListModel bucketListModel) throws IOException {
		
		String userId = (String) session.getAttribute("userId");
		int famSeq = (int) session.getAttribute("famSeq");

		try {
			bucketListModel.setUserId(userId);
			bucketListModel.setFamilySeq(famSeq);
			
			
			MultipartFile mfile = bucketListModel.getFile();
			
			if(mfile !=null && !mfile.isEmpty()) {
				bucketListModel.setFileName(mfile.getOriginalFilename());
				bucketListModel.setFileData(mfile.getBytes());

			} else if(bucketListModel.getFileData() != null && bucketListModel.getFileData().length>0) {
				bucketListModel.setFileData(bucketListModel.getFileData());
				bucketListModel.setFileName(bucketListModel.getFileName());
			} else {
				bucketListModel.setFileData(getDefaultBucketImage());
				bucketListModel.setFileName("dafaultBucketImage.png");
			}

			bucketlistService.addBucketList(bucketListModel);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		if (mfile.isEmpty()) {
			bucketlistService.updateBucketTwo(bucketListModel);
			// mfile 처리 작업 수행...
		} else {
			// mfile이 null인 경우 처리 작업 수행 (예: 기존 파일 유지)
			bucketListModel.setFileName(mfile.getOriginalFilename());
			bucketListModel.setFileData(mfile.getBytes());

			bucketlistService.updateBucket(bucketListModel);

		}

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
	public String addBucketReplyAction(HttpSession session, @RequestParam("bucketSeq") int bucketSeq,
			BucketReplyModel bucketReplyModel) {

		String userId = (String) session.getAttribute("userId");

		bucketReplyModel.setUserId(userId);
		bucketReplyModel.setBucketSeq(bucketSeq);
		bucketlistService.addBucketReply(bucketReplyModel);

		return "redirect:/bucket/bucketdetail?bucketSeq=" + bucketSeq;
	}

	// 댓글 수정
	@PostMapping("/bucket/modifyreplyaction")
	public String modifyReplyAction(BucketReplyModel bucketReplyModel, @RequestParam("bucketSeq") int bucketSeq) {
		bucketlistService.updateReply(bucketReplyModel);

		return "redirect:/bucket/bucketdetail?bucketSeq=" + bucketSeq;
	}

	// 댓글 삭제
	@PostMapping("/bucket/deletereplyaction")
	public String deleteReplyAction(int bucketReplySeq, @RequestParam("bucketSeq") int bucketSeq) {
		bucketlistService.deleteReply(bucketReplySeq);

		return "redirect:/bucket/bucketdetail?bucketSeq=" + bucketSeq;
	}

}
