package com.project.itda.common.model;


import lombok.Data;

@Data
public class FamilyModel {
	private int familySeq;
	private String famCode;
	private String familyOwner;
	private String familyFileName;
	private byte[] familyFileData;
	private String familyName;
}
