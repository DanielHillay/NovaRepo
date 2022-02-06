package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class FundAccount extends DateAudit {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	
	private Long FundAccountId;
	
	private String fundDescription;
	private String fundCurrency;
	private String isMoneyMarketFund;
	private String customerId;
	private String customerName;
	private String accountId;
	private String accountDescription;
	private String registrarAccountId;
	private String balanceDate;
	private String totalPurchaseQuantity;
	private String totalSaleQuantity;
	private String totalBonusQuantity;
	
	private String balanceQuantity;
	private String totalPurchaseAmount;
	
	public Long getFundAccountId() {
		return FundAccountId;
	}
	public void setFundAccountId(Long fundAccountId) {
		FundAccountId = fundAccountId;
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
	public String getIsMoneyMarketFund() {
		return isMoneyMarketFund;
	}
	public void setIsMoneyMarketFund(String isMoneyMarketFund) {
		this.isMoneyMarketFund = isMoneyMarketFund;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountDescription() {
		return accountDescription;
	}
	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}
	public String getRegistrarAccountId() {
		return registrarAccountId;
	}
	public void setRegistrarAccountId(String registrarAccountId) {
		this.registrarAccountId = registrarAccountId;
	}
	public String getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}
	public String getTotalPurchaseQuantity() {
		return totalPurchaseQuantity;
	}
	public void setTotalPurchaseQuantity(String totalPurchaseQuantity) {
		this.totalPurchaseQuantity = totalPurchaseQuantity;
	}
	public String getTotalSaleQuantity() {
		return totalSaleQuantity;
	}
	public void setTotalSaleQuantity(String totalSaleQuantity) {
		this.totalSaleQuantity = totalSaleQuantity;
	}
	public String getTotalBonusQuantity() {
		return totalBonusQuantity;
	}
	public void setTotalBonusQuantity(String totalBonusQuantity) {
		this.totalBonusQuantity = totalBonusQuantity;
	}
	public String getBalanceQuantity() {
		return balanceQuantity;
	}
	public void setBalanceQuantity(String balanceQuantity) {
		this.balanceQuantity = balanceQuantity;
	}
	public String getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}
	public void setTotalPurchaseAmount(String totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	public String getTotalDividedAmount() {
		return totalDividedAmount;
	}
	public void setTotalDividedAmount(String totalDividedAmount) {
		this.totalDividedAmount = totalDividedAmount;
	}
	public String getTotalAccuredInterest() {
		return totalAccuredInterest;
	}
	public void setTotalAccuredInterest(String totalAccuredInterest) {
		this.totalAccuredInterest = totalAccuredInterest;
	}
	public String getOutstandingAccruedInterest() {
		return outstandingAccruedInterest;
	}
	public void setOutstandingAccruedInterest(String outstandingAccruedInterest) {
		this.outstandingAccruedInterest = outstandingAccruedInterest;
	}
	public String getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}
	public String getCostValue() {
		return costValue;
	}
	public void setCostValue(String costValue) {
		this.costValue = costValue;
	}
	public String getCurrentBidPrice() {
		return currentBidPrice;
	}
	public void setCurrentBidPrice(String currentBidPrice) {
		this.currentBidPrice = currentBidPrice;
	}
	public String getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}
	public String getGainLossAmount() {
		return gainLossAmount;
	}
	public void setGainLossAmount(String gainLossAmount) {
		this.gainLossAmount = gainLossAmount;
	}
	public String getCashAccountId() {
		return cashAccountId;
	}
	public void setCashAccountId(String cashAccountId) {
		this.cashAccountId = cashAccountId;
	}
	public String getCashAccountDescription() {
		return cashAccountDescription;
	}
	public void setCashAccountDescription(String cashAccountDescription) {
		this.cashAccountDescription = cashAccountDescription;
	}
	private String totalDividedAmount;
	private String totalAccuredInterest;
	private String outstandingAccruedInterest;
	private String costPrice;
	private String costValue;
	private String currentBidPrice;
	private String currentValue;
	private String gainLossAmount;
	private String cashAccountId;
	private String cashAccountDescription;

	public FundAccount(Long fundAccountId, String fundDescription, String fundCurrency, String isMoneyMarketFund,
			String customerId, String customerName, String accountId, String accountDescription,
			String registrarAccountId, String balanceDate, String totalPurchaseQuantity, String totalSaleQuantity,
			String totalBonusQuantity, String balanceQuantity, String totalPurchaseAmount, String totalDividedAmount,
			String totalAccuredInterest, String outstandingAccruedInterest, String costPrice, String costValue,
			String currentBidPrice, String currentValue, String gainLossAmount, String cashAccountId,
			String cashAccountDescription) {
		super();
		FundAccountId = fundAccountId;
		this.fundDescription = fundDescription;
		this.fundCurrency = fundCurrency;
		this.isMoneyMarketFund = isMoneyMarketFund;
		this.customerId = customerId;
		this.customerName = customerName;
		this.accountId = accountId;
		this.accountDescription = accountDescription;
		this.registrarAccountId = registrarAccountId;
		this.balanceDate = balanceDate;
		this.totalPurchaseQuantity = totalPurchaseQuantity;
		this.totalSaleQuantity = totalSaleQuantity;
		this.totalBonusQuantity = totalBonusQuantity;
		this.balanceQuantity = balanceQuantity;
		this.totalPurchaseAmount = totalPurchaseAmount;
		this.totalDividedAmount = totalDividedAmount;
		this.totalAccuredInterest = totalAccuredInterest;
		this.outstandingAccruedInterest = outstandingAccruedInterest;
		this.costPrice = costPrice;
		this.costValue = costValue;
		this.currentBidPrice = currentBidPrice;
		this.currentValue = currentValue;
		this.gainLossAmount = gainLossAmount;
		this.cashAccountId = cashAccountId;
		this.cashAccountDescription = cashAccountDescription;
	}
	
	
	public FundAccount() {
		super();
	}
	
}
