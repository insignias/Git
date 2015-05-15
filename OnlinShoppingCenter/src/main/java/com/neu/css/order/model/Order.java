/**
 * 
 */
package com.neu.css.order.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;



@Entity
@Table(name = "TABLE_ORDER")
public class Order {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "ORDER_ID")
	private Integer orderId;
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "ORDER_DESC")
	private String orderDescription;
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	@Column(name = "ORDER_STATUS")
	private String status;
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="TABLE_ORDER_PRODUCT",joinColumns=@JoinColumn(name="ORDER_ID"))
	private List<ProductOrder> offerList =  new ArrayList<ProductOrder>();
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
	public List<ProductOrder> getOfferList() {
		return offerList;
	}
	public void setOfferList(List<ProductOrder> offerList) {
		this.offerList = offerList;
	}
	
}
