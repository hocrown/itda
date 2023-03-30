package com.project.itda.common.service;


import com.project.itda.common.model.FamilyModel;
import com.project.itda.common.model.UserModel;

public interface IUserService {
	
	void insertUser(UserModel user);
	int selectFamilySeq(String famCode);
	void approveFamCode(String famCode);
	void insertFamily(String userId, String famCode);
	int checkUserId(String userId);
	UserModel selectUser(String userId, String userPw);
	FamilyModel getFamilyByUserId(String userId);
}
