/**
 * 
 */
package com.neu.css.order.service;

import com.neu.css.order.model.Order;


public interface OrderService {
	public Order createOrder(Order order); 
	public Order updateOrder(Order order,int orderId);
	public void deleteOrder(int orderId);
}
