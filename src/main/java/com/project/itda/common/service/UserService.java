package com.project.itda.common.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.common.dao.IUserRepository;
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
	
	
}
