package com.project.itda.whisper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.whisper.dao.IWhisperRepository;
import com.project.itda.whisper.model.WhisperModel;

@Service
public class WhisperService implements IWhisperService {

	@Autowired
	IWhisperRepository whisperRepository;

	@Override
	public void insertWhisper(WhisperModel whisper) {
		whisperRepository.insertWhisper(whisper);
	}

	@Override
	public List<WhisperModel> getWhisperList(String userId) {
		List<WhisperModel> whisperList = whisperRepository.getWhisperList(userId);
		return whisperList;
	}

	@Override
	public WhisperModel getWhisperDetail(int whisperSeq) {
		WhisperModel whisperDetail = whisperRepository.getWhisperDetail(whisperSeq);
		return whisperDetail;
	}

	@Override
	public List<WhisperModel> getInboxList(String userId) {
		List<WhisperModel> inboxList = whisperRepository.getInboxList(userId);
		return inboxList;
	}

	@Override
	public List<WhisperModel> getOutboxList(String userId) {
		List<WhisperModel> outboxList = whisperRepository.getOutboxList(userId);
		return outboxList;
	}
}
