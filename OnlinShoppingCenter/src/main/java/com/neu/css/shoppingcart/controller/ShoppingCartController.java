package com.neu.css.shoppingcart.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.css.login.model.ImplLoginUserBean;
import com.neu.css.order.model.Order;
import com.neu.css.order.model.OrderBean;
import com.neu.css.order.model.ProductOrder;
import com.neu.css.order.service.OrderService;
import com.neu.css.shoppingcart.bean.ShoppingCartBean;
import com.neu.css.shoppingcart.bean.ShoppingCartCatalogBean;

@Controller
public class ShoppingCartController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	@Autowired  
	private ShoppingCartCatalogBean shoppingCartCatalogBean;	
	@Autowired
	private ShoppingCartBean shoppingCartBean;
	@Autowired  
	private OrderService orderService;
	
	@RequestMapping(value = "/loadProductCatalog", method = RequestMethod.GET)
    public String loadProductCataLog(Model model) {
		ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
		model.addAttribute("shoppingCart", shoppingCartBean);
        return "ProductCatalogBrowsing";	
	}
	
	@RequestMapping(value = "/addToCart", method = RequestMethod.GET)
    public String addToCart(Model model, ShoppingCartBean shoppingCartBean, HttpServletRequest request) {
		model.addAttribute("shoppingCart", shoppingCartBean);
		HttpSession session = request.getSession();
		//check if product is alreday present in the cart 
		// then don't add
		String productName = shoppingCartBean.getProductName(); 
		if(shoppingCartBean.getProductName() != null && !shoppingCartCatalogBean.isAlreadyAdded(productName)){
			shoppingCartCatalogBean.addShoppingCartBean(shoppingCartBean);
		}
		shoppingCartCatalogBean.shoppingCartTotal();
		
		session.setAttribute("cartBean", shoppingCartCatalogBean);
		model.addAttribute("scb", shoppingCartCatalogBean);
        return "ProductCatalogBrowsing";	
	}
		
	
	@RequestMapping(value = "/RemoveCart", method = RequestMethod.POST)
    public String deleteCart(Model model, ShoppingCartBean shoppingCartBean, HttpServletRequest request) {
		model.addAttribute("shoppingCart", shoppingCartBean);
		shoppingCartCatalogBean.deleteFromShoppingCartBean(shoppingCartBean.getProductName());
		shoppingCartCatalogBean.shoppingCartTotal();
		HttpSession session = request.getSession();
		session.removeAttribute("cartBean");
		session.setAttribute("cartBean", shoppingCartCatalogBean);
		model.addAttribute("scb", shoppingCartCatalogBean);	
        return "ProductCatalogBrowsing";
		
	}
	
	@RequestMapping(value = "/RemoveShoppingCart", method = RequestMethod.POST)
    public String deleteShoppingCart(Model model, ShoppingCartBean shoppingCartBean, HttpServletRequest request) {
		model.addAttribute("shoppingCart", shoppingCartBean);
		shoppingCartCatalogBean.deleteFromShoppingCartBean(shoppingCartBean.getProductName());
		shoppingCartCatalogBean.shoppingCartTotal();
		HttpSession session = request.getSession();
		session.removeAttribute("cartBean");
		session.setAttribute("cartBean", shoppingCartCatalogBean);
		model.addAttribute("sc", shoppingCartCatalogBean);	
        return "ProductDescription";
		
	}
	
	@RequestMapping(value = "/ProductDescription", method = RequestMethod.GET)
    public String cart(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("shoppingCart", shoppingCartBean);
		ShoppingCartCatalogBean shoppingCartCatalogBean = (ShoppingCartCatalogBean)session.getAttribute("cartBean");
		model.addAttribute("sc", shoppingCartCatalogBean);
        return "ProductDescription";
	}
	
	@RequestMapping(value = "/Checkout", method = RequestMethod.POST)
    public String checkout(Model model, HttpServletRequest request) {
		String price = request.getParameter("TotalPrice");
		if(price != null){
		String returnVal =  "forward:/PayYourBill";
		Order order = prepareOrderTable(request);
		try {
			Order order1 = orderService.createOrder(order);	
			if (order1.getOrderId() != null){
				OrderBean orderBean =  prepareOrderBean(order1);
				request.getSession().setAttribute("orderInfoSession", orderBean);
				return returnVal;		
			}
		} catch(HibernateException hibernateException){
			hibernateException.printStackTrace();
		}				
        return "ProductCatalogBrowsing";
		}
		else
		{
		return "ProductDescription";
		}
	}
		
		
		
	private Order prepareOrderTable(HttpServletRequest request){
		HttpSession session = request.getSession();
		ImplLoginUserBean userBean = (ImplLoginUserBean)session.getAttribute("usersession");
		
		int userId = userBean.getUserId();
		ShoppingCartCatalogBean shoppingCartCatalogBean = (ShoppingCartCatalogBean)session.getAttribute("cartBean");
		// prepare the order table
		Order order =  new Order();
		order.setCreationDate(new Date());
		order.setOrderDescription("order is placed by " + userId);
		order.setUserId(userId);
		order.setStatus("PENDING");
		List<ProductOrder> offerList = new ArrayList<ProductOrder>();
		for (ShoppingCartBean cartBean : shoppingCartCatalogBean.getShoppingCartBeanList()){
			ProductOrder productOrder = new ProductOrder();
			productOrder.setOfferId((cartBean.getProductId()));
			productOrder.setProdName(cartBean.getProductName());
			productOrder.setProdDesc(cartBean.getProductDescription());
			productOrder.setPrice(cartBean.getProductPrice());
			productOrder.setCreationDate(order.getCreationDate());
			offerList.add(productOrder);
		}
		
		order.setOfferList(offerList);
		
		return order;
		
	} 
	/**
	 * prepare Order bean object from the order model
	 * @param order
	 * @return
	 */
	private OrderBean prepareOrderBean(Order order){
		OrderBean orderBean = new OrderBean();
		orderBean.setOrderId(order.getOrderId());
		orderBean.setStatus(order.getStatus());
		orderBean.setOrderDescription(order.getOrderDescription());
		orderBean.setCreationDate(order.getCreationDate());
		orderBean.setUserId(order.getUserId());
		orderBean.setProductIDList(order.getOfferList());
		int totalPrice = 0;
		for (ProductOrder productOrder : order.getOfferList()){
			totalPrice += productOrder.getPrice();
		}
		orderBean.setTotalPrice(totalPrice);
		return orderBean;
	} 
	
}
