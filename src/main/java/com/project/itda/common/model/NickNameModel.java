package com.project.itda.common.model;

import lombok.Data;

@Data
public class NickNameModel {
	
	private int nickNameSeq;
	private String userId;
	private String targetUserId;
	private String targetNickName;
	private String selfNickName;
	
}