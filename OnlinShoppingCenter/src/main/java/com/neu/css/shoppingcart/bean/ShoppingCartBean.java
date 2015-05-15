package com.neu.css.shoppingcart.bean;

/**
 * Frontend
 */
public class ShoppingCartBean {
	
	private String productId;
	private String productURL;
	private String productName;
	private String productDescription;
	private Integer productPrice;
	
	
	public String getProductURL() {
		return productURL;
	}
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public Integer getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	

}
