package com.spearhead.nova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spearhead.nova.model.Loans;
import com.spearhead.nova.model.User;

public interface LoanService {

	public List<Loans> getLoans();

	
	

}
