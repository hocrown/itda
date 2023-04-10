package com.project.itda.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.itda.bucketlist.model.BucketListModel;

@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public String familyBucket(Model model, HttpSession session) {
		
		
		return "admin/admin";
	}
	
}
