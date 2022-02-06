package com.spearhead.nova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.Fund;
import com.spearhead.nova.repository.FundRepository;
import com.spearhead.nova.service.FundService;

@Service
public class FundImpl implements FundService{

	@Autowired
	FundRepository fundRepo;
	@Override
	public List<Fund> getAllFunds() {
		// TODO Auto-generated method stub
		return fundRepo.findAll();
	}

}
