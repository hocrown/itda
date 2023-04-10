package com.project.itda.bucketlist.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.bucketlist.model.BucketReplyModel;
import com.project.itda.bucketlist.service.IBucketListService;
import com.project.itda.common.model.UserModel;
import com.project.itda.common.service.IUserService;

@Controller
public class bucketListController {

	@Autowired
	IBucketListService bucketlistService;

	@Autowired
	IUserService userService;

	// 가족 버킷리스트 전체 출력
	@GetMapping("/bucket/familybucket")
	public String familyBucket(Model model, HttpSession session) {
		// 세션으로부터 familySeq를 받아옴
		int familySeq = (int) session.getAttribute("famSeq");
		// 받아온 해당 Seq 가족에 대한 버킷리스트를 bucketlist에 담아줌.
		List<BucketListModel> bucketlist = bucketlistService.getFamilyBucket(familySeq);
		// 담겨진 리스트를 familyBucket.jsp에서 bucketlist라는 이름으로 사용할 수 있게함.
		model.addAttribute("bucketlist", bucketlist);
		// --------------------이 밑으론 테스트 코드----------------------------------
		List<String> myFam = userService.getFamilyUserIds(familySeq);
		model.addAttribute("myFam", myFam);

		return "bucketList/familyBucket";
	}

	// 가족 버킷리스트 상세 정보
	@GetMapping("/bucket/familybucketdetail")
	public String familyBucketDetail(Model model, HttpSession session, @RequestParam("bucketSeq") int bucketSeq) {
		// 이전 페이지에서 클릭한 bucket의 Seq를 요청하여 해당 bucket에 대한 상세 정보를 담아둠
		int familySeq = (int) session.getAttribute("famSeq");
		BucketListModel bucketOne = bucketlistService.getFamilyBucketDetail(bucketSeq);
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
		return "bucketList/familyBucketDetail";
	}

	@GetMapping("/bucket/personalbucket")
	public String personalBucket(Model model, @RequestParam("userId") String userId) {

		List<BucketListModel> bucketlist = bucketlistService.getPersonalBucket(userId);

		model.addAttribute("bucketlist", bucketlist);

		return "bucketList/personalBucket";
	}

	// 버킷리스트 삭제 시 보이지 않도록 처리
	@GetMapping("/bucket/invisibleaction")
	public String invisibleBucketAction(@RequestParam("bucketSeq") int bucketSeq) {
		bucketlistService.BucketInvisible(bucketSeq);

		return "redirect:/bucket/bucketview";
	}

	// 버킷리스트 등록 페이지
	@GetMapping("/bucket/addfamilybucket")
	public String addBucket(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		
		return "bucketList/addFamilyBucket";
	}

	// 버킷리스트 등록 액션
	@PostMapping("/bucket/addbucketaction")
	public String addFamilyBucketAction(HttpSession session, BucketListModel bucketListModel, MultipartFile file)
			throws Exception {

		String userId = (String) session.getAttribute("userId");
		int famSeq = (int) session.getAttribute("famSeq");

		bucketListModel.setUserId(userId);
		bucketListModel.setFamilySeq(famSeq);

		bucketlistService.addBucketList(bucketListModel, file);
		return "redirect:/bucket/bucketview";
	}

	// 버킷리스트 수정 페이지
	@GetMapping("/bucket/modifybucket")
	public String modifyBucket(@RequestParam("bucketSeq") int bucketSeq, Model model) {
		BucketListModel bucketOne = bucketlistService.getFamilyBucketDetail(bucketSeq);

		model.addAttribute("bucketOne", bucketOne);

		return "bucketList/modifyBucket";
	}

	// 버킷리스트 수정 액션
	@PostMapping("/bucket/modifyaction")
	public String modifyBucketAction(BucketListModel bucketListModel, MultipartFile file) throws Exception {

		bucketlistService.updateBucket(bucketListModel, file);
		return "redirect:/bucket/bucketview";
	}

