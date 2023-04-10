package com.project.itda.bucketlist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.bucketlist.model.BucketReplyModel;

@Repository
@Mapper
public interface IBucketListRepository {
	List<BucketListModel> getPersonalBucket(String userId);
	List<BucketListModel> getFamilyBucket(int familySeq);
	List<BucketReplyModel> getBucketReply(int bucketSeq);
	void insertFamily(BucketListModel bucketListModel);
	void insertPersonal(BucketListModel bucketListModel);
	BucketListModel getOneFamilyBucket(int bucketSeq);
	void invisible(int bucketSeq);
	void update(BucketListModel bucketListModel);
	void success(int bucketSeq);
	void insertReply(BucketReplyModel bucketReplyModel);
	int countBucketOneReply(int bucketSeq);
	void updateReply(BucketReplyModel bucketReplyModel);
	void deleteReply(int bucketReplySeq);
}
