package com.project.itda.common.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.common.model.UserModel;

@Repository
@Mapper
public interface IUserRepository {
	void insertFamily(String userId, String famCode);
	void insertUser(UserModel user);
	int selectFamilySeq(String userId);
	int checkUserId(String userId);
}
