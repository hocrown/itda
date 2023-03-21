package com.project.itda.common.model;

import java.util.Date;

import lombok.Data;

@Data
public class PokingModel {
	private int pokingSeq;
	private String sender;
	private String receiver;
	private Date pokeDate;
}
