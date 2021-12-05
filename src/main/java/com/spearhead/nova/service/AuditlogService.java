package com.spearhead.nova.service;

import java.util.List;

import com.spearhead.nova.model.AuditLogs;



public interface AuditlogService {
	
	public List<AuditLogs> fetchAuditlogList();

}
