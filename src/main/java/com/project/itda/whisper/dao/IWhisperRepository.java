package com.project.itda.whisper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.whisper.model.WhisperModel;

@Repository
@Mapper
public interface IWhisperRepository {
	void insertWhisper(WhisperModel whisper);
	List<WhisperModel> getWhisperList(String userId);
	List<WhisperModel> getInboxList(String userId);
	List<WhisperModel> getOutboxList(String userId);
	
	WhisperModel getWhisperDetail(int whisperSeq);
	
}
