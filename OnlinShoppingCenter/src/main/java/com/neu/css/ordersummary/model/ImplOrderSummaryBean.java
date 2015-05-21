/**
 * 
 */
package com.neu.css.ordersummary.model;

import com.neu.css.login.model.ImplLoginUserBean;
import com.neu.css.order.model.OrderBean;
import com.neu.css.payment.model.ImplBillingAddressBean;
import com.neu.css.payment.model.ImplPaymentBean;

public class ImplOrderSummaryBean {
	private ImplPaymentBean implPaymentBean;
	private ImplBillingAddressBean billingAddressBean;
	private ImplLoginUserBean loginUserBean;
	private OrderBean orderBean;
	public ImplPaymentBean getImplPaymentBean() {
		return implPaymentBean;
	}
	public ImplBillingAddressBean getBillingAddressBean() {
		return billingAddressBean;
	}
	public ImplLoginUserBean getLoginUserBean() {
		return loginUserBean;
	}
	public OrderBean getOrderBean() {
		return orderBean;
	}
	public void setImplPaymentBean(ImplPaymentBean implPaymentBean) {
		this.implPaymentBean = implPaymentBean;
	}
	public void setBillingAddressBean(ImplBillingAddressBean billingAddressBean) {
		this.billingAddressBean = billingAddressBean;
	}
	public void setLoginUserBean(ImplLoginUserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}
}
