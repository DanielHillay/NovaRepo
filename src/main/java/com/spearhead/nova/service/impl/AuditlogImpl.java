package com.spearhead.nova.service.impl;

//import java.time.LocalDateTime;
//import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.AuditLogs;
import com.spearhead.nova.repository.AuditlogRepository;
import com.spearhead.nova.service.AuditlogService;


@Service
public class AuditlogImpl implements AuditlogService {

	@Autowired
	private AuditlogRepository auditlogRepository;
	
	@Override
	public List<AuditLogs> fetchAuditlogList() {
		// TODO Auto-generated method stub
		return auditlogRepository.findAll();
	}



	@Override
	public AuditLogs saveAuditlog(AuditLogs auditlogs) {
		// TODO Auto-generated method stub
		return auditlogRepository.save(auditlogs);
	}



	@Override
	public List<AuditLogs> getAllBetweenDates(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return auditlogRepository.getAllBetweenDates(startDate, endDate);
	}



	@Override
	public List<AuditLogs> getAllBetweenDatesById(String startDate, String endDate, Integer userid) {
		// TODO Auto-generated method stub
		return auditlogRepository.getAllBetweenDatesById(startDate, endDate, userid);
	}



	



	


	

}
