package com.spearhead.nova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.FundPortfolio;
import com.spearhead.nova.repository.FundPortfoliioRepository;
import com.spearhead.nova.service.FundPortfolioService;

@Service
public class FundPortfolioImp implements FundPortfolioService {
	
	@Autowired
	FundPortfoliioRepository fundPortfolioRepo;

	@Override
	public List<FundPortfolio> getFundPortfolio() {
		// TODO Auto-generated method stub
		return fundPortfolioRepo.findAll();
	}

}
