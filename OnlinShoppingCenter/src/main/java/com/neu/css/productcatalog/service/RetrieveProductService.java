/**
 * 
 */
package com.neu.css.productcatalog.service;

import java.util.List;

import com.neu.css.productcatalog.model.Product;
import com.neu.css.productcatalog.model.ProductCatalogType;


public interface RetrieveProductService {
	public List<Product> retrieveProductList(String productCatalogType); 
	public List<Product> retrieveProductList(String productTypeId,int minPrice,int maxPrice);
	public List<ProductCatalogType> retrieveProductCatalogList();
}