	// --------------------------------------------------------------------------------------------------------
	// 버킷리스트 등록 페이지
	@GetMapping("/bucket/addpersonalbucket")
	public String addPersonalBucket(Model model) {

		return "bucketList/addPersonalBucket";
	}

	// 버킷리스트 등록 액션
	@PostMapping("/bucket/addpersonalbucketaction")
	public String addPersonalBucketAction(HttpSession session, BucketListModel bucketListModel, MultipartFile file)
			throws Exception {

		String userId = (String) session.getAttribute("userId");
		int famSeq = (int) session.getAttribute("famSeq");

		bucketListModel.setUserId(userId);
		bucketListModel.setFamilySeq(famSeq);

		bucketlistService.addPersonalBucketList(bucketListModel, file);
		return "redirect:/bucket/bucketview";
	}

	// 버킷리스트 출력
	@GetMapping("/bucket/bucketview")
	public String BucketListView(Model model, HttpSession session) {
		// 세션으로부터 familySeq를 받아옴
		int familySeq = (int) session.getAttribute("famSeq");
		// 받아온 해당 Seq 가족에 대한 버킷리스트를 bucketlist에 담아줌.
		List<BucketListModel> bucketlist = bucketlistService.getFamilyBucket(familySeq);
		// 담겨진 리스트를 familyBucket.jsp에서 bucketlist라는 이름으로 사용할 수 있게함.
		model.addAttribute("bucketlist", bucketlist);
		Date currentDate = new Date();
		model.addAttribute("currentDate", currentDate);
		List<UserModel> myFam = userService.getFamilyMembers(familySeq);
		model.addAttribute("myFam", myFam);

		return "bucketList/bucketListView";
	}

	@GetMapping("/bucket/bucketlistz")
	@ResponseBody
	public List<BucketListModel> getBucketListByUserId(@RequestParam String userId) {
		System.out.println(userId);
		// userId를 이용해서 bucketList를 가져오는 로직 구현
		List<BucketListModel> bucketList = bucketlistService.getPersonalBucket(userId);
		List<BucketListModel> blank = new ArrayList<>();
		System.out.println(bucketList);
		// if (bucketList.size() == 0) {
		// throw new BucketListNotFoundException("해당 사용자의 버킷리스트가 없습니다. userId=" +
		// userId);
		// }
		return bucketList;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class BucketListNotFoundException extends RuntimeException {
		public BucketListNotFoundException(String message) {
			super(message);
		}

	}

	@GetMapping("/bucket/successaction")
	public String successBucketAction(@RequestParam("bucketSeq") int bucketSeq) {
		bucketlistService.BucketSuccess(bucketSeq);

		return "redirect:/bucket/bucketview";
	}
	
	// 댓글 등록 액션
	@PostMapping("/bucket/addbucketreplyaction")
	public String addBucketReplyAction(HttpSession session , @RequestParam("bucketSeq") int bucketSeq, BucketReplyModel bucketReplyModel) {

		String userId = (String) session.getAttribute("userId");

		bucketReplyModel.setUserId(userId);
		bucketReplyModel.setBucketSeq(bucketSeq);
		bucketlistService.addBucketReply(bucketReplyModel);
		
		return "redirect:/bucket/familybucketdetail?bucketSeq=" + bucketSeq;
	}
		
	@PostMapping("/bucket/modifyreplyaction")
	public String modifyReplyAction(BucketReplyModel bucketReplyModel, @RequestParam("bucketSeq") int bucketSeq) {
		bucketlistService.updateReply(bucketReplyModel);
		
		return "redirect:/bucket/familybucketdetail?bucketSeq=" + bucketSeq;
	}
	
	@PostMapping("/bucket/deletereplyaction")
	public String deleteReplyAction(int bucketReplySeq, @RequestParam("bucketSeq") int bucketSeq) {
		bucketlistService.deleteReply(bucketReplySeq);
		
		return "redirect:/bucket/familybucketdetail?bucketSeq=" + bucketSeq;
	}

}
