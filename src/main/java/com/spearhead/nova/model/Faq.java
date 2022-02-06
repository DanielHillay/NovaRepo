package com.spearhead.nova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Faq extends DateAudit {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "audit_user_generator")
    @SequenceGenerator(
   		name = "audit_user_generator",
   		sequenceName = "audit_user_sequence",
   		initialValue = 100
   		)
	
	private Long faqId;
	
	@Column(columnDefinition = "LONGTEXT", nullable = false)
	private String faquest;
	
	@Column(columnDefinition = "LONGTEXT", nullable = false)
	//@Column(name="faqans", length=512, nullable = false)
	private String faqans;
	

	public Long getFaqId() {
		return faqId;
	}
	public void setFaqId(Long faqId) {
		this.faqId = faqId;
	}
	public String getFaquest() {
		return faquest;
	}
	public void setFaquest(String faquest) {
		this.faquest = faquest;
	}
	public String getFaqans() {
		return faqans;
	}
	public void setFaqans(String faqans) {
		this.faqans = faqans;
	}
	
	
	@Override
	public String toString() {
		return "Faq [faqId=" + faqId + ", faquest=" + faquest + ", faqans=" + faqans + "]";
	}
	
	public Faq() {
		super();
	}

	
	
	public Faq(Long faqId, String faquest, String faqans) {
		super();
		this.faqId = faqId;
		this.faquest = faquest;
		this.faqans = faqans;
	}
	
	

}
