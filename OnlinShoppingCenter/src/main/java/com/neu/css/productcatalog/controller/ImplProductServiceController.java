/**
 * 
 */
package com.neu.css.productcatalog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neu.css.common.ImplCommonConsts;
import com.neu.css.productcatalog.model.ImplProductBean;
import com.neu.css.productcatalog.model.Product;
import com.neu.css.productcatalog.model.ProductCatalogType;
import com.neu.css.productcatalog.service.RetrieveProductService;

@Controller
public class ImplProductServiceController {
	private static final Logger logger = LoggerFactory.getLogger(ImplProductServiceController.class);  
	@Autowired  
	private RetrieveProductService retrieveProductService;
	
    @RequestMapping(value = ImplCommonConsts.RETRIEVE_PRODUCT_LIST, method = RequestMethod.GET)
    public @ResponseBody List<ImplProductBean> getProductList() {
        logger.info("Start get list of product");
        List<ImplProductBean> products = new ArrayList<ImplProductBean>();
        // call the service to retrive the list of objects
        List<ProductCatalogType> productCatalogList = retrieveProductService.retrieveProductCatalogList();
        for (ProductCatalogType catalogType :  productCatalogList ){
        	for (Product product : catalogType.getProducts()){
        		   products.add(modeltoBean(product));
        	}
        }
        return products;
    }
     
    @RequestMapping(value = ImplCommonConsts.RETRIEVE_PRODUCT_LIST_BY_PRICE, method = RequestMethod.GET)
    public @ResponseBody List<ImplProductBean> getProductListByPrice(@PathVariable("productType") String productType,@PathVariable("minPrice") int minPrice,@PathVariable("maxPrice") int maxPrice) {
    	logger.info("Get List of products using with min price and max price and type" );
        logger.info("Type : " + productType);
        logger.info("min Price : " + minPrice);
        logger.info("max Price : " + maxPrice);
        // call the service to get the data from the backend using filter
        List<Product> productList = retrieveProductService.retrieveProductList(productType, minPrice, maxPrice);
        //convert in to product bean
        return modeltoBean(productList);
    }
     
    @RequestMapping(value = ImplCommonConsts.RETRIEVE_PRODUCT_LIST_BY_TYPE, method = RequestMethod.GET)
    public @ResponseBody List<ImplProductBean> getProductByType(@PathVariable("productType") String productType) {
        logger.info("Start getAllEmployees.");
        //get the product using product services from backend 
        List<Product> productList = retrieveProductService.retrieveProductList(productType);
        return modeltoBean(productList);
    }
    
    /**
     * Generate ArrayList of ImplProductBean from ArrayList of Product
     */
    private List<ImplProductBean> modeltoBean(List<Product> productList){
    	List<ImplProductBean> productBeansList = new ArrayList<ImplProductBean>();
    	for (Product product : productList){
    		ImplProductBean bean = new ImplProductBean();
    		bean.setProductDescription(product.getProductDescription());
    		bean.setProductID(product.getProductID());
    		bean.setProductName(product.getProductName());
    		bean.setProductPrice(product.getProductPrice());
    		bean.setProducttTypeID(product.getProductTypeID());
    		bean.setProductURL(product.getProductURL());
    		productBeansList.add(bean);
    	}
    	return productBeansList;
    }
    
    /**
     * Generate ImplProductBean from Product
     */
    private ImplProductBean modeltoBean(Product product){
    		ImplProductBean bean = new ImplProductBean();
    		bean.setProductDescription(product.getProductDescription());
    		bean.setProductID(product.getProductID());
    		bean.setProductName(product.getProductName());
    		bean.setProductPrice(product.getProductPrice());
    		bean.setProducttTypeID(product.getProductTypeID());
    		bean.setProductURL(product.getProductURL());
    		return bean;
    }
}
