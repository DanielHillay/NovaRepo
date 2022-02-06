package com.spearhead.nova.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.Terms;
import com.spearhead.nova.service.TermService;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints",tags={"Terms and Service"}, description = "Rest APIs that Setup Terms and Service")


@RestController
@RequestMapping("/admin/api")
public class TermController {

	@Autowired
	private TermService termService;
	
	//@PostMapping("/savetermsandcondition")
//	public Terms saveTerms(@RequestBody Terms terms) {
//		try {
//		return termService.saveTerms(terms);
//		}catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//		
//		return null;
//	}
	
	@PostMapping("/savetermsandcondition")
	public ResponseEntity<StandardResponse> saveTerms(@RequestBody Terms terms){
		return termService.saveTerms(terms);
	}
	
	@GetMapping("/gettermsandcondition")
	public List<Terms> fetchTermsText(){
		return termService.fetchTermsText();
		
	}
	
//	@PutMapping("/editdeletetermsandservice/{id}")
//	public Terms updateTerms(@PathVariable("id") Long termsId, @RequestBody Terms terms ) {
//		return  termService.updateTerms(termsId, terms);
//	}
	
	@PutMapping("/editdeletetermsandservice/{id}")
	public ResponseEntity<StandardResponse> updateTerms(@PathVariable("id") Long termsId, @RequestBody Terms terms ) {
		return  termService.updateTerms(termsId, terms);
	}
	
	@DeleteMapping("/editdeletetermsandservice/{id}")
	public  ResponseEntity<StandardResponse> deleteTerms(@PathVariable("id") Long termsId) {
		
		
		StandardResponse sr = new StandardResponse();
		
	try {
			
		termService.deleteTerms(termsId);
			sr.setStatus(true);
			sr.setStatuscode("200");
			sr.setMessage("Successful Deletion");
			
			 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		}catch(Exception e) {
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		//return "Terms and Service have been succesfully deleted";
	}
	
} 
