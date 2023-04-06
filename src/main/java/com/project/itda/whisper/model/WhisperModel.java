package com.project.itda.whisper.model;

import java.util.Date;

import lombok.Data;

@Data
public class WhisperModel {
	private int whisperSeq;
	private String sender;
	private String receiver;
	private Date sendDate;
	private String message;
	private String whisperType;
	private int visible;
	private Date reserveDate;
	private String senderNickname;
	
}
