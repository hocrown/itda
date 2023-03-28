package com.project.itda.bucketlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.bucketlist.dao.IBucketListRepository;
import com.project.itda.bucketlist.model.BucketListModel;

@Service
public class BucketListService implements IBucketListService {

	@Autowired
	IBucketListRepository bucketRepository;
	
	public List<BucketListModel> getPersonalBucket(){
		List<BucketListModel> bucketList = bucketRepository.getPersonalBucket();
		return bucketList;
	}
	
	public List<BucketListModel> getFamilyBucket(){
		List<BucketListModel> bucketList = bucketRepository.getFamilyBucket();
		return bucketList;
	}
	
}
