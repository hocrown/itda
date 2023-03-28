package com.project.itda.common.service;


import com.project.itda.common.model.UserModel;

public interface IUserService {
	
	void insertUser(UserModel user);
	int selectFamilySeq(String famCode);
	void approveFamCode(String famCode);
	void insertFamily(String userId, String famCode);
	int checkUserId(String userId);
}
