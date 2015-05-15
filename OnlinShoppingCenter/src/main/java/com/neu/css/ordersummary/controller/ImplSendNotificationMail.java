/**
 * 
 */
package com.neu.css.ordersummary.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.neu.css.login.model.ImplLoginUserBean;
import com.neu.css.ordersummary.model.ImplOrderSummaryBean;


public final class ImplSendNotificationMail {
	
	public static void sendWarningMail(ImplOrderSummaryBean implOrderSummaryBean) throws javax.mail.MessagingException{
        // Recipient's email ID needs to be mentioned.
		
        String to = implOrderSummaryBean.getLoginUserBean().getEmail();
        // Sender's email ID needs to be mentioned
        final String from = "sharan.samir@gmail.com";
        final String password = "insig0207";
        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";
        String smtpPort = "587";
        Properties properties = System.getProperties();
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", smtpPort);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true"); 
        // Authentication
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties, auth);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addHeader("Content-type", "text/HTML; charset=UTF-8");
        message.addHeader("format", "flowed");
        message.addHeader("Content-Transfer-Encoding", "8bit");
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
        message.setSubject("ONLINE SHOPPING CENTER: ORDER CONFIRMATION NUMBER: " + implOrderSummaryBean.getOrderBean().getOrderId());        
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("Thank you for ordering from Boston Online");
        htmlBuilder.append("\n");
        htmlBuilder.append("Order ID: " + implOrderSummaryBean.getOrderBean().getOrderId());
        htmlBuilder.append("\n");
        htmlBuilder.append("Total Price: " + implOrderSummaryBean.getOrderBean().getTotalPrice());
        htmlBuilder.append("\n");
        htmlBuilder.append("Expected Delivery Date: " + implOrderSummaryBean.getOrderBean().getCreationDate());
        htmlBuilder.append("\n");
        htmlBuilder.append("MODE OF PAYMENT: " + implOrderSummaryBean.getImplPaymentBean().getCardType());
        htmlBuilder.append("\n");
        htmlBuilder.append("USER Id: " + implOrderSummaryBean.getLoginUserBean().getUserId());
        htmlBuilder.append("\n");
        htmlBuilder.append("CONTACT NUMBER: " + implOrderSummaryBean.getLoginUserBean().getContactNumber());
        htmlBuilder.append("\n");
        String html = htmlBuilder.toString();
        message.setText(html);
        message.setSentDate(new Date());
        Transport.send(message);        
        System.out.println("Sent message successfully...."); 
    }  
	
	public static void sendLoginDetails(ImplLoginUserBean loginUserBean) throws javax.mail.MessagingException{
		// Recipient's email ID needs to be mentioned.
		
        String to = loginUserBean.getEmail();
        // Sender's email ID needs to be mentioned
        final String from = "sharan.samir@gmail.com";
        final String password = "insig0207";
        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";
        String smtpPort = "587";
        Properties properties = System.getProperties();
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", smtpPort);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true"); 
        // Authentication
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties, auth);
        MimeMessage message = new MimeMessage(session);
        // Create the message part 
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        // Fill the message
        message.setFrom(new InternetAddress(from));
        message.addHeader("Content-type", "text/HTML; charset=UTF-8");
        message.addHeader("format", "flowed");
        message.addHeader("Content-Transfer-Encoding", "8bit");
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
        message.setSubject("ONLINE SHOPPING CENTER: LOGIN DEATILS: " + loginUserBean.getUserId());        
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("Your login details are:");
        htmlBuilder.append("\n");
        htmlBuilder.append("LOGIN USER ID: " + loginUserBean.getUserId());
        htmlBuilder.append("\n");
        htmlBuilder.append("EMAIL : " + loginUserBean.getEmail());
        htmlBuilder.append("\n");
        htmlBuilder.append("USERNAME: " + loginUserBean.getUsername());
        htmlBuilder.append("\n");
        htmlBuilder.append("PASSWORD: " + loginUserBean.getPassword());
        htmlBuilder.append("\n");
        htmlBuilder.append("CONTACT NUMBER: " + loginUserBean.getContactNumber());
        htmlBuilder.append("\n");
        htmlBuilder.append("<a href=\"http://localhost:8080/css/\">Click here to login</a>");
        htmlBuilder.append("\n");
        String messageBody = htmlBuilder.toString();
        messageBodyPart.setText(messageBody,"UTF-8","html");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        // Put parts in message
        message.setContent(multipart);
        message.setSentDate(new Date());
        Transport.send(message);        
        System.out.println("Sent message successfully...."); 
	}

}
