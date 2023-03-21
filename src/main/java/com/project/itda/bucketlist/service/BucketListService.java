package com.project.itda.bucketlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.bucketlist.dao.IBucketListRepository;

@Service
public class BucketListService implements IBucketListService {

	@Autowired
	IBucketListRepository bucketRepository;
}
