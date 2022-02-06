package com.spearhead.nova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.SupportResponse;
import com.spearhead.nova.repository.SupportResponseRepository;
import com.spearhead.nova.service.SupportResponseService;

@Service
public class SupportResponseImp implements SupportResponseService {

	@Autowired
	private SupportResponseRepository supportResponseRepo;
	@Override
	public ResponseEntity<StandardResponse> saveSuppResponse(SupportResponse supportResponse) {
		// TODO Auto-generated method stub
		StandardResponse sr = new StandardResponse();
		try {
			SupportResponse data =	supportResponseRepo.save(supportResponse);
			
			sr.setStatus(true);
			sr.setStatuscode("200");
			sr.setMessage("Support Request Response Have been Succesfully Saved");
			sr.setData(data);
			 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		}catch(Exception e) {
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		
	
	}

}
