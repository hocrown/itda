package com.project.itda.common.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.itda.common.model.FamilyModel;
import com.project.itda.common.model.NickNameModel;
import com.project.itda.common.model.UserModel;

@Repository
@Mapper
public interface IUserRepository {
	void insertFamily(String userId, String famCode);
	void insertUser(UserModel user);
	int selectFamilySeq(String famCode);
	int checkUserId(String userId);
	UserModel selectUser(String userId, String userPw);
	
	FamilyModel getFamilyByUserId(String userId);
	String getFamCodeByUserId(String userId);
	
	int countFamilyMember(@Param("familySeq") int familySeq);
	List<UserModel> selectFamilyMembers(int familySeq);
	List<String> getFamilyUserIds(int familySeq);

	//사용 할지 말지 모르는 메소드
	int modifyMyInfo(String userPw, String userAddress, 
			String userAddressDetail, String userPhone, String email);
	
	void updateUserInfo(UserModel user);
	
	NickNameModel getNickName(String userId);
	List<UserModel> getFamilyMembersWithNickName(UserModel loginUser);
	
	String getFamCode(int familySeq);
	void updateFamilyProfile(FamilyModel family);
	void updateFamilyNickName(NickNameModel nickName);
	NickNameModel getNickname(String userId, String targetUserId);
	void insertNickname(NickNameModel newNickname);
	
	UserModel getUserInfoByUserId(String userId);
	
	String getFamilyName(int familySeq);
	void updateFamilyName(int familySeq, String familyName);
	void insertFamilyName(int familySeq, String familyName);
	
	
	
}
