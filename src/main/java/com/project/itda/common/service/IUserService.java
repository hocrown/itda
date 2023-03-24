package com.project.itda.common.service;

import java.util.List;

import com.project.itda.common.model.UserModel;

public interface IUserService {
	
	void insertUser(UserModel user);
	int countByUserId(String userId);
	boolean isUserIdDuplicated(String userId);
	
}
