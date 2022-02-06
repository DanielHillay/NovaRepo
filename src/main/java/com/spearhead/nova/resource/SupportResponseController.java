package com.spearhead.nova.resource;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.Support;
import com.spearhead.nova.model.SupportResponse;
import com.spearhead.nova.service.SupportResponseService;

import com.spearhead.nova.service.impl.NotificationService;

import io.swagger.annotations.Api;

@Api(value = "Admin Endpoints",tags={"Support"}, description = "Rest APIs that Support Setup")


@RestController
@RequestMapping("/admin/api")
public class SupportResponseController {

	@Autowired
	private SupportResponseService supportResponseService;
	
	
	
	@Autowired
    NotificationService NService;
	
	
	@Autowired
	private EmailCfg emailCfg;
	
	@PostMapping("/savesupportandsendClientMail")
	
	public ResponseEntity<StandardResponse> saveSupportResponse(@RequestBody SupportResponse supportResponse) {
		
		
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
//	  mailSender.setHost(this.emailCfg.getEmailHost());
//	mailSender.setPort(this.emailCfg.getEmailPort());
//	mailSender.setUsername(this.emailCfg.getEmailUserName());
//	mailSender.setPassword(this.emailCfg.getEmailPassword());
	
	
	//Create Mail Instance
	SimpleMailMessage mailMessage = new SimpleMailMessage();
	mailMessage.setFrom(supportResponse.getEmail());
	//mailMessage.setTo(this.emailCfg.getAdminEmail());
	mailMessage.setTo(this.emailCfg.getAdminEmail());
	mailMessage.setSubject("Subject is " + supportResponse.getSupportResponseSubject());
	mailMessage.setText("Response " +  "\n" + supportResponse.getSupportResponseText());
	
	//Send Mail
	mailSender.send(mailMessage);
	return supportResponseService.saveSuppResponse(supportResponse);
		
		
		
		
}
//	public ResponseEntity<StandardResponse> saveSupportResponse(@RequestBody SupportResponse supportResponse) {
//				
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		
//		
//		 mailSender.setHost("smtp.gmail.com");
//		    mailSender.setPort(587);
//		    
//		    mailSender.setUsername(this.emailCfg.getEmailUserName());
//		    mailSender.setPassword(this.emailCfg.getEmailPassword());
//		
//		    Properties props = mailSender.getJavaMailProperties();
//		    props.put("mail.transport.protocol", "smtp");
//		    props.put("mail.smtp.auth", "true");
//		    props.put("mail.smtp.starttls.enable", "true");
//		    props.put("mail.debug", "true");
//
//		
//		
//		//Create Mail Instance
//		    SimpleMailMessage mailMessage = new SimpleMailMessage();
//		    mailMessage.setFrom(supportResponse.getEmail());
//		//mailMessage.setFrom(this.emailCfg.getAdminEmail());
//		    mailMessage.setTo(this.emailCfg.getAdminEmail());
//		//mailMessage.setTo(this.emailCfg.getAdminEmail());
//		mailMessage.setSubject("Subject is " + supportResponse.getSupportResponseSubject());
//		//mailMessage.setSubject("Subject is " + supportResponse.getSupportResponseSubject());
//		mailMessage.setText("Response Body" + supportResponse.getSupportResponseText());
//		
//		mailMessage.setText("Response " +  "\n" + supportResponse.getSupportResponseText());
//		
//		//Send Mail
//		mailSender.send(mailMessage);
//			return supportResponseService.saveSuppResponse(supportResponse);
//			
//			
//	}
}
