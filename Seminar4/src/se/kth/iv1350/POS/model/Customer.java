package se.kth.iv1350.POS.model;

/**
 * This class represents a customer with a unique customerID
 */
public class Customer {
	private String customerID;
	private int age;
	private int membershipLength;

	/**
	 * This is a constructor that creates an instance of the class Customer.
	 *
	 * @param customerID  is a unique String object that every customer has so that
	 *                       they can get identified.
	 * @param age Customer age
	 * @param membershipLength
	 */
	public Customer(String customerID, int age, int membershipLength) {
		this.customerID = customerID;
		this.age = age;
		this.membershipLength = membershipLength;
	}

	public String getCustomerID() {
		return customerID;
	}

	public int getAge() {
		return age;
	}

	public int getMembershipLength() {
		return membershipLength;
	}
}