/**
 * 
 */
package com.neu.css.productcatalog.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neu.css.productcatalog.model.Product;
import com.neu.css.productcatalog.model.ProductCatalogType;

@Repository("retrieveProductDAO")
public class ImplRetrieveProductDAO implements RetrieveProductDAO{
	@Autowired  
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.neu.css.productcatalog.dao.RetrieveProductDAO#retrieveProductList(com.neu.css.productcatalog.model.ProductCatalogType)
	 */
	@Override
	public List<Product> retrieveProductList(String productCatalogType) {
		try {
            Query query = sessionFactory.getCurrentSession().createQuery("from ProductCatalogType where productCatalogID = :productCatalogID");
            query.setString("productCatalogID", productCatalogType);
			ProductCatalogType productType = (ProductCatalogType) query.uniqueResult();
            return (List<Product>) productType.getProducts();
        } catch (HibernateException e) {	         
			e.printStackTrace();
        }
		return null;
	}

	/* (non-Javadoc)
	 * @see com.neu.css.productcatalog.dao.RetrieveProductDAO#retrieveProductList(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> retrieveProductList(String productTypeID,int minPrice, int maxPrice) {
		try {
            Query query = sessionFactory.getCurrentSession().createQuery("from Product where productTypeID = :productTypeID and productPrice between :minPrice and :maxPrice");
            query.setString("minPrice", String.valueOf(productTypeID));
            query.setInteger("minPrice", minPrice);
            query.setInteger("maxPrice", maxPrice);
            List<Product> products = query.list();
            return products;
        } catch (HibernateException e) {	         
			e.printStackTrace();
        }
		return null;
	}

	/* (non-Javadoc)
	 * @see com.neu.css.productcatalog.dao.RetrieveProductDAO#retrieveProductList()
	 */
	@Override
	public List<ProductCatalogType> retrieveProductCatalogList() {
		try {
            Query query = sessionFactory.getCurrentSession().createQuery("from ProductCatalogType");
            List<ProductCatalogType> productCategoryList = query.list();
            return productCategoryList;
        } catch (HibernateException e) {	         
			e.printStackTrace();
        }
		return null;
	}

}
