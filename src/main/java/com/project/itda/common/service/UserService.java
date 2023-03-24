package com.project.itda.common.service;

import java.util.List;

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
	public int countByUserId(String userId) {

		return 0;
	}

	@Override
	public boolean isUserIdDuplicated(String userId) {
		int count = userRepository.countByUserId(userId);
		return count>0;
	}
	
}
	
