package com.project.itda.bucketlist.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.bucketlist.model.BucketReplyModel;

/**
 * 
 * @author 윤준호
 * @since 2023-03-21
 * 버킷리스트 정보를 입력/수정/삭제/조회 하기 위한 서비스 클래스 입니다.
 *
 */
public interface IBucketListService {
	List<BucketListModel> getPersonalBucket(String userId);
	List<BucketListModel> getFamilyBucket(int familySeq);
	List<BucketReplyModel> getBucketReply(int bucketSeq);
	public void addBucketList(BucketListModel bucketListModel, MultipartFile file) throws Exception;
	public BucketListModel getFamilyBucketDetail(int bucketSeq);
	public void BucketInvisible(int bucketSeq);
	public void BucketSuccess(int bucketSeq);
	public void updateBucket(BucketListModel bucketListModel);
	public void addPersonalBucketList(BucketListModel bucketListModel, MultipartFile file) throws Exception;
}
