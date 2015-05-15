/**
 * 
 */
package com.neu.css.payment.model;

public class ImplPaymentBean {
	private ImplBillingAddressBean implBillingAddressBean;
	private Integer paymentId;
	private Integer userId;
	private String accountHolderName;
	private String cardType;
	private String cardNumber;
	private String securityCode;
	private String expiryMonthYear;
	
	public ImplBillingAddressBean getImplBillingAddressBean() {
		return implBillingAddressBean;
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public String getCardType() {
		return cardType;
	}
	
	public String getSecurityCode() {
		return securityCode;
	}
	
	public String getExpiryMonthYear() {
		return expiryMonthYear;
	}

	public void setImplBillingAddressBean(
			ImplBillingAddressBean implBillingAddressBean) {
		this.implBillingAddressBean = implBillingAddressBean;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
	public void setExpiryMonthYear(String expiryMonthYear) {
		this.expiryMonthYear = expiryMonthYear;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	

}
