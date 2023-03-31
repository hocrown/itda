package com.project.itda.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.common.dao.IUserRepository;
import com.project.itda.common.model.FamilyModel;
import com.project.itda.common.model.UserModel;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Override
	public void insertUser(UserModel user) {
		userRepository.insertUser(user);
	}

	@Override
	public void insertFamily(String userId, String famCode) {
		userRepository.insertFamily(userId, famCode);
	}

	@Override
	public int selectFamilySeq(String famCode) {
		Integer familySeq = userRepository.selectFamilySeq(famCode);
		return familySeq != null ? familySeq : 0;
	}

	@Override
	public void approveFamCode(String famCode) {
		famCode = "yes";
	}

	@Override
	public int checkUserId(String userId) {
		int checkUserId = userRepository.checkUserId(userId);
		return checkUserId;
	}

	@Override
	public UserModel selectUser(String userId, String userPw) {
		UserModel user = userRepository.selectUser(userId, userPw);
		return user;
	}

	public FamilyModel getFamilyByUserId(String userId) {
		String familySeq = userRepository.getFamCodeByUserId(userId);
		FamilyModel family = userRepository.getFamilyByUserId(familySeq);
		return family;
	}

	@Override
	public int countFamilyMember(int familySeq) {
		int countAnsweredFamilyMember = userRepository.countFamilyMember(familySeq);
		return countAnsweredFamilyMember;
	}

	@Override
    public List<UserModel> getFamilyMembers(int familySeq) {
        return userRepository.selectFamilyMembers(familySeq);
    }

	@Override
	public List<String> getFamilyUserIds(int familySeq) {
		List<String> familyUserIds = userRepository.getFamilyUserIds(familySeq);
		return familyUserIds;
	}
	
	
}
