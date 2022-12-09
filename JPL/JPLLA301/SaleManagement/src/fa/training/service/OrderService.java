/**
 * @project SaleManagement
 */
package fa.training.service;

import java.util.List;

import fa.training.model.Order;

/**
 * author Duy Bach.
 * @time 9:52:56 PM
 * @date Jun 22, 2019
 */
public interface OrderService {

  boolean addOrder(Order order);
  
  boolean updateOrderTotal(int orderId);
  
  List<Order> getAllOrdersByCustomerId(int customerId);
  
  Double computeOrderTotal(int orderId);
}
