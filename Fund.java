package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity	
public class Fund extends DateAudit {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long fundId;
	private String fundDescription;
	private String fundCurrency;
	private String fundType;
	private String dateOpened;
	private Float minimumInvestmentAmount;
	private Float subsequentMultiples;
	private Float offerPrice;
	private Float bidPrice;
	private Float isMoneyMarket;
	private String investmestBasis;
	public Long getFundId() {
		return fundId;
	}
	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}
	public String getFundDescription() {
		return fundDescription;
	}
	public void setFundDescription(String fundDescription) {
		this.fundDescription = fundDescription;
	}
	public String getFundCurrency() {
		return fundCurrency;
	}
	public void setFundCurrency(String fundCurrency) {
		this.fundCurrency = fundCurrency;
	}
	public String getFundType() {
		return fundType;
	}
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	public String getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}
	public Float getMinimumInvestmentAmount() {
		return minimumInvestmentAmount;
	}
	public void setMinimumInvestmentAmount(Float minimumInvestmentAmount) {
		this.minimumInvestmentAmount = minimumInvestmentAmount;
	}
	public Float getSubsequentMultiples() {
		return subsequentMultiples;
	}
	public void setSubsequentMultiples(Float subsequentMultiples) {
		this.subsequentMultiples = subsequentMultiples;
	}
	public Float getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(Float offerPrice) {
		this.offerPrice = offerPrice;
	}
	public Float getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(Float bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Float getIsMoneyMarket() {
		return isMoneyMarket;
	}
	public void setIsMoneyMarket(Float isMoneyMarket) {
		this.isMoneyMarket = isMoneyMarket;
	}
	public String getInvestmestBasis() {
		return investmestBasis;
	}
	public void setInvestmestBasis(String investmestBasis) {
		this.investmestBasis = investmestBasis;
	}
	@Override
	public String toString() {
		return "Fund [fundId=" + fundId + ", fundDescription=" + fundDescription + ", fundCurrency=" + fundCurrency
				+ ", fundType=" + fundType + ", dateOpened=" + dateOpened + ", minimumInvestmentAmount="
				+ minimumInvestmentAmount + ", subsequentMultiples=" + subsequentMultiples + ", offerPrice="
				+ offerPrice + ", bidPrice=" + bidPrice + ", isMoneyMarket=" + isMoneyMarket + ", investmestBasis="
				+ investmestBasis + "]";
	}
	
	public Fund() {
		super();
	}
	
		

}
