package com.project.itda.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.common.model.UserModel;

@Repository
@Mapper
public interface IUserRepository {

	void insertUser(UserModel user);

}
