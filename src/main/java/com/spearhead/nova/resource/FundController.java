package com.spearhead.nova.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.service.FundService;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
"Mutual Funds" }, description = "Rest APIs that Returns Information Corncering the Customer")
@RestController
@RequestMapping("/admin/api/funds")
public class FundController {
	
	@Autowired
	FundService fundService;
	
	@GetMapping("/getAllFunds")
	
	 public ResponseEntity<StandardResponse> getAllFunds() {
		Object data = fundService.getAllFunds();
		 StandardResponse sr = new StandardResponse();
	 		
	 		try {
	 			
	 			sr.setStatus(true);
	 			sr.setStatuscode("200");
	 			sr.setMessage("All Loans  Returned");
	 			sr.setData(data);
	 			
	 			 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
	 		}catch(Exception e) {
	 			sr.setStatus(false);
	 			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
	 		}
	
		
	}

}
