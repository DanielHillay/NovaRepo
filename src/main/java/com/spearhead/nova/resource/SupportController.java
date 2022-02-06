package com.spearhead.nova.resource;

import java.util.List;
//import java.util.Optional;
import java.util.Properties;

//import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.Support;
import com.spearhead.nova.model.SupportResponse;
import com.spearhead.nova.service.SupportService;
import com.spearhead.nova.service.impl.NotificationService;

import io.swagger.annotations.Api;

@Api(value = "Admin Endpoints",tags={"Support"}, description = "Rest APIs that Support Setup")


@RestController
@RequestMapping("/admin/api")
public class SupportController {
	@Autowired
	private SupportService supportService;
	
	@Autowired
    NotificationService NService;
	
	
	@Autowired
	private EmailCfg emailCfg;
	
	@PostMapping("/savesupportandsendtoadminmail")
	public ResponseEntity<StandardResponse> saveSupport(@RequestBody Support support) {
			
	
			//support.setEmail("lanre.bolaji007@gmail.com");		
			//NService.sendSupportNotification(support);
			//Create Mail Sender
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		
		 mailSender.setHost("smtp.gmail.com");
		    mailSender.setPort(587);
		    
		    mailSender.setUsername(this.emailCfg.getEmailUserName());
				    mailSender.setPassword(this.emailCfg.getEmailPassword());
		
		  Properties props = mailSender.getJavaMailProperties();
		    props.put("mail.transport.protocol", "smtp");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.debug", "true");
//		  mailSender.setHost(this.emailCfg.getEmailHost());
//		mailSender.setPort(this.emailCfg.getEmailPort());
//		mailSender.setUsername(this.emailCfg.getEmailUserName());
//		mailSender.setPassword(this.emailCfg.getEmailPassword());
		
		
		//Create Mail Instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(support.getEmail());
		//mailMessage.setTo(this.emailCfg.getAdminEmail());
		mailMessage.setTo(this.emailCfg.getAdminEmail());
		mailMessage.setSubject("Subject is " + support.getSupportSubject());
		mailMessage.setText("Priority" + support.getSupportPriority() + "\n" + support.getSupportText());
		
		//Send Mail
		mailSender.send(mailMessage);
			return supportService.saveSupport(support);
			
			
			
			
	}
	
	
	

	
	
	@GetMapping("/getsupport")
	public List<Support> fetchSupport(){
		return  supportService.fetchSupport();
	}
	
	@GetMapping("/getsupport/{id}")
	
	public Support fetchSupportById(@PathVariable("id") Long supportId) {
		return supportService.fetchSupportById(supportId);
	}

//	@PutMapping("/editdeletesupport/{id}")
//	
//	public Support updateSupport(@PathVariable("id") Long supportId, @RequestBody Support support) {
//		return  supportService.updateSupport(supportId, support);
//	}
	
	@PutMapping("/updateticketstatus/{id}")
	public String  updateStatusById(@PathVariable("id") Long supportId) {
		supportService.updateStatusById(supportId);
		return "Ticket has been Succesfully updated to Closed";
	}
	
//	@DeleteMapping("/editdeletesupport/{id}")
//	public String deleteSupport(@PathVariable("id") Long supportId) {
//		supportService.deleteSupport(supportId);
//		return "Support has been sucessfully deleted"; 
//	}
}
