/**
 * 
 */
package com.neu.css.payment.model;


public class ImplBillingAddressBean {
	private Integer billingAddressID;
	private String billingAddress1;
	private String billingAddress2;
	private String city;
	private String state;
	private String country;
	private String pincode;
	public Integer getBillingAddressID() {
		return billingAddressID;
	}
	public String getBillingAddress1() {
		return billingAddress1;
	}
	public String getBillingAddress2() {
		return billingAddress2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setBillingAddressID(Integer billingAddressID) {
		this.billingAddressID = billingAddressID;
	}
	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}
	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
