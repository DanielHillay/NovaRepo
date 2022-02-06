package com.spearhead.nova.service;

import org.springframework.http.ResponseEntity;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.SupportResponse;

public interface SupportResponseService {

	ResponseEntity<StandardResponse> saveSuppResponse(SupportResponse supportResponse);

	
}
