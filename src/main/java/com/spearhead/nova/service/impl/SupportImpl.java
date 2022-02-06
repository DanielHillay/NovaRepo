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
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.Support;
import com.spearhead.nova.model.SupportResponse;
import com.spearhead.nova.repository.AuditlogRepository;
import com.spearhead.nova.repository.SupportRepository;
import com.spearhead.nova.repository.SupportResponseRepository;
import com.spearhead.nova.service.SupportService;

@Service
public class SupportImpl implements SupportService{

	@Autowired
	private SupportRepository supportRepository;
	
//	@Autowired
//	private SupportResponseRepository supportResponseRepository;
//	
	@Autowired
	private AuditlogRepository auditlogRepo;

	@Override
	public ResponseEntity<StandardResponse> saveSupport(Support support) {
		// TODO Auto-generated method stub
		
		supportRepository.save(support);
		
		StandardResponse sr = new StandardResponse();
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Support Request Have been Succesfully Saved");
		
	    return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		//return supportRepository.save(support);
	}

	@Override
	public List<Support> fetchSupport() {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		AuditLogs auditlog = new AuditLogs();
		//auditlog.setAutologId(null);
		auditlog.setAction("Get All User Support Response");
		auditlog.setUserName(currentPrincipalName);
		auditlogRepo.save(auditlog);
		return supportRepository.findAll();
	}

	@Override
	public Support updateSupport(Long supportId, Support support) {
		// TODO Auto-generated method stub
		Support supportDb = supportRepository.findById(supportId).get();
		if(Objects.nonNull(support.getSupportText()) && !"".equalsIgnoreCase(support.getSupportText())) {
			supportDb.setSupportText(support.getSupportText());
		}
		return supportRepository.save(supportDb);
	}

	@Override
	public void deleteSupport(Long supportId) {
		// TODO Auto-generated method stub
		supportRepository.deleteById(supportId);
	}

	@Override
	public Support fetchSupportById(Long supportId) {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		AuditLogs auditlog = new AuditLogs();
		//auditlog.setAutologId(null);
		auditlog.setAction("Get User Support Response By Id");
		auditlog.setUserName(currentPrincipalName);
		auditlogRepo.save(auditlog);
		return supportRepository.findById(supportId).get();
	}

	@Override
	public void updateStatusById(Long supportId) {
		// TODO Auto-generated method stub
		supportRepository.updateStatusById(supportId);
	}

//	@Override
//	public ResponseEntity<StandardResponse> saveSuppResponse(SupportResponse supportResponse) {
//		// TODO Auto-generated method stub
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();
//		AuditLogs auditlog = new AuditLogs();
//		//auditlog.setAutologId(null);
//		auditlog.setAction("Save Admin Support Response By Id");
//		auditlog.setUserName(currentPrincipalName);
//		
//		supportResponseRepository.save(supportResponse);
//		auditlogRepo.save(auditlog);
//		StandardResponse sr = new StandardResponse();
//		sr.setStatus(true);
//		sr.setStatuscode("200");
//		sr.setMessage("Support Request Have been Succesfully Saved");
//		
//	    return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
//		//return supportResponseRepository.save(supportResponse);
//	}

	


	
	

	



	

	

	
}
