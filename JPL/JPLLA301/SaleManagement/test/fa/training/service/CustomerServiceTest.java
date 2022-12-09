/**
 * @project SaleManagement
 */

package fa.training.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fa.training.dao.LineItemDAO;
import fa.training.dao.OrderDAO;
import fa.training.dao.impl.OrderDAOImpl;
import fa.training.model.Customer;
import fa.training.service.impl.CustomerServiceImpl;

/**
 * author Duy Bach.
 * 
 * @time 10:16:41 PM
 * @date Jun 20, 2019
 */
public class CustomerServiceTest {

  CustomerService customerService;
  OrderDAO orderDAO;
  LineItemDAO itemDAO;
  
  @Before
  public void setUp() {
    customerService = new CustomerServiceImpl();   
    orderDAO = new OrderDAOImpl();
  }

  /**
   * Case 1: Save new customer into database success.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  public void testSaveSuccess() {
    Customer customer = new Customer(10, "Duy Bach");
    assertTrue("Save fail", customerService.addCustomer(customer));
  }

  /**
   * Case 2: Save new customer but customer name is exist.
   * 
   * Input:
   * 
   * Output:
   * Expected: 
   */
  @Test
  void testSaveFailNameExist() {
    Customer customer = new Customer(10, "Duy Bach");
    customerService.addCustomer(customer);

    assertTrue("Save fail", customerService.addCustomer(customer));
  }

  /**
   * Case 3: Save null object to database.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testSaveFailNull() {
    assertTrue("Save fail", customerService.addCustomer(null));
  }

  /**
   * Case 4: Update a customer success.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testUpdateSuccess() {

    Customer customer = new Customer(1, "Duy Bach");

    assertTrue("Save fail", customerService.addCustomer(customer));
  }

  /**
   * Case 5: Update a customer whose doesn't exist.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testUpdateFailNotFound() {
    assertTrue("Save fail", customerService.updateCustomer(new Customer(2, "Bca")));
  }

  /**
   * Case 6: Update null object to database.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testUpdateFailNull() {
    assertTrue("Save fail", customerService.updateCustomer(null));
  }

  /**
   * Case 7: Delete a customer by id success.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testDeleteSuccess() {
    assertEquals(2, customerService.deleteCustomer(1));
  }

  /**
   * Case 8: Delete a customer by id which doesn't exist.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testDeleteFailNotFound() {
    assertEquals(2, customerService.deleteCustomer(6));
  }

  /**
   * Case 9: Get all customers which have had orders from database.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testFindAllCustomersSuccess() {
    customerService.addCustomer(new Customer(1, "Bach"));

    
    assertEquals(2, customerService.getAllCustomer());
  }
  
  /**
   * Case 10: Get all customers which haven't had orders in the database
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testFindAllCustomersFailNoOrders() {
    customerService.addCustomer(new Customer(10, "Hai"));

    assertEquals(2, customerService.getAllCustomer());
  }
  
}
