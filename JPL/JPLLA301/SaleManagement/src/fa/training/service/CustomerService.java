/**
 * @project SaleManagement
 */

package fa.training.service;

import java.util.List;

import fa.training.model.Customer;

/**
 * author Duy Bach.
 * 
 * @time 2:10:34 PM
 * @date Jun 22, 2019
 */
public interface CustomerService {

  boolean addCustomer(Customer customer);
  
  boolean updateCustomer(Customer customer);
  
  boolean deleteCustomer(int customerId);
  
  List<Customer> getAllCustomer();
}
