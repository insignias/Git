package com.neu.css.confirmOrder.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.css.ordersummary.controller.ImplSendNotificationMail;
import com.neu.css.ordersummary.model.ImplOrderSummaryBean;

@Controller
public class ImplConfirmOrderController {
	
	/**
	 * On Confirm Order Click send an email to the customer for the order confirmation
	 */
	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public String generatePdf(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ImplOrderSummaryBean orderSummaryBean =  (ImplOrderSummaryBean)session.getAttribute("orderSummarySession");
		try {
			ImplSendNotificationMail.sendWarningMail(orderSummaryBean);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("orderSummaryInfo",orderSummaryBean);
		return "confirmOrder";
		
	}

}
