/**
 * 
 */
package com.neu.css.payment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.css.login.controller.ImplLoginController;
import com.neu.css.login.model.ImplLoginUserBean;
import com.neu.css.payment.model.ImplBillingAddress;
import com.neu.css.payment.model.ImplBillingAddressBean;
import com.neu.css.payment.model.ImplPaymentBean;
import com.neu.css.payment.model.ImplPaymentMode;
import com.neu.css.payment.service.PaymentService;

@Controller
public class ImplPaymentController {
	private static final Logger logger = LoggerFactory.getLogger(ImplLoginController.class);
	
	@Autowired
	@Qualifier("implPaymentModeValidator")
	private Validator validator;
	
	@Autowired  
	private PaymentService paymentService;
	/*
	 * This is to initialize webDataBinder,set its
	 * validator as we specify.
	 */
	@InitBinder
	private void initBinder (WebDataBinder binder){
		binder.setValidator(validator);
	}
	/*
	 * Process From request
	 */
	@RequestMapping(value="/PayYourBill" ,method=RequestMethod.POST)
	public String payYourBill(Locale locale,Model model){
		ImplPaymentBean implPaymentBean =  new ImplPaymentBean();
		model.addAttribute("implPaymentBean",implPaymentBean);		
		return "ImplPayment";
	}
	
	@RequestMapping(value="/StorePayment" ,method=RequestMethod.POST)
	public String payBill(Locale locale,Model model, @Validated ImplPaymentBean implPaymentBean, BindingResult result,HttpServletRequest request){
		model.addAttribute("implPaymentBean",implPaymentBean);
		String returnVal = "forward:/OrderSummary";
		if (result.hasErrors()){
			return "ImplPayment";
		} else{
			try {				
				ImplPaymentMode paymentMode = paymentService.addPaymentMode(preparePaymentModel(implPaymentBean,request));
				ImplPaymentBean  paymentBean = preparePaymentBean(paymentMode);
				request.getSession().setAttribute("paymentInfoSession", paymentBean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return returnVal;
	}
	/**
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getPayment" ,method=RequestMethod.POST)
	public String loginForm(Locale locale, Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		ImplLoginUserBean userBean = (ImplLoginUserBean)session.getAttribute("usersession");
		int userId = userBean.getUserId(); 
		String returnVal = "ImplOrderSummary";
		try {				
			List<ImplPaymentMode> paymentList = (List<ImplPaymentMode>)paymentService.getPaymentList(userId);
			List<ImplPaymentBean> implPaymentBeanList = preparePaymentBeanList(paymentList);
			model.addAttribute("paymentInfoList",implPaymentBeanList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnVal;
	} 
	
	/**
	 * Prepare ImplPaymentMode from ImplPaymentBean
	 */
	private ImplPaymentMode preparePaymentModel(ImplPaymentBean implPaymentBean, HttpServletRequest request){  
		ImplPaymentMode implPaymentMode = new ImplPaymentMode();  
		implPaymentMode.setAccountHolderName(implPaymentBean.getAccountHolderName());
		implPaymentMode.setCardNumber(implPaymentBean.getCardNumber());
		implPaymentMode.setCardType(implPaymentBean.getCardType());
		implPaymentMode.setExpiryMonthYear(implPaymentBean.getExpiryMonthYear());
		implPaymentMode.setSecurityCode(implPaymentBean.getSecurityCode());
		// get the user ID from the session
		HttpSession session = request.getSession();
		ImplLoginUserBean userBean = (ImplLoginUserBean)session.getAttribute("usersession");
		int userId = userBean.getUserId();
		implPaymentMode.setUserID(userId);
		ImplBillingAddress billingAddress = new ImplBillingAddress();
		billingAddress.setBillingAddress1(implPaymentBean.getImplBillingAddressBean().getBillingAddress1());
		billingAddress.setBillingAddress2(implPaymentBean.getImplBillingAddressBean().getBillingAddress2());
		billingAddress.setCity(implPaymentBean.getImplBillingAddressBean().getCity());
		billingAddress.setCountry(implPaymentBean.getImplBillingAddressBean().getCountry());
		billingAddress.setPincode(implPaymentBean.getImplBillingAddressBean().getPincode());
		billingAddress.setState(implPaymentBean.getImplBillingAddressBean().getState());
		implPaymentMode.setImplBillingAddress(billingAddress);
		return implPaymentMode;  
	}  
	
	/**
	 * Prepare ImplPaymentBean from ImplPaymentMode
	 */
	private ImplPaymentBean preparePaymentBean(ImplPaymentMode implPaymentMode){  
		ImplPaymentBean implPaymentBean = new ImplPaymentBean(); 
		implPaymentBean.setPaymentId(implPaymentMode.getPaymentId());
		implPaymentBean.setAccountHolderName(implPaymentMode.getAccountHolderName());
		implPaymentBean.setCardNumber(implPaymentMode.getCardNumber());
		implPaymentBean.setCardType(implPaymentMode.getCardType());
		implPaymentBean.setExpiryMonthYear(implPaymentMode.getExpiryMonthYear());
		implPaymentBean.setSecurityCode(implPaymentMode.getSecurityCode());
		// get the user ID from the session
		ImplBillingAddressBean billingAddress = new ImplBillingAddressBean();
		ImplBillingAddress address =  implPaymentMode.getImplBillingAddress();
		billingAddress.setBillingAddressID(address.getBillingAddressID());
		billingAddress.setBillingAddress1(address.getBillingAddress1());
		billingAddress.setBillingAddress2(address.getBillingAddress2());
		billingAddress.setCity(address.getCity());
		billingAddress.setCountry(address.getCountry());
		billingAddress.setPincode(address.getPincode());
		billingAddress.setState(address.getState());
		implPaymentBean.setImplBillingAddressBean(billingAddress);
		return implPaymentBean;  
	}
	
	/**
	 * Prepare ArrayList of ImplPaymentBean from ArrayList of ImplPaymentMode
	 */
	private List<ImplPaymentBean> preparePaymentBeanList(List<ImplPaymentMode> paymentInfoList){
		List<ImplPaymentBean> paymentBeanList = new ArrayList<ImplPaymentBean>();
		for(ImplPaymentMode paymentMode : paymentInfoList){
			paymentBeanList.add(preparePaymentBean(paymentMode));
		}
		return paymentBeanList;  
	}
}
