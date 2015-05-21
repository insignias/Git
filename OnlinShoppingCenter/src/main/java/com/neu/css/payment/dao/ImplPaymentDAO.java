/**
 * 
 */
package com.neu.css.payment.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neu.css.payment.model.ImplPaymentMode;

@Repository("paymentDAO")
public class ImplPaymentDAO implements PaymentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Get the paymentList based on the userId 
	 */
	@Override
	public List<ImplPaymentMode> getPaymentList(int userId) {
		try {
            Query q = sessionFactory.getCurrentSession().createQuery("from ImplPaymentMode where userID = :userId");
            q.setInteger("userId", userId);
            @SuppressWarnings("unchecked")
			List<ImplPaymentMode> paymentList = q.list();
            return paymentList;
        } catch (HibernateException e) {	         
			e.printStackTrace();
        }
	return null;
	}

	/**
	 * Save the ImplPaymentMode to the database
	 */
	@Override
	public ImplPaymentMode addPaymentMode(ImplPaymentMode implPaymentMode) {
		Session session = null;
		session  = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(implPaymentMode);
		tx.commit();
		return implPaymentMode;
	}

}
