package com.project.itda.bucketlist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.bucketlist.model.BucketListModel;

@Repository
@Mapper
public interface IBucketListRepository {
	List<BucketListModel> getPersonalBucket();
	List<BucketListModel> getFamilyBucket();
}
