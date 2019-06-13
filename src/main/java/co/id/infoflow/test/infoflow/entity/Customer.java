package co.id.infoflow.test.infoflow.entity;

import org.joda.time.DateTime;

public class Customer {
	
	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	private CustomerType customerType;
	
	private String customerID;
	
	private String customerName;
	
	private DateTime registrationDate;
	
	public Customer(CustomerType customerType, String customerID, String customerName, DateTime registrationDate) {
		super();
		this.customerType = customerType;
		this.customerID = customerID;
		this.customerName = customerName;
		this.registrationDate = registrationDate;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public DateTime getRegistrationDate() {
		return registrationDate;
	}
	
	public boolean isAvailableForLoyaltyDiscount() {
		DateTime dateToCompare = DateTime.now().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS);
		return registrationDate.isBefore(dateToCompare) && (CustomerType.CUSTOMER == customerType);
	}
}
