/**
 * 
 */
package com.neu.css.order.dao;

import com.neu.css.order.model.Order;


public interface OrderDAO {
	public Order createOrder(Order order); 
	public Order updateOrder(Order order,int orderId);
	public void deleteOrder(int orderId);

}
