package fa.training.model;

/**
 * @author Duy Bach
 * Jan 28, 2019
 */
public class Customer {

	private int cusID;
	private String cusName;
	
	/**
	 * @param cusID
	 * @param cusName
	 */
	public Customer(int cusID, String cusName) {
		super();
		this.cusID = cusID;
		this.cusName = cusName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [cusID=");
		builder.append(cusID);
		builder.append(", cusName=");
		builder.append(cusName);
		builder.append("]");
		return builder.toString();
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
	 * @return the cusName
	 */
	public String getCusName() {
		return cusName;
	}

	/**
	 * this cusName method to set
	 * @param cusName 
	 */
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public Customer() {
		super();
	}
	
}
