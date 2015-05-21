/**
 * 
 */
package com.neu.css.ordersummary.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.css.login.controller.ImplLoginController;
import com.neu.css.login.model.ImplLoginUserBean;
import com.neu.css.order.model.OrderBean;
import com.neu.css.ordersummary.model.ImplOrderSummaryBean;
import com.neu.css.payment.model.ImplPaymentBean;


@Controller
public class ImplOrderSummaryController {
	private static final Logger logger = LoggerFactory.getLogger(ImplLoginController.class);
	/*
	 * Process From request
	 */
	@RequestMapping(value="/OrderSummary" ,method=RequestMethod.POST)
	public String payYourBill(Locale locale,Model model,HttpServletRequest request){
		ImplOrderSummaryBean orderSummaryBean =  storeOrderSummaryInfo(request);
		// get the full data from the session and store it in order summary object to display it on screen 
		HttpSession session = request.getSession();
		session.setAttribute("orderSummarySession", orderSummaryBean);
		model.addAttribute("orderSummaryInfo",orderSummaryBean);		
		return "ImplOrderSummary";
	}
	/**
	 * store the order summary bean object 
	 * @param request
	 * @return
	 */
	private ImplOrderSummaryBean storeOrderSummaryInfo(HttpServletRequest request){
		ImplOrderSummaryBean orderSummaryBean =  new ImplOrderSummaryBean();
		HttpSession session = request.getSession();
		// get the login user from the session and set it in the order summary info
		ImplLoginUserBean loginUserBean =  (ImplLoginUserBean)session.getAttribute("usersession");
		orderSummaryBean.setLoginUserBean(loginUserBean);
		// set the payment bean in the ordersummary bean
		ImplPaymentBean paymentBean = (ImplPaymentBean)session.getAttribute("paymentInfoSession");
		orderSummaryBean.setImplPaymentBean(paymentBean);
		orderSummaryBean.setBillingAddressBean(paymentBean.getImplBillingAddressBean());
		// set the order bean in the order summary bean 
		OrderBean orderBean = (OrderBean)session.getAttribute("orderInfoSession");
		orderSummaryBean.setOrderBean(orderBean);		
		return orderSummaryBean;
	}
}
