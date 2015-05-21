/**
 * 
 */
package com.neu.css.productcatalog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity  
@Table(name="TABLE_PRODUCT_TYPE")
public class ProductCatalogType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PRODUCT_TYPE_ID")
	private String productCatalogID;
	@Column(name = "PRODUCT_TYPE_DESC")
	private String productCatalogDesc;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="PRODUCT_TYPE_ID")
	private Collection<Product> products = new ArrayList<Product>();	
	
	public Collection<Product> getProducts() {
		return products;
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getProductCatalogID() {
		return productCatalogID;
	}
	public String getProductCatalogDesc() {
		return productCatalogDesc;
	}
	public void setProductCatalogID(String productCatalogID) {
		this.productCatalogID = productCatalogID;
	}
	public void setProductCatalogDesc(String productCatalogDesc) {
		this.productCatalogDesc = productCatalogDesc;
	}
	
}
