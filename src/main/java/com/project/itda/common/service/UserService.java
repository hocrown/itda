package com.project.itda.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.common.dao.IUserRepository;
import com.project.itda.common.model.FamilyModel;
import com.project.itda.common.model.NickNameModel;
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
		int familySeq = userRepository.selectFamilySeq(famCode);
		return familySeq;
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

	@Override
	public boolean modifyMyInfo(String userPw, String userAddress, String userAddressDetail, String userPhone,
			String email) {
		int result = userRepository.modifyMyInfo(userPw, userAddress, userAddressDetail, userPhone, email);
		if(result>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateUserInfo(UserModel user) {
		userRepository.updateUserInfo(user);		
	}

	@Override
	public NickNameModel getNickName(String userId) {
		NickNameModel nickName = userRepository.getNickName(userId); 		
		return nickName;
	}

	@Override
	public List<UserModel> getFamilyMembersWithNickName(UserModel loginUser) {
		return userRepository.getFamilyMembersWithNickName(loginUser);
	}

	@Override
	public String getFamCode(int familySeq) {
		return userRepository.getFamCode(familySeq);
	}

	@Override
	public void updateFamilyProfile(FamilyModel family) {
		userRepository.updateFamilyProfile(family);
	}

	@Override
	public boolean updateFamilyNickName(String targetUserId, String targetNickName, String userId) {
		 try {
		        NickNameModel existingNickname = userRepository.getNickname(userId, targetUserId);

		        if (existingNickname != null) {
		            existingNickname.setTargetNickName(targetNickName);
		           userRepository.updateFamilyNickName(existingNickname);
		        } else {
		            NickNameModel newNickname = new NickNameModel();
		            newNickname.setUserId(userId);
		            newNickname.setTargetUserId(targetUserId);
		            newNickname.setTargetNickName(targetNickName);
		            userRepository.insertNickname(newNickname);
		        }

		        return true;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
		
	}

	@Override
	public NickNameModel getNickName(String userId, String targetUserId) {
		NickNameModel nickName = userRepository.getNickname(userId, targetUserId);
		return nickName;
	}

	@Override
	public void insertNickname(NickNameModel newNickname) {
		userRepository.insertNickname(newNickname);
	}

	@Override
	public UserModel getUserInfoByUserId(String userId) {
		UserModel writer = userRepository.getUserInfoByUserId(userId);
		return writer;
	}

	@Override
	public void updateFamilyName(int familySeq, String familyName) {
		try {
			userRepository.updateFamilyName(familySeq, familyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
