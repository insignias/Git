/**
 * 
 */
package com.neu.css.productcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neu.css.productcatalog.dao.RetrieveProductDAO;
import com.neu.css.productcatalog.model.Product;
import com.neu.css.productcatalog.model.ProductCatalogType;

@Service("retrieveProductService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ImplRetrieveProductService implements RetrieveProductService{
	@Autowired  
	private RetrieveProductDAO retrieveProductDAO;
	/* (non-Javadoc)
	 * @see com.neu.css.productcatalog.service.RetrieveProductService#retrieveProductList(com.neu.css.productcatalog.model.ProductCatalogType)
	 */
	@Override
	public List<Product> retrieveProductList(String productCatalogType) {
		return retrieveProductDAO.retrieveProductList(productCatalogType);
	}

	/* (non-Javadoc)
	 * @see com.neu.css.productcatalog.service.RetrieveProductService#retrieveProductList(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Product> retrieveProductList(String productTypeId, int minPriceRange, int maxPriceRange) {
		return retrieveProductDAO.retrieveProductList(productTypeId,minPriceRange,maxPriceRange);
	}

	/* (non-Javadoc)
	 * @see com.neu.css.productcatalog.service.RetrieveProductService#retrieveProductList()
	 */
	@Override
	public List<ProductCatalogType> retrieveProductCatalogList() {
		// TODO Auto-generated method stub
		return retrieveProductDAO.retrieveProductCatalogList();
	}

}
