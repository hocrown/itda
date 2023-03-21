package com.project.itda.common.model;

import lombok.Data;

@Data
public class UserModel {
	private String userId;
	private int familySeq;
	private String userPw;
	private String userName;
	private int userAge;
	private String userSex;
	private String userAddress;
	private int userPhone;
	private String approve;
}
