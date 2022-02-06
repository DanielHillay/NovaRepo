package com.spearhead.nova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Support extends DateAudit {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "audit_user_generator")
    @SequenceGenerator(
   		name = "audit_user_generator",
   		sequenceName = "audit_user_sequence",
   		initialValue = 100
   		)
	
	private Long supportId;
	@Column(columnDefinition = "LONGTEXT", nullable = false)
	private String supportText;
	@NotNull
	private String customerId;
	
	@NotNull
	private String supportSubject;
	
	@NotNull
	private String supportPriority;
	
	@NotNull
	@Email
	private String email;
	@Column(columnDefinition="tinyint(1)")
	private boolean status;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSupportSubject() {
		return supportSubject;
	}
	public void setSupportSubject(String supportSubject) {
		this.supportSubject = supportSubject;
	}
	public String getSupportPriority() {
		return supportPriority;
	}
	public void setSupportPriority(String supportPriority) {
		this.supportPriority = supportPriority;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Long getSupportId() {
		return supportId;
	}
	public void setSupportId(Long supportId) {
		this.supportId = supportId;
	}
	public String getSupportText() {
		return supportText;
	}
	public void setSupportText(String supportText) {
		this.supportText = supportText;
	}
	
	


	@Override
	public String toString() {
		return "Support [supportId=" + supportId + ", supportText=" + supportText + ", customerId=" + customerId
				+ ", supportSubject=" + supportSubject + ", supportPriority=" + supportPriority + ", email=" + email
				+ ", status=" + status + "]";
	}
	public Support() {
		super();
	}
	public Support(Long supportId, String supportText, @NotNull String customerId, @NotNull String supportSubject,
			@NotNull String supportPriority, @NotNull String email, boolean status) {
		super();
		this.supportId = supportId;
		this.supportText = supportText;
		this.customerId = customerId;
		this.supportSubject = supportSubject;
		this.supportPriority = supportPriority;
		this.email = email;
		this.status = status;
	}
	
	
	
	
	
	
}
