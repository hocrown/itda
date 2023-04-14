package com.project.itda.timeline.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.common.model.UserModel;
import com.project.itda.common.service.IUserService;
import com.project.itda.timeline.model.TimeLineModel;
import com.project.itda.timeline.model.TimeLineReplyModel;
import com.project.itda.timeline.service.ITimeLineReplyService;
import com.project.itda.timeline.service.ITimeLineService;

@Controller
public class TimeLineController {

	@Autowired
	ITimeLineService timelineService;
	
	@Autowired
	ITimeLineReplyService timelineReplyService;
	
	@Autowired
	IUserService userService;
	
	//게시글 전체 목록
	@GetMapping("/familypost")
	public String familyPost(Model model, HttpSession session) {
		int familySeq = (int) session.getAttribute("famSeq"); //세션으로부터 familySeq를 받아온다.
		List<TimeLineModel> post = timelineService.getPostList(familySeq); //받아온 해당 familySeq를 요청하여 가족 게시글을 post에 담는다.
		model.addAttribute("post", post); //담겨진 리스트를 postView.jsp에서 post라는 이름으로 사용할 수 있게한다.
		
		return "timeline/postView";
	}
	
	
	//게시글 상세 정보
	@GetMapping("/familypost/postcontent")
	public String familyPostContent(Model model, HttpSession session, @RequestParam("postSeq") int postSeq) {
		TimeLineModel content = timelineService.getContent(postSeq); //이전 페이지에서 클릭한 게시글의 Seq를 요청하여 해당 게시글에 대한 내용을 담는다.
		List<TimeLineReplyModel> reply = timelineReplyService.getReplyList(postSeq); //해당 포스트에린 댓글들의 정보를 담아둠
		model.addAttribute("timeline", content); //content라는 이름으로 전송
		model.addAttribute("reply", reply); //reply라는 이름으로 전송

		return "timeline/postContent";
	}
	
	//게시글 추가 페이지
	@GetMapping("/familypost/insertpost")
	public String insertPost(Model model) {
		System.out.println("?");
		return "timeline/insertPost";
	}
	
	
	//게시글 추가 액션
	@PostMapping("/familypost/insertaction")
	public String insertPostAction(HttpSession session, TimeLineModel timelineModel, MultipartFile file) throws Exception {

		String userId = (String) session.getAttribute("userId");
		int famSeq = (int) session.getAttribute("famSeq");

		timelineModel.setUserId(userId);
		timelineModel.setFamilySeq(famSeq);

		timelineService.insertPost(timelineModel, file);
		return "redirect:/familypost";
	}
	
	//게시글 수정 페이지
	@GetMapping("/familypost/updatepost")
	public String updatePost(@RequestParam("postSeq")int postSeq, Model model) {
		TimeLineModel postOne = timelineService.getContent(postSeq);
		
		model.addAttribute("postOne", postOne);
		
		return "timeline/updatePost;";
	}
	
	
	//게시글 수정 액션
	@PostMapping("/familypost/updateaction")
	public String updatePostAction(TimeLineModel timeLineModel, MultipartFile file) throws Exception {
		
		timelineService.updatePost(timeLineModel, file);
		return "redirect:/timeline/postView";
	}
	
	//게시글 삭제 액션
	@GetMapping("/familypost/deleteaction")
	public String deletePostAction(@RequestParam("postSeq")int postSeq) {
		timelineService.deletePost(postSeq);
	
		return "redirect:/timeline/postView";
	}
	
	//댓글 등록 액션
	@PostMapping("/familypost/insertreplyaction")
	public String insertReplyAction(HttpSession session , int postSeq, TimeLineReplyModel timeLineReplyModel) {

		String userId = (String) session.getAttribute("userId");
		UserModel loginUser = (UserModel) session.getAttribute("loginUser");
		String userName = loginUser.getUserName();
		
		timeLineReplyModel.setUserId(userId);
		timeLineReplyModel.setUserName(userName);
		timelineReplyService.insertReply(timeLineReplyModel);
		
		return "redirect:/timeline/content?postSeq=" + postSeq;
	}
		
	@PostMapping("/familypost/updatereplyaction")
	public String updateReplyAction(TimeLineReplyModel timeLineReplyModel, @RequestParam("postSeq") int postSeq) {
		timelineReplyService.updateReply(timeLineReplyModel);
		
		return "redirect:/timeline/content?postSeq=" + postSeq;
	}
	
	@PostMapping("/familypost/deletereplyaction")
	public String deleteReplyAction(int postReplySeq, @RequestParam("postSeq") int postSeq) {
		timelineReplyService.deleteReply(postReplySeq);
		
		return "redirect:/timeline/content?postSeq=" + postSeq;
	}

}


	
