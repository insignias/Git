/**
 * 
 */
package com.neu.css.productcatalog.model;

import java.io.Serializable;

/**
 * Front end
 *
 */
public class ImplProductBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String productID;
	private String productDescription;
	private String productName;
	private Integer productPrice;
	private String producttTypeID;
	private String productURL;
	public String getProductID() {
		return productID;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public String getProductName() {
		return productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public String getProducttTypeID() {
		return producttTypeID;
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
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public void setProducttTypeID(String producttTypeID) {
		this.producttTypeID = producttTypeID;
	}
	public String getProductURL() {
		return productURL;
	}
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}
	
}
