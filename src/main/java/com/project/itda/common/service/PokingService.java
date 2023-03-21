package com.project.itda.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.common.dao.IPokingRepository;

@Service
public class PokingService implements IPokingService {

	@Autowired
	IPokingRepository pokeDao;
	
}
