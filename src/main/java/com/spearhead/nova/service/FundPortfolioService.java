package com.spearhead.nova.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spearhead.nova.model.Fund;
import com.spearhead.nova.model.FundPortfolio;


public interface FundPortfolioService {

	public List<FundPortfolio> getFundPortfolio();

}
