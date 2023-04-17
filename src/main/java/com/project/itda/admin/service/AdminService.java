package com.project.itda.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.admin.dao.IAdminRepository;
import com.project.itda.dailyquestion.model.DailyQuestionModel;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	IAdminRepository adminRepository;
	
	@Override
	public void updateQuestion(DailyQuestionModel dailyQuestionModel) {

		adminRepository.updateQuestion(dailyQuestionModel);
	}
	
	@Override
	public void updateStatus(DailyQuestionModel dailyQuestionModel) {

		adminRepository.updateStatus(dailyQuestionModel);
	}
	
	@Override
	public int deleteQuestions(List<Integer> dailyQuestionSeqs) {
        return adminRepository.deleteQuestions(dailyQuestionSeqs);
    }
	
}
