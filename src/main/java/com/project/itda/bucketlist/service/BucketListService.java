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
	public void addBucketList(BucketListModel bucketListModel) {
		
		bucketRepository.insertBucket(bucketListModel);
		
	}
	
	
	@Override
	public BucketListModel getBucketDetail(int bucketSeq) {
		
		return bucketRepository.getOneFamilyBucket(bucketSeq);
	}
	
	// 버킷 삭제 시 안보이게 처리
	@Override
	public void BucketInvisible(int bucketSeq) {
		
		bucketRepository.invisible(bucketSeq);
	}

	// 버킷 수정 ( 수정 파일이 있는 경우 )
	@Override
	public void updateBucket(BucketListModel bucketListModel) {

		bucketRepository.updateBucket(bucketListModel);
	}
	
	// 버킷 수정 ( 수정 파일이 없는 경우 )
	@Override
	public void updateBucketTwo(BucketListModel bucketListModel) {

		bucketRepository.updateBucketTwo(bucketListModel);
	}

	// 버킷 완료 처리
	@Override
	public void BucketSuccess(int bucketSeq) {
		
		bucketRepository.success(bucketSeq);
	}
	
	// 댓글 작성
	@Override
	public void addBucketReply(BucketReplyModel bucketReplyModel) {
		
		bucketRepository.insertReply(bucketReplyModel);
	}
	
	// 해당 버킷 댓글 수 불러오기
	@Override
	public int countBucketOneReply(int bucketSeq) {
		int replyCount = bucketRepository.countBucketOneReply(bucketSeq);
		
		return replyCount;
	}
	
	// 댓글 수정
	@Override
	public void updateReply(BucketReplyModel bucketReplyModel) {
		bucketRepository.updateReply(bucketReplyModel);
	}
	
	// 댓글 삭제
	@Override
	public void deleteReply(int bucketReplySeq) {
		bucketRepository.deleteReply(bucketReplySeq);
	}

	
}
