package com.project.itda.bucketlist.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.bucketlist.dao.IBucketListRepository;
import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.bucketlist.model.BucketReplyModel;

@Service
public class BucketListService implements IBucketListService {

	@Autowired
	IBucketListRepository bucketRepository;
	
	public List<BucketListModel> getPersonalBucket(){
		List<BucketListModel> bucketList = bucketRepository.getPersonalBucket();
		return bucketList;
	}
	
	public List<BucketListModel> getFamilyBucket(int familySeq){
		List<BucketListModel> bucketList = bucketRepository.getFamilyBucket(familySeq);
		return bucketList;
	}
	
	public List<BucketReplyModel> getBucketReply(int bucketSeq){
		List<BucketReplyModel> reply = bucketRepository.getBucketReply(bucketSeq);
		return reply;
	}
	
	public void addBucketList(BucketListModel bucketListModel, MultipartFile file) throws Exception {
		
		String prjPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files"; 
		
		UUID uuid = UUID.randomUUID();
		
		String fileName = uuid + "_" + file.getOriginalFilename();
		
		File saveFile = new File(prjPath, fileName);
		
		file.transferTo(saveFile);
		bucketListModel.setFilename(fileName);
		bucketListModel.setFilepath("/files/" + fileName);
		bucketRepository.insertFamily(bucketListModel);
	}
	
	public BucketListModel getFamilyBucketDetail(int bucketSeq) {
		
		return bucketRepository.getOneFamilyBucket(bucketSeq);
	}
	
	public void BucketInvisible(int bucketSeq) {
		
		bucketRepository.invisible(bucketSeq);
	}
	
	public void updateBucket(BucketListModel bucketListModel) {
		bucketRepository.update(bucketListModel);
	}
	
}
