/**
 * 
 */
package com.neu.css.payment.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "TABLE_PAYMENT_MODE")
public class ImplPaymentMode {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAYMENT_ID")
	private Integer paymentId;
	@Column(name="USER_ID")
	private Integer userID;
	@Column(name="ACCOUNT_HOLDER_NAME")
	private String accountHolderName;
	@Column(name="CARD_TYPE")
	private String cardType;
	@Column(name="CARD_NUMBER")
	private String cardNumber;
	@Column(name="SECURITY_CODE")
	private String securityCode;
	@Column(name="EXPIRY_MONTH_YEAR")
	private String expiryMonthYear;
	@OneToOne(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="BILLING_ADDRESS_ID")
	private ImplBillingAddress implBillingAddress;
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public String getCardType() {
		return cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	
	public String getSecurityCode() {
		return securityCode;
	}
	
	public String getExpiryMonthYear() {
		return expiryMonthYear;
	}
	
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
	public void setExpiryMonthYear(String expiryMonthYear) {
		this.expiryMonthYear = expiryMonthYear;
	}
	
	public ImplBillingAddress getImplBillingAddress() {
		return implBillingAddress;
	}
	public void setImplBillingAddress(ImplBillingAddress implBillingAddress) {
		this.implBillingAddress = implBillingAddress;
	}
}
