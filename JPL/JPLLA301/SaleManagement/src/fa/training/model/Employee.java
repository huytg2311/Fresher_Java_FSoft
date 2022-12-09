package fa.training.model;

/**
 * @author Duy Bach
 * Jan 28, 2019
 */
public class Employee {

	private int empID;
	private String empName;
	private double salary;
	private int spvrID;
	
	/**
	 * @param empID
	 * @param empName
	 * @param salary
	 * @param spvrID
	 */
	public Employee(int empID, String empName, double salary, int spvrID) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.salary = salary;
		this.spvrID = spvrID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [empID=");
		builder.append(empID);
		builder.append(", empName=");
		builder.append(empName);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", spvrID=");
		builder.append(spvrID);
		builder.append("]");
		return builder.toString();
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
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * this empName method to set
	 * @param empName 
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * this salary method to set
	 * @param salary 
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the spvrID
	 */
	public int getSpvrID() {
		return spvrID;
	}

	/**
	 * this spvrID method to set
	 * @param spvrID 
	 */
	public void setSpvrID(int spvrID) {
		this.spvrID = spvrID;
	}

	public Employee() {
		super();
	}
	
}
