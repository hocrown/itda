package com.project.itda.bucketlist.service;

import java.util.List;

import com.project.itda.bucketlist.model.BucketListModel;
import com.project.itda.bucketlist.model.BucketReplyModel;


public interface IBucketListService {
	List<BucketListModel> getPersonalBucket(String userId); // 개인 버킷 목록
	List<BucketListModel> getFamilyBucket(int familySeq); // 해당 가족에 대한 버킷 목록
	List<BucketReplyModel> getBucketReply(int bucketSeq); // 해당 버킷에 대한 댓글 목록
	public void addBucketList(BucketListModel bucketListModel); // 버킷 등록
	public BucketListModel getBucketDetail(int bucketSeq); // 버킷 상세
	public void BucketInvisible(int bucketSeq); // 버킷 삭제 시 안보이게 처리
	public void BucketSuccess(int bucketSeq); // 버킷 완료 처리
	public void updateBucket(BucketListModel bucketListModel); // 버킷 수정
	public void addBucketReply(BucketReplyModel bucketReplyModel); // 댓글 작성
	public int countBucketOneReply(int bucketSeq); // 해당 버킷 댓글 수 불러오기
	public void updateReply(BucketReplyModel bucketReplyModel); // 댓글 수정
	public void deleteReply(int bucketReplySeq); // 댓글 삭제
	//-----------------------------------------------
}
