/**
 * @project SaleManagement
 */
package fa.training.service;

import org.junit.Test;

/**
 * author Duy Bach.
 * @time 10:17:12 PM
 * @date Jun 20, 2019
 */
public class OrderServiceTest {

  /**
   * Case 1: Get all orders by customer id success.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testFindAllOrdersSuccess() {

  }
  
  /**
   * Case 2: Get all orders by unknown customer id.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testFindAllOrdersFail() {

  }
  
  /**
   * Case 3: Save new order into the database success.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testSaveOrderSuccess() {
   
  }
  /**
   * Case 4: Save new order but order id is already exist.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testSaveOrderFailByOrderId() {

  }
  /**
   * Case 5: Save new order but no customer id found.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testSaveOrderFailByCustomerId() {

  }
  
  /**
   * Case 6: Save new order but no employee id found.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testSaveOrderFailByEmployeeId() {

  }
  /**
   * Case 7: Save null object to database.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testSaveOrderFailByNull() {

  }
  
  /**
   * Case 8: Compute existed order from database and return a value.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testComputeTotalSuccess() {
    
  }
  /**
   * Case 9: Compute un-existed order from database.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testComputeTotalFailOrderNotFound() {

  }
  
  /**
   * Case 10: Update order total success.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testUpdateOrderTotalSuccess() {

  }
  
  /**
   * Case 11: Update order total from an unknown order.
   * 
   * Input:
   * 
   * Output:
   */
  @Test
  void testUpdateOrderTotalFailOrderNotFound() {

  }
}
