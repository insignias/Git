/**
 * 
 */
package com.neu.css.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neu.css.payment.dao.PaymentDAO;
import com.neu.css.payment.model.ImplPaymentMode;

@Service("paymentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ImplPaymentService implements PaymentService{
	
	@Autowired  
	private PaymentDAO paymentDAO;
	/* (non-Javadoc)
	 * @see com.neu.css.payment.service.PaymentService#getPaymentList(int)
	 */
	@Override
	public List<ImplPaymentMode> getPaymentList(int userId) {
		return paymentDAO.getPaymentList(userId);
	}

	/* (non-Javadoc)
	 * @see com.neu.css.payment.service.PaymentService#addPaymentMode(com.neu.css.payment.model.ImplPaymentMode)
	 */
	@Override
	public ImplPaymentMode addPaymentMode(ImplPaymentMode implPaymentMode) {
		return paymentDAO.addPaymentMode(implPaymentMode);
	}

}
