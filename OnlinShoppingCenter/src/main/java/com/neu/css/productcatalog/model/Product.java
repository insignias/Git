/**
 * 
 */
package com.neu.css.productcatalog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Backend
 */
@Entity  
@Table(name="TABLE_PRODUCT")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PRODUCT_ID")
	private String productID;
	@Column(name = "PRODUCT_DESC")
	private String productDescription;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRODUCT_PRICE")
	private Integer productPrice;
	@Column(name = "PRODUCT_TYPE_ID")
	private String productTypeID;
	@Column(name = "PRODUCT_URL")
	private String productURL;
	public String getProductTypeID() {
		return productTypeID;
	}
	public void setProductTypeID(String productTypeID) {
		this.productTypeID = productTypeID;
	}
	public String getProductID() {
		return productID;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductURL() {
		return productURL;
	}
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}

}
