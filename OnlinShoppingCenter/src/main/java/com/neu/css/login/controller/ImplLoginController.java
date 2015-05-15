package com.neu.css.login.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.css.login.model.ImplLoginRole;
import com.neu.css.login.model.ImplLoginUser;
import com.neu.css.login.model.ImplLoginUserBean;
import com.neu.css.login.service.LoginUserService;
import com.neu.css.ordersummary.controller.ImplSendNotificationMail;



/**
 * Handles requests for the application home page.
 */

@Controller
public class ImplLoginController{
	
	private static final Logger logger = LoggerFactory.getLogger(ImplLoginController.class);
	
	@Autowired
	@Qualifier("implLoginUserValidator")
	private Validator validator;
	
	@Autowired  
	private LoginUserService loginUserService;
	/*
	 * This is to initialize webDataBinder,set its
	 * validator as we specify.
	 */
	@InitBinder
	private void initBinder (WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/logout" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		HttpSession session = request.getSession();
		session.invalidate();
		ImplLoginUserBean implLoginUserBean = new ImplLoginUserBean();
		model.addAttribute("implLoginUserBean", implLoginUserBean);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
		return "ImplLogin";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model) {
		   return "forward:/login";
	}
	
	/**
	 * On error on login page redirect to the error page
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String generalError(Locale locale, Model model) {
		   return "GeneralError";
	}
	
	/*
	 * Process From request
	 */
	@RequestMapping(value="/login" ,method=RequestMethod.GET)
	public String loginForm(Locale locale,Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		String returnVal =  "forward:/loadProductCatalog";
		session.setAttribute("loginUserName", "Anonmyous");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object userPrincipal = authentication.getPrincipal();
		if (userPrincipal instanceof User){
			String name = ((User)userPrincipal).getUsername();
			try {
				ImplLoginUser implLoginUser = loginUserService.getLoginUser(name);
				if (implLoginUser != null){
					ImplLoginUserBean bean = prepareLoginUserBean(implLoginUser);
					session.setAttribute("usersession", bean);
					session.setAttribute("loginUserName", bean.getUsername());
					model.addAttribute("loginUser", bean);
					return returnVal;		
				} else {
					returnVal =  "forward:/error";
				}
			} catch (Exception e) {
				returnVal =  "forward:/error";
				e.printStackTrace();
			}
		} else {
			returnVal =  "forward:/error";
		}
		return returnVal;
	} 
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() { 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;
	}
	
	/**
	 * 
	 * On Registration form submit
	 */
	@RequestMapping(value="/register" ,method=RequestMethod.POST)
	public String registerForm(Locale locale,Model model, @Validated ImplLoginUserBean implLoginUserBean, BindingResult result, HttpServletRequest request){
		logger.info("Welcome home! The client register " + implLoginUserBean.getActionType(), locale);		
		model.addAttribute("implLoginUserBean",implLoginUserBean);
		String returnVal = "confirmRegistration";
		if (result.hasErrors()){
			model.addAttribute("forgot","Please enter correct details for registration");
			return "RegistrationError";
		} else{
			try {
				loginUserService.addLoginUser(prepareLoginUserModel(implLoginUserBean));
				request.getSession().setAttribute("usersession", implLoginUserBean);
				return returnVal;
			} catch (Exception e) {
				model.addAttribute("forgot","An email has already been registered. Please click forgot password on login page");
				returnVal = "RegistrationError";
				e.printStackTrace();
			}
		}		
		return returnVal;
	}
	
	/**
	 * On Forgot Password submit 
	 */
	@RequestMapping(value="/email" ,method=RequestMethod.POST)
	public String sendEmailForm(Locale locale,Model model, @Validated ImplLoginUserBean implLoginUserBean, BindingResult result){
		logger.info("Welcome home! The client save " + implLoginUserBean.getActionType(), locale);	
		model.addAttribute("implLoginUserBean",implLoginUserBean);
		String returnVal = "EmailError";
		if (result.hasErrors()){
			model.addAttribute("emailMessage","An error has occured , while sending an email to this address " + implLoginUserBean.getEmail());
			return returnVal;
		} else{
			try {
				ImplLoginUser implLoginUser = loginUserService.getLoginUser(implLoginUserBean.getEmail());
				if (implLoginUser != null){
					// send an email to user
					ImplLoginUserBean loginUserBean = prepareLoginUserBean(implLoginUser);
					ImplSendNotificationMail.sendLoginDetails(loginUserBean);
					model.addAttribute("emailMessage","An email has been send to this address " + implLoginUserBean.getEmail());
					return "reminder";		
				}
			} catch (Exception e) {
				model.addAttribute("emailMessage","An error has occured , while sending an email to this address " + implLoginUserBean.getEmail());
				e.printStackTrace();
			}
		}		
		return returnVal;
	}
	
	/**
	 * Prepare ImplLoginUser from ImplLoginUserBean
	 */
	private ImplLoginUser prepareLoginUserModel(ImplLoginUserBean implLoginUserBean){  
		ImplLoginUser implLoginUser = new ImplLoginUser();    
		implLoginUser.setUsername(implLoginUserBean.getUsername());
		implLoginUser.setPassword(implLoginUserBean.getPassword());
		implLoginUser.setEmail(implLoginUserBean.getEmail());
		implLoginUser.setContactNumber(implLoginUserBean.getContactNumber());
		implLoginUser.setEnabled(1);
		ImplLoginRole loginRole =  new ImplLoginRole();
		loginRole.setRoleId("CUSTOMER");
		loginRole.setRoleType("CUSTOMER");
		loginRole.setEmail(implLoginUserBean.getEmail());
		implLoginUser.getRole().add(loginRole);
		implLoginUserBean.setUserId(null);  
		return implLoginUser;  
	}  
	
	/**
	 * Prepare ImplLoginUserBean from ImplLoginUser
	 */
	private ImplLoginUserBean prepareLoginUserBean(ImplLoginUser implLoginUser){  
		ImplLoginUserBean implLoginUserBean = new ImplLoginUserBean();  
		implLoginUserBean.setUserId(implLoginUser.getUserId());  
		implLoginUserBean.setUsername(implLoginUser.getUsername());
		implLoginUserBean.setPassword(implLoginUser.getPassword());
		implLoginUserBean.setConfirmPassword(implLoginUser.getPassword());
		implLoginUserBean.setEmail(implLoginUser.getEmail());
		implLoginUserBean.setContactNumber(implLoginUser.getContactNumber());
		implLoginUserBean.setEnabled(implLoginUser.getEnabled());
		return implLoginUserBean;  
	}
	
	
}
