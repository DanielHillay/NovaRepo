 package com.spearhead.nova.resource;

//import java.time.LocalDateTime;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import com.spearhead.nova.model.AuditLogs;
import com.spearhead.nova.service.AuditlogService;

import io.swagger.annotations.Api;


@Api(value = "User Endpoints",tags={"Audit Log"}, description = "Rest APIs that Returns Information Corncering the Customer Action")

@RestController
@RequestMapping("/admin/api/customer/audit")
public class AuditlogController {
	
	@Autowired
	private AuditlogService auditlogService;

	@PostMapping("/saveuseractions")
	 public AuditLogs saveAuditlog(@RequestBody AuditLogs auditlogs) {
		 System.out.println("Hello " + auditlogs);
		   try {
		  return auditlogService.saveAuditlog(auditlogs);
		   }catch (Exception ex){
			   System.out.println(ex.getMessage());
		   }
		   
		   return null;
	 }
	
	 @GetMapping("/details")
	 public List<AuditLogs> fetchAuditlogList(){
		return auditlogService.fetchAuditlogList();
		 
	 }
	 
	 @GetMapping("/detailsbydaterange/{startDate}/{endDate}")
	 public List<AuditLogs> getAllBetweenDates(@PathVariable("startDate") String  startDate,
			 @PathVariable("endDate") String   endDate){
				return auditlogService.getAllBetweenDates(startDate, endDate);
		
		 
	 }
	 
	 @GetMapping("/detailsbydaterangebyid/{startDate}/{endDate}/{username}")
	 public List<AuditLogs> getAllBetweenDatesById(@PathVariable("startDate") String  startDate,
			 @PathVariable("endDate") String   endDate,  @PathVariable("username") Integer   userid){
				return auditlogService.getAllBetweenDatesById(startDate, endDate, userid);
		
		 
	 }
	 
	 
	 
	 
}
