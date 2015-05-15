/**
 * 
 */
package com.neu.css.payment.service;

import java.util.List;

import com.neu.css.payment.model.ImplPaymentMode;

public interface PaymentService {
	public List<ImplPaymentMode> getPaymentList(int userId);
	public ImplPaymentMode addPaymentMode(ImplPaymentMode implPaymentMode);
}
