package com.project.itda.whisper.service;

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
}
