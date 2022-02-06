package com.spearhead.nova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.FundAccount;
import com.spearhead.nova.repository.FundAccountRepository;
import com.spearhead.nova.service.FundAccountService;

@Service
public class FundAccountImpl implements FundAccountService {

	@Autowired
	FundAccountRepository fundAccountRepo;
	@Override
	public List<FundAccount> getAllFundAccount() {
		// TODO Auto-generated method stub
		return fundAccountRepo.findAll();
	}

}
