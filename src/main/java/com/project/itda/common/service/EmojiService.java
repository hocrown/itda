package com.project.itda.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.common.dao.IEmojiRepository;

@Service
public class EmojiService implements IEmojiService {

	@Autowired
	IEmojiRepository emojiDao;
}
