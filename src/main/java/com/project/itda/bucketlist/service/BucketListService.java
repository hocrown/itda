package com.project.itda.bucketlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void addBucketList(BucketListModel bucketListModel) {
		bucketRepository.insertFamily(bucketListModel);
	}
	
	public BucketListModel getFamilyBucketDetail(int bucketSeq) {
		
		return bucketRepository.getOneFamilyBucket(bucketSeq);
	}
}
