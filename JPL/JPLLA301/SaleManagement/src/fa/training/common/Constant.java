/**
 * @project SaleManagement
 */

package fa.training.common;

/**
 * author Duy Bach.
 * 
 * @time 2:05:09 PM
 * @date Jun 22, 2019
 */
public class Constant {

  public static String CUSTOMER_QUERY_ADD = "{call usp_addCustomer(?, ?, ?)}",
      CUSTOMER_QUERY_UPDATE = "{CALL usp_updateCustomer(?, ?, ?)}",
      CUSTOMER_QUERY_DELETE = "{CALL usp_deleteCustomer(?, ?)}",
      CUSTOMER_QUERY_FIND_BY_ID = "SELECT * FROM Customer WHERE customer_id = ?",
      CUSTOMER_QUERY_FIND_ALL = "SELECT * FROM Customer WHERE customer_id in (SELECT customer_id FROM Orders GROUP BY customer_id)";

  public static String ORDER_QUERY_ADD = "INSERT INTO Orders VALUES (?, ?, ?, ?, ?)",
      ORDER_QUERY_UPDATE_TOTAL = "UPDATE Orders SET total = udf_computeOrderTotal(?) WHERE order_id = ?",
      ORDER_QUERY_FIND_BY_ID = "SELECT * FROM Orders WHERE order_id = ?",
      ORDER_QUERY_FIND_BY_CUS_ID = "SELECT * FROM Orders WHERE customer_id = ?",
      ORDER_QUERY_COMPUTE_TOTAL = "SELECT total_price FROM udf_computeOrderTotal(?)";

  public static String LINEITEM_QUERY_ADD = "INSERT INTO LineItem VALUES (?, ?, ?, ?)",
      LINEITEM_QUERY_FIND_BY_ORDER_ID = "SELECT * FROM LineItem WHERE order_id = ?";

  public static String PRODUCT_QUERY_FIND_BY_ID = "SELECT * FROM Product WHERE product_id = ?";

  public static String EMPLOYEE_QUERY_FIND_BY_ID = "SELECT * FROM Employee WHERE employee_id = ?";
}
