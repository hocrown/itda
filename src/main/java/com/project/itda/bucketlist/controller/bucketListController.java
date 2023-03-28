package com.project.itda.bucketlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.bucketlist.service.BucketListService;

@Controller
public class bucketListController {
	
	@Autowired
	BucketListService bucketlistService;
	
	@GetMapping("/bucket/familybucket")
	public String familyBucket(Model model) {
		
		List<BucketListModel> bucketlist = bucketlistService.getFamilyBucket();
		model.addAttribute("bucketlist", bucketlist);
		
		return "bucketList/familyBucket";
	}
	
	@GetMapping("/bucket/personalbucket")
	public String personalBucket(Model model) {
		
		List<BucketListModel> bucketlist = bucketlistService.getPersonalBucket();
		model.addAttribute("bucketlist", bucketlist);
		
		return "bucketList/personalBucket";
	}
	
	@GetMapping("/bucket/addbucket")
	public String addbucket(Model model) {
		
		return "bucketList/addBucket";
	}
	
}
