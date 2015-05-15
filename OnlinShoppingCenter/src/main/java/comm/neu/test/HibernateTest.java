/**
 * 
 */
package comm.neu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neu.css.order.model.Order;
import com.neu.css.order.model.ProductOrder;

/**
 * 
 * @author insignia
 *
 */
public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		Order order = prepareOrderTable(); 
//		session.save(order);
//		System.out.print("Order ID :" + order.getOrderId());
//		session.getTransaction().commit();
	}
	private static Order prepareOrderTable(){
		int userId = 1; 
		Order order =  new Order();
		order.setCreationDate(new Date());
		order.setOrderDescription("order is placed by " + userId);
		order.setUserId(userId);
		order.setStatus("PENDING");
		List<ProductOrder> offerList = new ArrayList<ProductOrder>();
		
		ProductOrder productOrder = new ProductOrder();
		productOrder.setOfferId("ac");
		productOrder.setPrice(23);
		productOrder.setCreationDate(order.getCreationDate());
		offerList.add(productOrder);
		
		ProductOrder productOrder2 = new ProductOrder();
		productOrder2.setOfferId("ac");
		productOrder2.setPrice(23);
		productOrder2.setCreationDate(order.getCreationDate());
		offerList.add(productOrder);
		
		
		order.setOfferList(offerList);
		return order;
	} 
}
