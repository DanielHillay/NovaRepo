package com.spearhead.nova.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailCfg {

	 @Value("${spring.mail.username}")
	private String emailUserName;
	
	 @Value("${spring.mail.host}")
	private String emailHost;
	 @Value("${spring.mail.port}")
	private int emailPort;
	 @Value("${spring.mail.password}")
	private String emailPassword;
	
	 @Value("${admin.email}")
	 private String adminEmail;
	 
	 
	 
	 
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getEmailUserName() {
		return emailUserName;
	}
	public void setEmailUserName(String emailUserName) {
		this.emailUserName = emailUserName;
	}
	public String getEmailHost() {
		return emailHost;
	}
	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}
	public int getEmailPort() {
		return emailPort;
	}
	public void setEmailPort(int emailPort) {
		this.emailPort = emailPort;
	}
	public String getEmailPassword() {
		return emailPassword;
	}
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	
	
	
}
