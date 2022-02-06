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
import com.spearhead.nova.model.SupportResponse;
import com.spearhead.nova.model.endpoint.SignOn;
import com.spearhead.nova.repository.AuditlogRepository;
import com.spearhead.nova.repository.FaqRepository;
import com.spearhead.nova.service.FaqService;

@Service
public class FaqImpl implements FaqService {
	
	@Autowired
	private FaqRepository faqRepository;
	
	@Autowired
	private AuditlogRepository auditlogRepo;

	@Override
	public ResponseEntity<StandardResponse> saveFaq(Faq faq) {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		AuditLogs auditlog = new AuditLogs();
		//auditlog.setAutologId(null);
		auditlog.setAction("Faq Saved");
		auditlog.setUserName(currentPrincipalName);
		
	  Faq data =	faqRepository.save(faq);
		auditlogRepo.save(auditlog);
	
		
		StandardResponse sr = new StandardResponse();
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("FAQ Have been Succesfully Saved ");
		sr.setData(data);
		 
	    return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		
		//return faqRepository.save(faq);
	}

	@Override
	public List<Faq> fetchFaq() {
		// TODO Auto-generated method stub
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		AuditLogs auditlog = new AuditLogs();
		//auditlog.setAutologId(null);
		auditlog.setAction("Get All Faq");
		auditlog.setUserName(currentPrincipalName);
		
		auditlogRepo.save(auditlog);
		return faqRepository.findAll();
		
	}

	@Override
	public ResponseEntity<StandardResponse> updateFaq(Long faqId, Faq faq) {
		// TODO Auto-generated method stub
		Faq faqDb = faqRepository.findById(faqId).get();
		if(Objects.nonNull(faq.getFaquest()) && !"".equalsIgnoreCase(faq.getFaquest())) {
			faqDb.setFaquest(faq.getFaquest());
		}
		if(Objects.nonNull(faq.getFaqans()) && !"".equalsIgnoreCase(faq.getFaqans())) {
			faqDb.setFaqans(faq.getFaqans());
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		AuditLogs auditlog = new AuditLogs();
		//auditlog.setAutologId(null);
		auditlog.setAction("Update Faq");
		auditlog.setUserName(currentPrincipalName);
		
		StandardResponse sr = new StandardResponse();
		try {
			Faq data =	faqRepository.save(faqDb);
			
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
		
			
		
	}

	@Override
	public void deletefaq(Long faqId) {
		// TODO Auto-generated method stub
		faqRepository.deleteById(faqId);
		
	}

}
