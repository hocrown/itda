package com.project.itda.dailyquestion.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.project.itda.dailyquestion.dao.IDailyAnswerRepository;
import com.project.itda.dailyquestion.dao.IDailyQuestionRepository;
import com.project.itda.dailyquestion.model.DailyQuestionModel;
/**
 * 
 * @author 윤준호
 * @since 2023-03-22
 * 하루질문과 관련한 비즈니스 로직
 *
 */
@Service
public class DailyQuestionService implements IDailyQuestionService {

	@Autowired
	IDailyQuestionRepository dailyQuestionDao;
	
	@Autowired
	IDailyAnswerRepository dailyAnswerDao;
	
	@Autowired
	HttpSession httpSession;
	
	@Override
	public void insertQuestion(DailyQuestionModel dailyquestion) {
		dailyQuestionDao.insertQuestion(dailyquestion);
	}
	
	@Scheduled(cron = "0 0 8 * * ?")
	@Override
	public DailyQuestionModel fetchDailyQuestion() {
		List<Integer> usedQuestionIds = getUsedQuestionIds();	//이전에 선택된 질문의 Id목록을 가져옴.
		
		//사용되지 않은 질문 중 무작위로 하나를 선택.
		List<DailyQuestionModel> unusedQuestions = dailyQuestionDao.findUnusedQuestions(usedQuestionIds, 1);
		
		if(!unusedQuestions.isEmpty()) {
			return unusedQuestions.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	private List<Integer> getUsedQuestionIds() {
		
		String userId = (String) httpSession.getAttribute("userId");
		int familySeq = (Integer)httpSession.getAttribute("familySeq");
		
		if(userId == null) {
			return new ArrayList<>();
		}
		
		return dailyAnswerDao.findAnsweredQuestionIdsByFamily(familySeq);
	}
	
	
}
