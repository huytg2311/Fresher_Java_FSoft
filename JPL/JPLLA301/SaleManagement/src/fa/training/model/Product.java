package fa.training.model;

/**
 * @author Duy Bach
 * Jan 28, 2019
 */
public class Product {

	private int proID;
	private String proName;
	private double lisPrice;
	
	/**
	 * @param proID
	 * @param proName
	 * @param lisPrice
	 */
	public Product(int proID, String proName, double lisPrice) {
		super();
		this.proID = proID;
		this.proName = proName;
		this.lisPrice = lisPrice;
	}

	public Product() {
		super();
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
	 * @return the proName
	 */
	public String getProName() {
		return proName;
	}

	/**
	 * this proName method to set
	 * @param proName 
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}

	/**
	 * @return the lisPrice
	 */
	public double getLisPrice() {
		return lisPrice;
	}

	/**
	 * this lisPrice method to set
	 * @param lisPrice 
	 */
	public void setLisPrice(double lisPrice) {
		this.lisPrice = lisPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [proID=");
		builder.append(proID);
		builder.append(", proName=");
		builder.append(proName);
		builder.append(", lisPrice=");
		builder.append(lisPrice);
		builder.append("]");
		return builder.toString();
	}
	
}
