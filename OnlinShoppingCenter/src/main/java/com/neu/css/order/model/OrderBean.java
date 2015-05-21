/**
 * 
 */
package com.neu.css.order.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OrderBean {
	private Integer orderId;
	private Integer userId;
	private String orderDescription;
	private Date creationDate;
	private String status;
	private Integer totalPrice;
	private List<ProductOrder> productIDList =  new ArrayList<ProductOrder>();
	public Integer getOrderId() {
		return orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public String getStatus() {
		return status;
	}
	public List<ProductOrder> getProductIDList() {
		return productIDList;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setProductIDList(List<ProductOrder> productIDList) {
		this.productIDList = productIDList;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
