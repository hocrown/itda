package com.project.itda.timeline.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.common.model.UserModel;
import com.project.itda.common.service.IUserService;
import com.project.itda.timeline.model.TimeLineModel;
import com.project.itda.timeline.model.TimeLineReplyModel;
import com.project.itda.timeline.service.ITimeLineReplyService;
import com.project.itda.timeline.service.ITimeLineService;

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
		model.addAttribute("post", post); //담겨진 리스트를 postview.jsp에서 post라는 이름으로 사용할 수 있게한다.

		return "post/postview";
	}
	
	//게시글 상세 정보
	@GetMapping("/familypost/postcontent")
	public String familyPostContent(Model model, HttpSession session, @RequestParam("postSeq") int postSeq) {
		TimeLineModel content = timelineService.getContent(postSeq); //이전 페이지에서 클릭한 게시글의 Seq를 요청하여 해당 게시글에 대한 내용을 담는다.
		List<TimeLineReplyModel> reply = timelineService.getPostReply(postSeq); //해당 버킷리스트에 달린 댓글들의 정보를 담아둠
		model.addAttribute("content", content); //content라는 이름으로 전송
		model.addAttribute("reply", reply); //reply라는 이름으로 전송

		return "post/postContent";
	}
	
	//게시글 추가
	@GetMapping("/familypost/insertpost")
	public String insertPost(Model model) {

		return "post/insertPost";
	}
	
	
	//게시글 추가 액션
	@PostMapping("/familypost/insertaction")
	public String insertPostAction(HttpSession session, TimeLineModel timelineModel, MultipartFile file) throws Exception {

		String userId = (String) session.getAttribute("userId");
		int famSeq = (int) session.getAttribute("famSeq");

		timelineModel.setUserId(userId);
		timelineModel.setFamilySeq(famSeq);

		timelineService.insertPost(timelineModel, file);
		return "redirect:/post/postview";
	}
	
	//게시글 수정 페이지
	@GetMapping("familypost/updatepost")
	public String updatePost(@RequestParam("postSeq")int postSeq, Model model) {
		TimeLineModel postOne = timelineService.getContent(postSeq);
		
		model.addAttribute("postOne", postOne);
		
		return "post/updatePost;";
	}
	
	
	//게시글 수정 액션
	@PostMapping("/familypost/updateaction")
	public String updatePostAction(TimeLineModel timeLineModel, MultipartFile file) throws Exception {
		
		timelineService.updatePost(timeLineModel, file);
		return "redirect:/post/postview";
	}
	
	//게시글 삭제 액션
	@GetMapping("/familypost/deleteaction")
	public String deletePostAction(@RequestParam("postSeq")int postSeq) {
		timelineService.deletePost(postSeq);
	
		return "redirect:/post/postview";
	}
	
	//타임라인 출력
	@GetMapping("/familypost/postview")
	public String PostView(Model model, HttpSession session) {
		int familySeq = (int) session.getAttribute("famSeq"); // 세션으로부터 familySeq를 받아옴
		List<TimeLineModel> post = timelineService.getPostList(familySeq); // 받아온 해당 Seq 가족에 대한 게시글을 familypost에 담아줌.
		model.addAttribute("post", post); // 담겨진 리스트를 post.jsp에서 post라는 이름으로 사용할 수 있게함.
		Date currentDate = new Date();
		model.addAttribute("currentDate", currentDate);
		List<UserModel> myFam = userService.getFamilyMembers(familySeq);
		model.addAttribute("myFam", myFam);

		return "post/bucketListView";
	}

	//댓글 등록 액션
	@PostMapping("/familypost/insertreplyaction")
	public String insertReplyAction(HttpSession session , @RequestParam("postSeq") int postSeq, TimeLineReplyModel timeLineReplyModel) {

		String userId = (String) session.getAttribute("userId");

		timeLineReplyModel.setUserId(userId);
		timeLineReplyModel.setPostSeq(postSeq);
		timelineReplyService.insertReply(timeLineReplyModel);
		
		return "redirect:/post/content?postSeq=" + postSeq;
	}
		
	@PostMapping("/familypost/updatereplyaction")
	public String updateReplyAction(TimeLineReplyModel timeLineReplyModel, @RequestParam("postSeq") int postSeq) {
		timelineReplyService.updateReply(timeLineReplyModel);
		
		return "redirect:/post/content?postSeq=" + postSeq;
	}
	
	@PostMapping("/familypost/deletereplyaction")
	public String deleteReplyAction(int postReplySeq, @RequestParam("postSeq") int postSeq) {
		timelineReplyService.deleteReply(postReplySeq);
		
		return "redirect:/post/content?postSeq=" + postSeq;
	}

}


	
