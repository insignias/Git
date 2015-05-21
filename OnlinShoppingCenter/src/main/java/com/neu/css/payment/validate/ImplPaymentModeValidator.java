/**
 * 
 */
package com.neu.css.payment.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.css.payment.model.ImplPaymentBean;

public class ImplPaymentModeValidator implements Validator{
	
	private Pattern pattern;  
	private Matcher matcher;  
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	String ID_PATTERN = "[0-9]+";  
	String STRING_PATTERN = "[a-zA-Z\\s']+"; 
	String MOBILE_PATTERN = "[0-9]{10}";
	String MONTH_PATTERN = "[0-9]{2}";
	String YEAR_PATTERN = "[0-9]{4}";
	String CARD_PATTERN = "[0-9]{16}";
	String SECURITY_PATTERN = "[0-9]{3}";

	
	@Override
	public boolean supports(Class<?> clazz) {
		return ImplPaymentBean.class.isAssignableFrom(clazz);
	}

	/**
	 * validation of the ImplPaymentBean properties
	 */
	@Override
	public void validate(Object target, Errors errors) {
		// add the validation for the Login User Object	
		ImplPaymentBean implPaymentBean = (ImplPaymentBean)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountHolderName","required.accountHolderName", "Account Holder Name is required.");
			if (!(implPaymentBean.getAccountHolderName() != null && implPaymentBean.getAccountHolderName().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(implPaymentBean.getAccountHolderName().toString());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("accountHolderName", "accountHolderName.incorrect", "Enter alphabets only");  
			   }  
			  }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardNumber","required.cardNumber", "Card Number is required.");
			if (!(implPaymentBean.getCardNumber() != null && implPaymentBean.getCardNumber().isEmpty())) {  
			   pattern = Pattern.compile(CARD_PATTERN);  
			   matcher = pattern.matcher(implPaymentBean.getCardNumber().toString());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("cardNumber", "cardNumber.incorrect", "Enter correct 16 digit card number");  
			   }  
			  }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "securityCode","required.securityCode", "Security Code is required.");
			if (!(implPaymentBean.getSecurityCode() != null && implPaymentBean.getSecurityCode().isEmpty())) {  
			   pattern = Pattern.compile(SECURITY_PATTERN);  
			   matcher = pattern.matcher(implPaymentBean.getSecurityCode().toString());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("securityCode", "securityCode.incorrect", "Enter correct 3 digit security code");  
			   }  
			  }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expiryMonthYear","required.expiryMonthYear", "Expiry Month and Year is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "implBillingAddressBean.billingAddress1","required.implBillingAddressBean.billingAddress1", "Address1 is required.");
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "implBillingAddressBean.city","required.implBillingAddressBean.city", "City is required.");
			if (!(implPaymentBean.getImplBillingAddressBean().getCity() != null && implPaymentBean.getImplBillingAddressBean().getCity().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(implPaymentBean.getImplBillingAddressBean().getCity().toString());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("implBillingAddressBean.city", "implBillingAddressBean.city.incorrect", "Enter alphabets only");  
			   }  
			  }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "implBillingAddressBean.state","required.implBillingAddressBean.state", "State is required.");
			if (!(implPaymentBean.getImplBillingAddressBean().getState() != null && implPaymentBean.getImplBillingAddressBean().getState().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(implPaymentBean.getImplBillingAddressBean().getState().toString());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("implBillingAddressBean.state", "implBillingAddressBean.state.incorrect", "Enter alphabets only");  
			   }  
			  }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "implBillingAddressBean.country","required.implBillingAddressBean.country", "Country is required.");
			if (!(implPaymentBean.getImplBillingAddressBean().getState() != null && implPaymentBean.getImplBillingAddressBean().getState().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(implPaymentBean.getImplBillingAddressBean().getState().toString());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("implBillingAddressBean.country", "implBillingAddressBean.country.incorrect", "Enter aphabets only");  
			   }  
			  }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "implBillingAddressBean.pincode","required.implBillingAddressBean.pincode", "Pincode is required.");
			if (!(implPaymentBean.getImplBillingAddressBean().getPincode() != null && implPaymentBean.getImplBillingAddressBean().getPincode().isEmpty())) {  
			   pattern = Pattern.compile(ID_PATTERN);  
			   matcher = pattern.matcher(implPaymentBean.getImplBillingAddressBean().getPincode().toString());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("implBillingAddressBean.pincode", "implBillingAddressBean.pincode.incorrect", "Enter digits only");  
			   }  
			  }
	}

}
