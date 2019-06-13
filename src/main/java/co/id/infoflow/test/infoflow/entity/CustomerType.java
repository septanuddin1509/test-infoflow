package co.id.infoflow.test.infoflow.entity;

public enum CustomerType {
	
	AFFILIATE(10),EMPLOYEE(30),CUSTOMER(5);
	
	private double discountPercentage;
	
	CustomerType(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	public double getDiscountPercentage() {
		return discountPercentage;
	}

}
