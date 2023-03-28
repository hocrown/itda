package com.project.itda.common.model;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Data;

@Data
public class UserModel {
	private String userId;
	private int familySeq;
	private String userPw;
	private String userName;
	private int userAge;
	private String userGender;
	private String userPhone;
	private String approve;
	private String email;
	private LocalDate userBirth;
	private String userAddress;
	private String userAddressDetail;
	private int year;
	private int month;
	private int day;
	private String famCode;
}
