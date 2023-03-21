package com.project.itda.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itda.common.dao.IFamilyRepository;

@Service
public class FamilyService implements IFamilyService {

	@Autowired
	IFamilyRepository familyDao;
}
