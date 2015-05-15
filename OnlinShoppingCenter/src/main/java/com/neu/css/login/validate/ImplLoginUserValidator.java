/**
 * 
 */
package com.neu.css.login.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.css.login.model.ImplLoginUserBean;

public class ImplLoginUserValidator implements Validator{
	
	private Pattern pattern;  
	private Matcher matcher;  
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	String ID_PATTERN = "[0-9]+";  
	String STRING_PATTERN = "[a-zA-Z\\s']+";  
	String MOBILE_PATTERN = "[0-9]{10}";  

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return ImplLoginUserBean.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		// add the validation for the Login User Object	
		ImplLoginUserBean implLoginUserBean = (ImplLoginUserBean)target;
		if("loginType".equals(implLoginUserBean.getActionType())){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","required.email", "Email is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","required.password", "Password is required.");
			
			// email validation in spring  
			  if (!(implLoginUserBean.getEmail() != null && implLoginUserBean.getEmail().isEmpty())) {  
			   pattern = Pattern.compile(EMAIL_PATTERN);  
			   matcher = pattern.matcher(implLoginUserBean.getEmail());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("email", "email.incorrect","Enter a correct email");  
			   }  
			  }    
			
		} else if("registerType".equals(implLoginUserBean.getActionType())){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","required.username", "Name is required.");
			// input string conatains numeric values only  
			  if (!(implLoginUserBean.getUsername() != null && implLoginUserBean.getUsername().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(implLoginUserBean.getUsername().toString());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("username", "username.incorrect", "Enter alphabets only");  
			   }  
			  }
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","required.email", "Email is required.");
			// email validation in spring  
			  if (!(implLoginUserBean.getEmail() != null && implLoginUserBean.getEmail().isEmpty())) {  
			   pattern = Pattern.compile(EMAIL_PATTERN);  
			   matcher = pattern.matcher(implLoginUserBean.getEmail());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("email", "email.incorrect","Enter a correct email");  
			   }  
			  }   
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","required.password", "Password is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","required.confirmPassword", "Confirm Password is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber","required.contactNumber", "Contact Number is required.");
			// phone number validation  
			  if (!(implLoginUserBean.getContactNumber() != null && implLoginUserBean.getContactNumber().isEmpty())) {  
			   pattern = Pattern.compile(MOBILE_PATTERN);  
			   matcher = pattern.matcher(implLoginUserBean.getContactNumber());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("contactNumber", "contactNumber.incorrect","Enter a correct contact number");  
			   }  
			  }  
			// check if password and confirm password are same
			if(!(implLoginUserBean.getPassword().equals(implLoginUserBean.getConfirmPassword()))){
				errors.rejectValue("confirmPassword", "confirmPassword.incorrect", "Confirm Password did not match");
			}
		} else if("emailType".equals(implLoginUserBean.getActionType())){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","required.email", "Email is required.");
			if (!(implLoginUserBean.getEmail() != null && implLoginUserBean.getEmail().isEmpty())) {  
				   pattern = Pattern.compile(EMAIL_PATTERN);  
				   matcher = pattern.matcher(implLoginUserBean.getEmail());  
				   if (!matcher.matches()) {  
				    errors.rejectValue("email", "email.incorrect","Enter a correct email");  
				   }  
				  }  
		}		
	}
	
}
