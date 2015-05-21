/**
 * 
 */
package com.neu.css.productcatalog.dao;

import java.util.List;

import com.neu.css.productcatalog.model.Product;
import com.neu.css.productcatalog.model.ProductCatalogType;


public interface RetrieveProductDAO {
	public List<Product> retrieveProductList(String productCatalogType); 
	public List<Product> retrieveProductList(String productTypeID, int minPrice,int maxPrice);
	public List<ProductCatalogType> retrieveProductCatalogList();
}
