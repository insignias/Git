package com.neu.css.pdf.model;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.neu.css.order.model.ProductOrder;
import com.neu.css.ordersummary.model.ImplOrderSummaryBean;

public class ImplPdfBuilder extends AbstractITextPdfView{
	
	/**
	 * PDF page
	 */
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ImplOrderSummaryBean orderSummaryBean = (ImplOrderSummaryBean)model.get("orderSummaryInfo");
		PdfPTable table1 = new PdfPTable(2);
		table1.setWidthPercentage(100.0f);
        table1.setWidths(new float[] {3.0f, 2.0f});
        table1.setSpacingBefore(10);
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
        
        PdfPCell cell = new PdfPCell();
        
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
        
        cell.setPhrase(new Phrase("Billing Details:", font));
        table1.addCell(cell);
        
        cell.setPhrase(new Phrase("", font));
        table1.addCell(cell);
        
		table1.addCell("Payment Id:");
		table1.addCell(String.valueOf((orderSummaryBean.getImplPaymentBean().getPaymentId())));
		table1.addCell("Account Holder Name:");
		table1.addCell(orderSummaryBean.getImplPaymentBean().getAccountHolderName());
		table1.addCell("Card Type:");
		table1.addCell(orderSummaryBean.getImplPaymentBean().getCardType());
		table1.addCell("Card Number:");
		table1.addCell(orderSummaryBean.getImplPaymentBean().getCardNumber());
		table1.addCell("Expiration Date(YYYY-MM):");
		table1.addCell(orderSummaryBean.getImplPaymentBean().getExpiryMonthYear());
		PdfPTable table2 = new PdfPTable(2);
		table2.setWidthPercentage(100.0f);
        table2.setWidths(new float[] {3.0f, 2.0f});
        table2.setSpacingBefore(10);
        
        cell.setPhrase(new Phrase("Shipping Address Details:", font));
        table2.addCell(cell);
        
        cell.setPhrase(new Phrase("", font));
        table2.addCell(cell);
        table2.addCell("Address ID:");
		table2.addCell(String.valueOf(orderSummaryBean.getBillingAddressBean().getBillingAddressID()));
		table2.addCell("Street Address:");
		table2.addCell(orderSummaryBean.getBillingAddressBean().getBillingAddress1()+","+orderSummaryBean.getBillingAddressBean().getBillingAddress2());
		table2.addCell("Pin Code:");
		table2.addCell(orderSummaryBean.getBillingAddressBean().getPincode());
		table2.addCell("City:");
		table2.addCell(orderSummaryBean.getBillingAddressBean().getCity());
		table2.addCell("State");
		table2.addCell(orderSummaryBean.getBillingAddressBean().getState());
		table2.addCell("Country");
		table2.addCell(orderSummaryBean.getBillingAddressBean().getCountry());
		
		PdfPTable table3 = new PdfPTable(2);
		table3.setWidthPercentage(100.0f);
        table3.setWidths(new float[] {3.0f, 2.0f});
        table3.setSpacingBefore(10);
        cell.setPhrase(new Phrase("Order Details:", font));
        table3.addCell(cell);
        
        cell.setPhrase(new Phrase("", font));
        table3.addCell(cell);
        
		for(ProductOrder po : orderSummaryBean.getOrderBean().getProductIDList()){
			table3.addCell("Product ID:");
			table3.addCell(po.getOfferId());
			table3.addCell("Product Name:");
			table3.addCell(po.getProdName());
			table3.addCell("Product Description:");
			table3.addCell(po.getProdDesc());
			table3.addCell("Product Price:");
			table3.addCell(String.valueOf(po.getPrice()));
		}
		
		PdfPTable table4 = new PdfPTable(2);
		table4.setWidthPercentage(100.0f);
        table4.setWidths(new float[] {3.0f, 2.0f});
        table4.setSpacingBefore(10);
		table4.addCell("Creation Date:");
		table4.addCell(String.valueOf(orderSummaryBean.getOrderBean().getCreationDate()));
		table4.addCell("Order Status:");
		table4.addCell(orderSummaryBean.getOrderBean().getStatus());
		table4.addCell("Total Price:");
		table4.addCell(String.valueOf(orderSummaryBean.getOrderBean().getTotalPrice()));
		
		
		
		doc.open();
		doc.add(new Paragraph("Order Summary:"));
		doc.add(new Paragraph(""));
		doc.add(table1);
		doc.add(table2);
		doc.add(table3);
		doc.add(table4);
        doc.close();
        
		
	}

}
