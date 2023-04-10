package com.project.itda.bucketlist.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.bucketlist.model.BucketReplyModel;


public interface IBucketListService {
	List<BucketListModel> getPersonalBucket(String userId);
	List<BucketListModel> getFamilyBucket(int familySeq);
	List<BucketReplyModel> getBucketReply(int bucketSeq);
	public void addBucketList(BucketListModel bucketListModel, MultipartFile file) throws Exception;
	public BucketListModel getFamilyBucketDetail(int bucketSeq);
	public void BucketInvisible(int bucketSeq);
	public void BucketSuccess(int bucketSeq);
	public void updateBucket(BucketListModel bucketListModel, MultipartFile file) throws Exception;
	public void addPersonalBucketList(BucketListModel bucketListModel, MultipartFile file) throws Exception;
	public void addBucketReply(BucketReplyModel bucketReplyModel);
	public int countBucketOneReply(int bucketSeq);
	public void updateReply(BucketReplyModel bucketReplyModel);
	public void deleteReply(int bucketReplySeq);
}
