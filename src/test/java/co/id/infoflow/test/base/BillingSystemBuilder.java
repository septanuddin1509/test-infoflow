package co.id.infoflow.test.base;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import co.id.infoflow.test.infoflow.entity.Customer;
import co.id.infoflow.test.infoflow.entity.CustomerType;
import co.id.infoflow.test.infoflow.entity.Item;
import co.id.infoflow.test.infoflow.entity.Product;

public class BillingSystemBuilder {
	
	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	public static Product getDiscountableProduct() {
		Product product = new Product();
		product.setSku("SKU123");
		product.setName("Roti Tawar");
		product.setDiscountable(Boolean.TRUE);
		product.setPrice(57.99);
		
		return product;
	}
	
	public static Product getNonDiscountableProduct() {
		Product product = new Product();
		product.setSku("SKU124");
		product.setName("Aqua");
		product.setDiscountable(Boolean.FALSE);
		product.setPrice(49.99);
		
		return product;
	}
	
	public static Customer getAffiliateCustomer() {
		Customer customer = new Customer(CustomerType.AFFILIATE, "customer1", "Septa", new DateTime().minusYears(3));
		return customer;
	}
	
	public static Customer getEmployeeCustomer() {
		Customer customer = new Customer(CustomerType.EMPLOYEE, "customer2", "Nuddin", new DateTime().minusYears(3));
		return customer;
	}
	
	public static Customer getCustomerWithMoreThanTwoYearOldRegistration() {
		Customer customer = new Customer(CustomerType.CUSTOMER, "customer3", "Satria", new DateTime().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).minusDays(1));
		return customer;
	}
	
	public static Customer getCustomerWithLessThanTwoYearOldRegistration() {
		Customer customer = new Customer(CustomerType.CUSTOMER, "customer4", "Tama", new DateTime().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).plusDays(1));
		return customer;
	}
	
	public static Item getItemWithDiscountableProduct(int quantity) {
		return new Item(getDiscountableProduct(), quantity);
	}
	
	public static Item getItemWithNonDiscountableProduct(int quantity) {
		return new Item(getNonDiscountableProduct(), quantity);
	}
	
	public static List<Item> getItemListWithMultipleProducts() {
		List<Item> items = new ArrayList<Item>();
		items.add(getItemWithDiscountableProduct(10));
		items.add(getItemWithNonDiscountableProduct(5));
		return items;
	}
}
