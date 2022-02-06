package com.spearhead.nova.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.Terms;

public interface TermService {
	
	public ResponseEntity<StandardResponse> saveTerms(Terms terms);

	public List<Terms> fetchTermsText();

	public ResponseEntity<StandardResponse> updateTerms(Long termsId, Terms terms);

	public void deleteTerms(Long termsId);

	

}
