package com.project.itda.timeline.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.timeline.dao.ITimeLineRepository;
import com.project.itda.timeline.model.TimeLineModel;
import com.project.itda.timeline.model.TimeLineReplyModel;

@Service
public class TimeLineService implements ITimeLineService {

	@Autowired
	ITimeLineRepository timeLineRepository;
	
	@Override
	public List<TimeLineModel> getPostList(int familySeq) {
		List<TimeLineModel> postList = timeLineRepository.getPostList(familySeq);
		return postList;
	}

	@Override
	public TimeLineModel getContent(int postSeq) {
		return timeLineRepository.getContent(postSeq);
	}

	@Override
	public void insertPost(TimeLineModel timeLineModel, MultipartFile file) throws Exception {

		String prjPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
		
		UUID uuid = UUID.randomUUID();
		
		String fileName = uuid + "_" + file.getOriginalFilename();
		
		File saveFile = new File(prjPath, fileName);
			
		file.transferTo(saveFile);
		timeLineModel.setFileName(fileName);
		timeLineModel.setFilePath("/files/" + fileName);
		timeLineRepository.insertPost(timeLineModel);
	}

	@Override
	public void updatePost(TimeLineModel timeLineModel, MultipartFile file) throws Exception {
		String prjPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
		
		UUID uuid = UUID.randomUUID();

		String fileName = uuid + "_" + file.getOriginalFilename();
		
		File saveFile = new File(prjPath, fileName);
		
		file.transferTo(saveFile);
		timeLineModel.setFileName(fileName);
		timeLineModel.setFilePath("/files/" + fileName);

		timeLineRepository.updatePost(timeLineModel);
	}
		
	@Override
	public void deletePost(int postSeq) {

		timeLineRepository.deletePost(postSeq);
	}
	
	@Override
	public List<TimeLineReplyModel> getPostReply(int postSeq) {
		List<TimeLineReplyModel> reply = timeLineRepository.getPostReply(postSeq);
		return reply;
	}

	@Override
	public TimeLineModel postSearch(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeLineModel> getContentSearch(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeLineModel> getuserId(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}//end class
