/**
 * 
 */
package com.neu.css.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TABLE_BILLING_ADDRESS")
public class ImplBillingAddress {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BILLING_ID")
	private Integer billingAddressID;
	@Column(name="BILLING_ADDRES_1")
	private String billingAddress1;
	@Column(name="BILLING_ADDRES_2")
	private String billingAddress2;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="PINCODE")
	private String pincode;
	
	
	public Integer getBillingAddressID() {
		return billingAddressID;
	}
	public void setBillingAddressID(Integer billingAddressID) {
		this.billingAddressID = billingAddressID;
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
