package com.spearhead.nova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class SupportResponse extends DateAudit  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "audit_user_generator")
    @SequenceGenerator(
   		name = "audit_user_generator",
   		sequenceName = "audit_user_sequence",
   		initialValue = 100
   		)
	private Long supportResponseId;
	
	@Column(columnDefinition = "LONGTEXT", nullable = false)
	private String supportResponseText;
	

	private String customerId;
	

	private String supportResponseSubject;
	

	private String email;

	private int supportResponsestatus;

	public Long getSupportResponseId() {
		return supportResponseId;
	}

	public void setSupportResponseId(Long supportResponseId) {
		this.supportResponseId = supportResponseId;
	}

	public String getSupportResponseText() {
		return supportResponseText;
	}

	public void setSupportResponseText(String supportResponseText) {
		this.supportResponseText = supportResponseText;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSupportResponseSubject() {
		return supportResponseSubject;
	}

	public void setSupportResponseSubject(String supportResponseSubject) {
		this.supportResponseSubject = supportResponseSubject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSupportResponsestatus() {
		return supportResponsestatus;
	}

	public void setSupportResponsestatus(int supportResponsestatus) {
		this.supportResponsestatus = supportResponsestatus;
	}

	@Override
	public String toString() {
		return "SupportResponse [supportResponseId=" + supportResponseId + ", supportResponseText="
				+ supportResponseText + ", customerId=" + customerId + ", supportResponseSubject="
				+ supportResponseSubject + ", email=" + email + ", supportResponsestatus=" + supportResponsestatus
				+ "]";
	}
	
	public SupportResponse() {
		super();
	}

	public SupportResponse(Long supportResponseId, String supportResponseText,  String customerId,
			 String supportResponseSubject, String email, int supportResponsestatus) {
		super();
		this.supportResponseId = supportResponseId;
		this.supportResponseText = supportResponseText;
		this.customerId = customerId;
		this.supportResponseSubject = supportResponseSubject;
		this.email = email;
		this.supportResponsestatus = supportResponsestatus;
	}
	
	
}
