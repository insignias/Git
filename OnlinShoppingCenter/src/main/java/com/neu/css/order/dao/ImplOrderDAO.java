/**
 * 
 */
package com.neu.css.order.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neu.css.order.model.Order;


@Repository("orderDAO")
public class ImplOrderDAO implements OrderDAO{
	
	@Autowired  
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.neu.css.order.dao.OrderDAO#createOrder(com.neu.css.order.model.Order)
	 */
	@Override
	public Order createOrder(Order order) {
		Session session = null;
		session  = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(order);
		tx.commit();
		return order;
	}

	/* (non-Javadoc)
	 * @see com.neu.css.order.dao.OrderDAO#updateOrder(com.neu.css.order.model.Order, int)
	 */
	@Override
	public Order updateOrder(Order order, int orderId) {
		sessionFactory.getCurrentSession().update(order);
		return order;
	}

	/* (non-Javadoc)
	 * @see com.neu.css.order.dao.OrderDAO#deleteOrder(int)
	 */
	@Override
	public void deleteOrder(int orderId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Order WHERE orderId = " + orderId).executeUpdate();
	}

}
