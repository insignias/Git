package com.neu.css.shoppingcart.bean;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCartCatalogBean {
	
	private int totalPrice;
	private ArrayList<ShoppingCartBean> shoppingCartBeanList;
	
	public ShoppingCartCatalogBean() {
		shoppingCartBeanList = new ArrayList<ShoppingCartBean>();
	}
	
	
	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public ArrayList<ShoppingCartBean> getShoppingCartBeanList() {
		return shoppingCartBeanList;
	}

	public void setShoppingCartBeanList(
			ArrayList<ShoppingCartBean> shoppingCartBeanList) {
		this.shoppingCartBeanList = shoppingCartBeanList;
	}
	
	public void addShoppingCartBean(ShoppingCartBean shoppingCartBean){
		shoppingCartBean.setProductId(shoppingCartBean.getProductId());
		shoppingCartBean.setProductURL(shoppingCartBean.getProductURL());
		shoppingCartBean.setProductName(shoppingCartBean.getProductName());
		shoppingCartBean.setProductDescription(shoppingCartBean.getProductDescription());
		shoppingCartBean.setProductPrice(shoppingCartBean.getProductPrice());
		shoppingCartBeanList.add(shoppingCartBean);
	}
	
	public void deleteFromShoppingCartBean(String productName){
		Iterator<ShoppingCartBean> itr = shoppingCartBeanList.iterator();
		while(itr.hasNext()){
			ShoppingCartBean sb = itr.next();
			if(sb.getProductName().equals(productName)){
				itr.remove();
			}
		}
		
	}
	
	public void shoppingCartTotal(){
		int total = 0;
		for(ShoppingCartBean sb : shoppingCartBeanList){
			if(sb.getProductDescription()!=null){
			total = total + sb.getProductPrice();
			}
		}
		setTotalPrice(total);
	}
	
	public boolean isAlreadyAdded(String productName){
		for (ShoppingCartBean bean : shoppingCartBeanList){
			if (bean.getProductName().equals(productName)){
				return true;
			}
		} return false;
	} 

}
