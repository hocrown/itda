package com.project.itda.timeline.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.common.model.FamilyModel;
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
	
	
	private byte[] getDefaultFamilyImage() {
		try {
	        File file = new File("src/main/resources/static/image/familyDefaultBanner.png");
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
	
	private String getDefaultProfileImage() {
	    try {
	        File file = new File("src/main/resources/static/image/profile.png");
	        FileInputStream fis = new FileInputStream(file);
	        byte[] imageData = new byte[(int) file.length()];
	        fis.read(imageData);
	        fis.close();
	        return Base64.getEncoder().encodeToString(imageData);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "";
	    }
	}
	
	//게시글 전체 목록
	@GetMapping("/familypost")
	public String familyPost(Model model, HttpSession session) {
	    UserModel loginUser = (UserModel) session.getAttribute("loginUser");
	    int familySeq = (int) session.getAttribute("famSeq"); //세션으로부터 familySeq를 받아온다.
	    List<TimeLineModel> post = timelineService.getPostList(familySeq); //받아온 해당 familySeq를 요청하여 가족 게시글을 post에 담는다.
	    FamilyModel family = userService.getFamilyByUserId(loginUser.getUserId());
	    List<UserModel> familyMember = userService.getFamilyMembersWithNickName(loginUser);
	    String defaultProfileImage = getDefaultProfileImage();
	    
	    // 이미지 데이터를 Base64로 인코딩하여 저장할 리스트 생성
 		List<String> postImageDataList = new ArrayList<>();

 		// 버킷리스트의 각 항목에 대해 이미지 데이터를 Base64로 인코딩하고 리스트에 추가
 		for (TimeLineModel postOne : post) {
 			byte[] fileData = postOne.getFileData();
 			String postImageData = Base64.getEncoder().encodeToString(fileData);
 			postImageDataList.add(postImageData);
 			postOne.setEncodedFileData(postImageData);
 		}
 	
	    for (UserModel member : familyMember) {
	        byte[] imageData = member.getUserImageData();
	        if (imageData != null) {
	            member.setEncodedImage(Base64.getEncoder().encodeToString(imageData));
	        } else {
	            member.setEncodedImage(defaultProfileImage);
	        }
	    }

	    byte[] fileData = family.getFamilyFileData();
	    String base64ImageData;
	    if (fileData != null) {
	        base64ImageData = Base64.getEncoder().encodeToString(fileData);
	    } else {
	        byte[] defaultImageData = getDefaultFamilyImage();
	        base64ImageData = Base64.getEncoder().encodeToString(defaultImageData);
	    }
	    int familyCount = userService.countFamilyMember(familySeq);
	    
	    model.addAttribute("familyCount", familyCount);
	    model.addAttribute("familyMember", familyMember);
	    model.addAttribute("family", family);
	    model.addAttribute("famImage", base64ImageData);    //가족 배너 이미지
	    model.addAttribute("profileImage", defaultProfileImage);
	    model.addAttribute("post", post); //담겨진 리스트를 postView.jsp에서 post라는 이름으로 사용할 수 있게한다.
	    model.addAttribute("postImageDataList", postImageDataList);
	    return "timeline/postView";
	}
	
	
	//게시글 상세 정보
	@GetMapping("/familypost/postcontent")
	public String familyPostContent(Model model, HttpSession session, @RequestParam("postSeq") int postSeq) {
		
		byte[] fileData = content.getFileData();
		String base64ImageData = Base64.getEncoder().encodeToString(fileData);
		TimeLineModel content = timelineService.getContent(postSeq); //이전 페이지에서 클릭한 게시글의 Seq를 요청하여 해당 게시글에 대한 내용을 담는다.
		String userId = content.getUserId();
		UserModel writer = userService.getUserInfoByUserId(userId);
		List<TimeLineReplyModel> reply = timelineReplyService.getReplyList(postSeq); //해당 포스트에 달린 댓글들의 정보를 담아둠
		String defaultProfileImage = getDefaultProfileImage();
		
		byte[] imageData = writer.getUserImageData();
        if (imageData != null) {
            writer.setEncodedImage(Base64.getEncoder().encodeToString(imageData));
        } else {
            writer.setEncodedImage(defaultProfileImage);
        }
		
		
		model.addAttribute("timeline", content); //content라는 이름으로 전송
		model.addAttribute("reply", reply); //reply라는 이름으로 전송
		model.addAttribute("writer", writer);
		model.addAttribute("profileImage", defaultProfileImage);
		return "timeline/postContent";
	}
	
	//게시글 추가 페이지
	@GetMapping("/familypost/insertpost")
	public String insertPost(Model model) {
		System.out.println("?");
		return "timeline/insertPost";
	}
	
	private byte[] getDefaultPostImage() {
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
	
	
	//게시글 추가 액션
	@PostMapping("/familypost/insertaction")
	public String insertPostAction(HttpSession session, TimeLineModel timelineModel) throws Exception {

		String userId = (String) session.getAttribute("userId");
		int famSeq = (int) session.getAttribute("famSeq");
		
		try {
			timelineModel.setUserId(userId);
			timelineModel.setFamilySeq(famSeq);
			
			
			MultipartFile mfile = timelineModel.getFile();
			
			if(mfile !=null && !mfile.isEmpty()) {
				timelineModel.setFileName(mfile.getOriginalFilename());
				timelineModel.setFileData(mfile.getBytes());

			} else if(timelineModel.getFileData() != null && timelineModel.getFileData().length>0) {
				timelineModel.setFileData(timelineModel.getFileData());
				timelineModel.setFileName(timelineModel.getFileName());
			} else {
				timelineModel.setFileData(getDefaultPostImage());
				timelineModel.setFileName("dafaultBucketImage.png");
			}

			timelineService.insertPost(timelineModel);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/familypost";
	}
	
	//게시글 수정 페이지
	@GetMapping("/familypost/updatepost")
	public String updatePost(@RequestParam("postSeq")int postSeq, Model model) {
	    TimeLineModel postOne = timelineService.getContent(postSeq);
	    byte[] fileData = postOne.getFileData();
	    String base64ImageData = Base64.getEncoder().encodeToString(fileData);
	    model.addAttribute("postOne", postOne);
		model.addAttribute("base64ImageData", base64ImageData);
	    
	    return "timeline/updatePost";
	}
	

	
	//게시글 수정 액션
	@PostMapping("/familypost/updateaction")
	public String updatePostAction(TimeLineModel timeLineModel) throws Exception {
		
		MultipartFile mfile = timeLineModel.getFile();
		if (mfile.isEmpty()) {
			timelineService.updatePostTwo(timeLineModel);
			// mfile 처리 작업 수행...
		} else {
			// mfile이 null인 경우 처리 작업 수행 (예: 기존 파일 유지)
			timeLineModel.setFileName(mfile.getOriginalFilename());
			timeLineModel.setFileData(mfile.getBytes());
			
			timelineService.updatePost(timeLineModel);

		}
		int postSeq = timeLineModel.getPostSeq();
		
		
		return "redirect:/familypost/postcontent?postSeq="+postSeq;
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
		
		return "redirect:/familypost/postcontent?postSeq=" + postSeq;
	}
		
	@PostMapping("/familypost/updatereplyaction")
	public String updateReplyAction(TimeLineReplyModel timeLineReplyModel, @RequestParam("postSeq") int postSeq) {
		timelineReplyService.updateReply(timeLineReplyModel);
		
		return "redirect:/familypost/postcontent?postSeq=" + postSeq;
	}
	
	@PostMapping("/familypost/deletereplyaction")
	public String deleteReplyAction(int postReplySeq, @RequestParam("postSeq") int postSeq) {
		timelineReplyService.deleteReply(postReplySeq);
		
		return "redirect:/timeline/content?postSeq=" + postSeq;
	}

}


	
