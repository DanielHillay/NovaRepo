package com.spearhead.nova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.AnnualData;
import com.spearhead.nova.repository.AnnualDataRepository;
import com.spearhead.nova.service.AnnualDataService;

@Service
public class AnnualDataImpl implements AnnualDataService {
	
	@Autowired
	AnnualDataRepository annualDataRepo;

	@Override
	public List<AnnualData> getGraph() {
		// TODO Auto-generated method stub
		return annualDataRepo.findAll();
	}

}
