package com.project.itda.common.model;

import lombok.Data;

@Data
public class EmojiModel {
	private int emojiSeq;
	private String fileName;
	private long fileSize;
	private String fileContentType;
	private String fileData;
}
