package com.spearhead.nova.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spearhead.nova.model.Loans;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.service.LoanService;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
"Loan" }, description = "Rest APIs that Returns Information Corncering the Customer")
@RestController
@RequestMapping("/admin/api/loans")
public class LoanController {
	
	
	   @Autowired
		  LoanService loanService;
	
	   @GetMapping("/allloans")
	   public ResponseEntity<StandardResponse> getLoans(){
		//return loanService.getLoans();
		
		 Object data = loanService.getLoans();;
	    	// return userServices.getUser();
	    	 
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
