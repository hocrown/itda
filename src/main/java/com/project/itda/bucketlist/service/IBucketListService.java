package com.project.itda.bucketlist.service;

import java.util.List;

import com.project.itda.bucketlist.model.BucketListModel;

/**
 * 
 * @author 윤준호
 * @since 2023-03-21
 * 버킷리스트 정보를 입력/수정/삭제/조회 하기 위한 서비스 클래스 입니다.
 *
 */
public interface IBucketListService {
	List<BucketListModel> getPersonalBucket();
	List<BucketListModel> getFamilyBucket();
}
