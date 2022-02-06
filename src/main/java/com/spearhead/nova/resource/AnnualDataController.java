package com.spearhead.nova.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spearhead.nova.model.AnnualData;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.service.AnnualDataService;


import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
"Graph" }, description = "Rest APIs that Returns Information Corncering the Customer")
@RestController
@RequestMapping("/admin/api/graph")

public class AnnualDataController {
	
	@Autowired
	private AnnualDataService annualService;
	
	@GetMapping("/getannualData")
	public ResponseEntity<StandardResponse> getGraph(){
		
		
		StandardResponse sr = new StandardResponse();
		
try {
			
	 	Object data =  annualService.getGraph();
			sr.setStatus(true);
			sr.setStatuscode("200");
			sr.setMessage("Data For Graph Returned");
			sr.setData(data);
			
			 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		}catch(Exception e) {
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	  
}
