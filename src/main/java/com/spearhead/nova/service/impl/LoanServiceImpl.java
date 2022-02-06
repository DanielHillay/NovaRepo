package com.spearhead.nova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.Loans;
import com.spearhead.nova.repository.LoanRepository;
import com.spearhead.nova.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepo;

	@Override
	public List<Loans> getLoans() {
		// TODO Auto-generated method stub
		return loanRepo.findAll();
	}


	
}
