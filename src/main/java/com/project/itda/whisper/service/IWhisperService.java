package com.project.itda.whisper.service;

import java.util.List;

import com.project.itda.whisper.model.WhisperModel;

public interface IWhisperService {
	void insertWhisper(WhisperModel whisper);
	List<WhisperModel> getWhisperList(String userId);
	List<WhisperModel> getInboxList(String userId);
	List<WhisperModel> getOutboxList(String userId);
	void deleteWhisper(int whisperSeq);
	WhisperModel getWhisperDetail(int whisperSeq);
}
