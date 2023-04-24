package com.project.itda.common.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.itda.common.model.FamilyModel;
import com.project.itda.common.model.NickNameModel;
import com.project.itda.common.model.UserModel;

public interface IUserService {
	
	void insertUser(UserModel user);
	int selectFamilySeq(String famCode);
	void approveFamCode(String famCode);
	void insertFamily(String userId, String famCode);
	int checkUserId(String userId);
	UserModel selectUser(String userId, String userPw);
	FamilyModel getFamilyByUserId(String userId);
	
	int countFamilyMember(@Param("familySeq") int familySeq);
	List<UserModel> getFamilyMembers(int familySeq);
	List<String> getFamilyUserIds(int familySeq);
	boolean modifyMyInfo(String userPw, String userAddress, 
			String userAddressDetail, String userPhone, String email);
	void updateUserInfo(UserModel user);
	
	NickNameModel getNickName(String userId);
	List<UserModel> getFamilyMembersWithNickName(UserModel loginUser);
	
	String getFamCode(int familySeq);
	void updateFamilyProfile(FamilyModel family);
	boolean updateFamilyNickName(String targetUserId, String targetNickName, String userId);
	NickNameModel getNickName(String userId, String targetUserId);
	void insertNickname(NickNameModel newNickname);
	
	UserModel getUserInfoByUserId(String userId);
}
