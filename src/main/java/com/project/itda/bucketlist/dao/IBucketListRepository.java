package com.project.itda.bucketlist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.bucketlist.model.BucketReplyModel;
import com.project.itda.bucketlist.model.BucketUploadModel;

@Repository
@Mapper
public interface IBucketListRepository {
	List<BucketListModel> getPersonalBucket(String userId);
	List<BucketListModel> getFamilyBucket(int familySeq);
	List<BucketReplyModel> getBucketReply(int bucketSeq);
	void insertBucket(BucketListModel bucketListModel);
	void insertPersonal(BucketListModel bucketListModel);
	BucketListModel getOneFamilyBucket(int bucketSeq);
	void invisible(int bucketSeq);
	void updateBucket(BucketListModel bucketListModel);
	void success(int bucketSeq);
	void insertReply(BucketReplyModel bucketReplyModel);
	int countBucketOneReply(int bucketSeq);
	void updateReply(BucketReplyModel bucketReplyModel);
	void deleteReply(int bucketReplySeq);
	//---------------------------------------------------------
	
}
