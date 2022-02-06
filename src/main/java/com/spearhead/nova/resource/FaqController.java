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

import com.spearhead.nova.model.Faq;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.User;
import com.spearhead.nova.service.FaqService;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints",tags={"Terms and Service"}, description = "Rest APIs that Setup Terms and Service")


@RestController
@RequestMapping("/admin/api")
public class FaqController {
	
	@Autowired
	private FaqService faqService;
	
	
//	public Faq saveFaq(@RequestBody Faq faq) {
//		return faqService.saveFaq(faq);
//	}
	
	@PostMapping("/savefaq")
	public ResponseEntity<StandardResponse> saveFaq(@RequestBody Faq faq){
		return faqService.saveFaq(faq);	
	}
	
	@GetMapping("/getfaq")
	public List<Faq> fetchFaq(){
		return faqService.fetchFaq();
	}
	
	
	
//	@PutMapping("/editdeletefaq/{id}")
//	public Faq updateFaq(@PathVariable("id") Long faqId, @RequestBody Faq faq) {
//		return faqService.updateFaq(faqId, faq);
//	}
	
	@PutMapping("/editdeletefaq/{id}")
	public ResponseEntity<StandardResponse> updateFaq(@PathVariable("id") Long faqId, @RequestBody Faq faq) {
		return faqService.updateFaq(faqId, faq);
	}
	
	
	
	
	@DeleteMapping("/editdeletefaq/{id}")
	public ResponseEntity<StandardResponse> deletefaq(@PathVariable("id") Long faqId) {
		
		//return "Faq has been sucessfully deleted"; 
		StandardResponse sr = new StandardResponse();
		
	try {
			
			faqService.deletefaq(faqId);
			sr.setStatus(true);
			sr.setStatuscode("200");
			sr.setMessage("Successful Deletion");
			
			 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		}catch(Exception e) {
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		
	}

}
