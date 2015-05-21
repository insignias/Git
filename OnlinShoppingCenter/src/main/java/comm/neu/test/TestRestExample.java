/**
 * 
 */
package comm.neu.test;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.neu.css.common.ImplCommonConsts;

/**
 * 
 * @author insignia
 *
 */
public class TestRestExample {	
	public static final String SERVER_URI = "http://localhost:8181/css/";
    
    public static void main(String args[]){
         
    	testGetAllProducts();
        System.out.println("*****");
        testGetAllProductsByType();
        System.out.println("*****");
        testGetAllProductsByPrice();
    }
 
    private static void testGetAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        //we can't get List<Employee> because JSON convertor doesn't know the type of
        //object in the list and hence convert it to default JSON object type LinkedHashMap
        List<LinkedHashMap> products = restTemplate.getForObject(SERVER_URI + ImplCommonConsts.RETRIEVE_PRODUCT_LIST, List.class);
        printEmpData(products);
    }
 
 
    private static void testGetAllProductsByType() {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap> products = restTemplate.getForObject(SERVER_URI + ImplCommonConsts.RETRIEVE_PRODUCT_LIST_BY_TYPE +"/rest/emp/1", List.class);
        printEmpData(products);
    }
 
    private static void testGetAllProductsByPrice() {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap> products = restTemplate.getForObject(SERVER_URI + ImplCommonConsts.RETRIEVE_PRODUCT_LIST_BY_PRICE, List.class);
        printEmpData(products);
    }
     
    public static void printEmpData(List<LinkedHashMap> products){
    	System.out.println(products.size());
        for(LinkedHashMap map : products){
            System.out.println("ID="+map.get("productID")+",productDescription="+map.get("productDescription")+",productName="+map.get("productName")+",producttTypeID="+map.get("producttTypeID")+" , productID=" + map.get("productID"));
        }
    }

}
