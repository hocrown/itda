package com.project.itda.whisper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.whisper.dao.IWhisperRepository;

@Service
public class WhisperService implements IWhisperService {

	@Autowired
	IWhisperRepository whisperDao;
}
