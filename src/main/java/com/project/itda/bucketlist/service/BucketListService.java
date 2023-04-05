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
	
	@Override
	public List<BucketListModel> getPersonalBucket(String userId){
		List<BucketListModel> bucketList = bucketRepository.getPersonalBucket(userId);
		return bucketList;
	}
	@Override
	public List<BucketListModel> getFamilyBucket(int familySeq){
		List<BucketListModel> bucketList = bucketRepository.getFamilyBucket(familySeq);
		return bucketList;
	}
	@Override
	public List<BucketReplyModel> getBucketReply(int bucketSeq){
		List<BucketReplyModel> reply = bucketRepository.getBucketReply(bucketSeq);
		return reply;
	}
	@Override
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
	@Override
	public BucketListModel getFamilyBucketDetail(int bucketSeq) {
		
		return bucketRepository.getOneFamilyBucket(bucketSeq);
	}
	@Override
	public void BucketInvisible(int bucketSeq) {
		
		bucketRepository.invisible(bucketSeq);
	}
	@Override
	public void updateBucket(BucketListModel bucketListModel) {
		bucketRepository.update(bucketListModel);
	}
	
	@Override
	public void addPersonalBucketList(BucketListModel bucketListModel, MultipartFile file) throws Exception {
		
		String prjPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files"; 
		
		UUID uuid = UUID.randomUUID();
		
		String fileName = uuid + "_" + file.getOriginalFilename();
		
		File saveFile = new File(prjPath, fileName);
		
		file.transferTo(saveFile);
		bucketListModel.setFilename(fileName);
		bucketListModel.setFilepath("/files/" + fileName);
		bucketRepository.insertPersonal(bucketListModel);
	}
	
	@Override
	public void BucketSuccess(int bucketSeq) {
		
		bucketRepository.success(bucketSeq);
	}
	
}
