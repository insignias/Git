/**
 * 
 */
package com.neu.css.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.neu.css.order.dao.OrderDAO;
import com.neu.css.order.model.Order;


@Service("orderService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ImplOrderService implements OrderService{
	@Autowired  
	private OrderDAO orderDAO;

	/* (non-Javadoc)
	 * @see com.neu.css.order.service.OrderService#createOrder(com.neu.css.order.model.Order)
	 */
	@Override
	public Order createOrder(Order order) {
		return orderDAO.createOrder(order);
	}

	/* (non-Javadoc)
	 * @see com.neu.css.order.service.OrderService#updateOrder(com.neu.css.order.model.Order, int)
	 */
	@Override
	public Order updateOrder(Order order, int orderId) {
		return orderDAO.updateOrder(order, orderId);
	}

	/* (non-Javadoc)
	 * @see com.neu.css.order.service.OrderService#deleteOrder(int)
	 */
	@Override
	public void deleteOrder(int orderId) {
		orderDAO.deleteOrder(orderId);
	}
}
