package com.project.itda.bucketlist.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.bucketlist.model.BucketReplyModel;
import com.project.itda.bucketlist.service.BucketListService;

@Controller
public class bucketListController {

	@Autowired
	BucketListService bucketlistService;

	@GetMapping("/bucket/familybucket")
	public String familyBucket(Model model, HttpSession session) {
		int familySeq = 0;
		familySeq = (int) session.getAttribute("famSeq");
		List<BucketListModel> bucketlist = bucketlistService.getFamilyBucket(familySeq);
		model.addAttribute("bucketlist", bucketlist);

		return "bucketList/familyBucket";
	}

	@GetMapping("/bucket/familybucketdetail")
	public String familyBucketDetail(Model model, HttpSession session, @RequestParam("bucketSeq") int bucketSeq) {
		System.out.println(bucketSeq);
		BucketListModel bucketOne = bucketlistService.getFamilyBucketDetail(bucketSeq);
		List<BucketReplyModel> reply = bucketlistService.getBucketReply(bucketSeq);
		model.addAttribute("bucketOne", bucketOne);
		model.addAttribute("reply", reply);

		return "bucketList/familyBucketDetail";
	}

	@GetMapping("/bucket/personalbucket")
	public String personalBucket(Model model) {

		List<BucketListModel> bucketlist = bucketlistService.getPersonalBucket();

		model.addAttribute("bucketlist", bucketlist);

		return "bucketList/personalBucket";
	}


	
	@GetMapping("/bucket/invisibleaction")
	public String invisibleBucketAction(@RequestParam("bucketSeq") int bucketSeq) {
		System.out.println(bucketSeq);
		bucketlistService.BucketInvisible(bucketSeq);
		
		return "redirect:/bucket/familybucket";
	}
	
	@GetMapping("/bucket/addfamilybucket")
	public String addBucket(Model model) {

		return "bucketList/addFamilyBucket";
	}

	@PostMapping("/bucket/addbucketaction")
	public String addFamilyBucketAction(HttpSession session, BucketListModel bucketListModel, MultipartFile file) throws Exception {

		String userId = (String) session.getAttribute("userId");
		int famSeq = (int) session.getAttribute("famSeq");

		bucketListModel.setUserId(userId);
		bucketListModel.setFamilySeq(famSeq);

		bucketlistService.addBucketList(bucketListModel, file);
		return "redirect:/bucket/familybucket";
	}
	
	@GetMapping("/bucket/modifybucket")
	public String modifyBucket(@RequestParam("bucketSeq") int bucketSeq, Model model) {
		BucketListModel bucketOne = bucketlistService.getFamilyBucketDetail(bucketSeq);

		model.addAttribute("bucketOne", bucketOne);
		
		return "bucketList/modifyBucket";
	}
	
	@PostMapping("/bucket/modifyaction")
	public String modifyBucketAction(BucketListModel bucketListModel) {
		
		bucketlistService.updateBucket(bucketListModel);
		return "redirect:/bucket/familybucket";
	}
	

	
}
