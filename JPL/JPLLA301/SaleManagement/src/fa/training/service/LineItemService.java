/**
 * @project SaleManagement
 */
package fa.training.service;

import java.util.List;

import fa.training.model.LineItem;

/**
 * author Duy Bach.
 * @time 9:55:42 PM
 * @date Jun 22, 2019
 */
public interface LineItemService {

  boolean addLineItem(LineItem item);
  
  List<LineItem> getAllItemsByOrderId(int orderId);
}
