package com.spearhead.nova.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.AuditLogs;
import com.spearhead.nova.model.Faq;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.Terms;
import com.spearhead.nova.repository.AuditlogRepository;
import com.spearhead.nova.repository.TermRepository;
import com.spearhead.nova.service.TermService;

@Service
public class TermImpl implements TermService {

	@Autowired
	private TermRepository termRepository;

	@Autowired
	private AuditlogRepository auditlogRepo;
	
	@Override
	public ResponseEntity<StandardResponse> saveTerms(Terms terms) {
		// TODO Auto-generated method stub
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		AuditLogs auditlog = new AuditLogs();
		//auditlog.setAutologId(null);
		auditlog.setAction("Save Terms and Condition");
		auditlog.setUserName(currentPrincipalName);
		
		termRepository.save(terms);
		auditlogRepo.save(auditlog);
		
		StandardResponse sr = new StandardResponse();
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Terms and Condition Have been Succesfully Saved");
		
	    return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		//return termRepository.save(terms);
	}

	@Override
	public List<Terms> fetchTermsText() {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		AuditLogs auditlog = new AuditLogs();
		//auditlog.setAutologId(null);
		if(currentPrincipalName != "" || currentPrincipalName == null) {
			auditlog.setAction("Get All Terms and Condition");
			auditlog.setUserName(currentPrincipalName);
			
		}else {
			auditlog.setAction("Get All Terms and Condition");
			auditlog.setUserName("Users");
		}
		
		auditlogRepo.save(auditlog);
		return termRepository.findAll();
	}

	@Override
	public ResponseEntity<StandardResponse> updateTerms(Long termsId, Terms terms) {
		// TODO Auto-generated method stub
		Terms termDb = termRepository.findById(termsId).get();
		if(Objects.nonNull(terms.getTerms()) && !"".equalsIgnoreCase(terms.getTerms())) {
			termDb.setTerms(terms.getTerms());
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		AuditLogs auditlog = new AuditLogs();
		//auditlog.setAutologId(null);
		auditlog.setAction("Update Terms and Condition");
		auditlog.setUserName(currentPrincipalName);
		
		StandardResponse sr = new StandardResponse();
		
		auditlogRepo.save(auditlog);
		
		try {
			Terms data =	termRepository.save(termDb);
			
			sr.setStatus(true);
			sr.setStatuscode("200");
			sr.setMessage("Faq have been Succesfully Update");
			sr.setData(data);
			auditlogRepo.save(auditlog);
			 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		}catch(Exception e) {
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		
		//return termRepository.save(termDb);
	}

	@Override
	public void deleteTerms(Long termsId) {
		// TODO Auto-generated method stub
		termRepository.deleteById(termsId);
	}
}
