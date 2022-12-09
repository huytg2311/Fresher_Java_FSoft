package fa.training.model;

/**
 * @author Duy Bach
 * Jan 28, 2019
 */
public class LineItem {

	private int orderID;
	private int proID;
	private int quatity;
	private double price;
	 
	/**
	 * @param orderID
	 * @param proID
	 * @param quatity
	 * @param price
	 */
	public LineItem(int orderID, int proID, int quatity, double price) {
		super();
		this.orderID = orderID;
		this.proID = proID;
		this.quatity = quatity;
		this.price = price;
	}

	public LineItem() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineItem [orderID=");
		builder.append(orderID);
		builder.append(", proID=");
		builder.append(proID);
		builder.append(", quatity=");
		builder.append(quatity);
		builder.append(", price=");
		builder.append(price);
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
	 * @return the proID
	 */
	public int getProID() {
		return proID;
	}

	/**
	 * this proID method to set
	 * @param proID 
	 */
	public void setProID(int proID) {
		this.proID = proID;
	}

	/**
	 * @return the quatity
	 */
	public int getQuatity() {
		return quatity;
	}

	/**
	 * this quatity method to set
	 * @param quatity 
	 */
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * this price method to set
	 * @param price 
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
}
