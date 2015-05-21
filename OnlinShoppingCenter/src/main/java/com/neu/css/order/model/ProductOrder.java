/**
 * 
 */
package com.neu.css.order.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class ProductOrder {
	@Column(name="OFFER_ID")
	private String offerId;
	@Column(name="CREATION_DATE")
	private Date creationDate;
	@Column(name="PROD_NAME")
	private String prodName;
	@Column(name="PRICE")
	private Integer price;
	@Column(name="PROD_DESC")
	private String prodDesc;
	
	
	public String getProdName() {
		return prodName;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public String getOfferId() {
		return offerId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public Integer getPrice() {
		return price;
	}
	
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
}
