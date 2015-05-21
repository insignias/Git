/**
 * 
 */
package com.neu.css.payment.dao;

import java.util.List;

import com.neu.css.payment.model.ImplPaymentMode;

public interface PaymentDAO { 
	public List<ImplPaymentMode> getPaymentList(int userId);
	public ImplPaymentMode addPaymentMode(ImplPaymentMode implPaymentMode);
}
