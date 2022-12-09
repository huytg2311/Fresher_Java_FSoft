package fa.training.model;

import java.util.Date;

/**
 * @author Duy Bach
 * Jan 28, 2019
 */
public class Order {

	private int orderID;
	private Date orderDate;
	private int cusID;
	private int empID;
	private double total;
	
	/**
	 * @param orderID
	 * @param orderDate
	 * @param cusID
	 * @param empID
	 * @param total
	 */
	public Order(int orderID, Date orderDate, int cusID, int empID, double total) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.cusID = cusID;
		this.empID = empID;
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderID=");
		builder.append(orderID);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", cusID=");
		builder.append(cusID);
		builder.append(", empID=");
		builder.append(empID);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the orderID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * this orderID method to set
	 * @param orderID 
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * this orderDate method to set
	 * @param orderDate 
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the cusID
	 */
	public int getCusID() {
		return cusID;
	}

	/**
	 * this cusID method to set
	 * @param cusID 
	 */
	public void setCusID(int cusID) {
		this.cusID = cusID;
	}

	/**
	 * @return the empID
	 */
	public int getEmpID() {
		return empID;
	}

	/**
	 * this empID method to set
	 * @param empID 
	 */
	public void setEmpID(int empID) {
		this.empID = empID;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * this total method to set
	 * @param total 
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	public Order() {
		super();
	}
	
}
