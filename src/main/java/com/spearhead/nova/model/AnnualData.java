package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class AnnualData extends DateAudit {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long annualDataId;
	private String month;
	private Float totalAmount;
	public Long getAnnualDataId() {
		return annualDataId;
	}
	public void setAnnualDataId(Long annualDataId) {
		this.annualDataId = annualDataId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public AnnualData(Long annualDataId, String month, Float totalAmount) {
		super();
		this.annualDataId = annualDataId;
		this.month = month;
		this.totalAmount = totalAmount;
	}
	
	
	public AnnualData() {
		super();
	}
}
