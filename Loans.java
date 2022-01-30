package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Loans extends DateAudit {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long loanId;
	private String loanDescription;
	private String currencyId;
	private String currencyDescription;
	private String loanType;
	private String effectiveDate;
	private String maturityDate;
	private String tenorInMonths;
	private String interestRate;
	private String loanAmount;
	private String customerId;
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Long getLoanId() {
		return loanId;
	}
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	public String getLoanDescription() {
		return loanDescription;
	}
	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencyDescription() {
		return currencyDescription;
	}
	public void setCurrencyDescription(String currencyDescription) {
		this.currencyDescription = currencyDescription;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	public String getTenorInMonths() {
		return tenorInMonths;
	}
	public void setTenorInMonths(String tenorInMonths) {
		this.tenorInMonths = tenorInMonths;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Loans(Long loanId, String loanDescription, String currencyId, String currencyDescription, String loanType,
			String effectiveDate, String maturityDate, String tenorInMonths, String interestRate, String loanAmount, String customerId) {
		super();
		this.loanId = loanId;
		this.loanDescription = loanDescription;
		this.currencyId = currencyId;
		this.currencyDescription = currencyDescription;
		this.loanType = loanType;
		this.effectiveDate = effectiveDate;
		this.maturityDate = maturityDate;
		this.tenorInMonths = tenorInMonths;
		this.interestRate = interestRate;
		this.loanAmount = loanAmount;
		this.customerId = customerId;
	}
	
	public Loans() {
		super();
	}

}
