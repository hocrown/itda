package com.project.itda.bucketlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class bucketListController {
	@GetMapping("/bucket/familybucket")
	public String failybucket(Model model) {
		
		return "bucketList/familyBucket";
	}
	
	@GetMapping("/bucket/addbucket")
	public String addbucket(Model model) {
		
		return "bucketList/addBucket";
	}
	
}
