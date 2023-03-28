package com.project.itda.dailyquestion.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.project.itda.common.model.FamilyModel;
import com.project.itda.dailyquestion.dao.IDailyQuestionRepository;
import com.project.itda.dailyquestion.dao.IFamilyQuestionRepository;
import com.project.itda.dailyquestion.model.DailyQuestionModel;
import com.project.itda.dailyquestion.model.FamilyQuestionModel;

@Service
public class DailyQuestionService implements IDailyQuestionService {

	@Autowired
	IDailyQuestionRepository dailyQuestion;
	IFamilyQuestionRepository familyQuestion;
	
	
	@Scheduled(cron = "0 0 9 * * ?") // 매일 오전 9시 실행
	public void sendDailyQuestion() {
	    try {
	        List<DailyQuestionModel> dailyQuestions = dailyQuestion.selectAll();
	        if (dailyQuestions.isEmpty()) {
	            // 질문이 없는 경우
	            return;
	        }

	        Random random = new Random();
	        DailyQuestionModel selectedQuestion = dailyQuestions.get(random.nextInt(dailyQuestions.size()));
	        List<FamilyModel> families = familyQuestion.selectAll();

	        for (FamilyModel family : families) {
	            try {
	                if (familyQuestion.selectByFamilySeqAndDailyQuestionSeq(family.getFamilySeq(), selectedQuestion.getDailyQuestionSeq()) == null) {
	                    FamilyQuestionModel familyQ = new FamilyQuestionModel();
	                    familyQ.setFamilySeq(family.getFamilySeq());
	                    familyQ.setDailyQuestionSeq(selectedQuestion.getDailyQuestionSeq());
	                    familyQ.setAnswer("N");
	                    familyQuestion.insert(familyQ);
	                }
	            } catch (NullPointerException e) {
	                // 가족의 질문 조회 또는 추가 과정에서 예외 발생 시 처리
	                e.printStackTrace();
	            }
	        }
	    } catch (NullPointerException e) {
	        // 질문 조회 과정에서 예외 발생 시 처리
	        e.printStackTrace();
	    }
	}

	
}
