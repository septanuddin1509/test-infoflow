package co.id.infoflow.test.infoflow.entity;

public class Product {
	
	private String name;
	
	private String sku;
	
	private boolean isDiscountable;
	
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public boolean isDiscountable() {
		return isDiscountable;
	}

	public void setDiscountable(boolean isDiscountable) {
		this.isDiscountable = isDiscountable;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
