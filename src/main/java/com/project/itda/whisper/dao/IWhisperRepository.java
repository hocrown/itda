package com.project.itda.whisper.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.itda.whisper.model.WhisperModel;

@Repository
@Mapper
public interface IWhisperRepository {
	void insertWhisper(WhisperModel whisper);
}
