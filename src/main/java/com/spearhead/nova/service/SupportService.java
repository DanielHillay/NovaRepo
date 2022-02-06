package com.spearhead.nova.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.Support;
import com.spearhead.nova.model.SupportResponse;

public interface SupportService {

	public ResponseEntity<StandardResponse> saveSupport(Support support);

	public List<Support> fetchSupport();

	public Support updateSupport(Long supportId, Support support);

	public void deleteSupport(Long supportId);

	public Support fetchSupportById(Long supportId);

	//public Support updateStatusById(String supportId, Support support);

  public void updateStatusById(Long supportId);

//public ResponseEntity<StandardResponse> saveSuppResponse(SupportResponse supportResponse);










	

	

}
