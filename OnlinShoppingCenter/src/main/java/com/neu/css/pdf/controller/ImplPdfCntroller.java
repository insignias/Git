package com.neu.css.pdf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.css.ordersummary.model.ImplOrderSummaryBean;
import com.neu.css.productcatalog.controller.ImplProductServiceController;

@Controller
public class ImplPdfCntroller {
	private static final Logger logger = LoggerFactory.getLogger(ImplProductServiceController.class);
	
	/**
	 * On Generate Bill Summary button click
	 */
	@RequestMapping(value = "/generatePdf", method = RequestMethod.GET)
	public String generatePdf(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ImplOrderSummaryBean orderSummaryBean =  (ImplOrderSummaryBean)session.getAttribute("orderSummarySession");
		model.addAttribute("orderSummaryInfo",orderSummaryBean);
		return "pdfView";
		
	}
	
}
