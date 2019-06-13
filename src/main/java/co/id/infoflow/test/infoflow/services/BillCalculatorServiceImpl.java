package co.id.infoflow.test.infoflow.services;

import java.util.List;

import co.id.infoflow.test.infoflow.entity.Customer;
import co.id.infoflow.test.infoflow.entity.CustomerType;
import co.id.infoflow.test.infoflow.entity.Item;

public class BillCalculatorServiceImpl implements BillCalculatorService {

	private static final int DISCOUNT_PER_HUNDRED = 5;

	public double calculateTotalPayableAmount(Customer customer, List<Item> items) {
		double totalDiscountedPrice = 0;
		double discountPercentage = getDiscountPercentageForCustomer(customer);
		for(Item item:items) {
			totalDiscountedPrice = totalDiscountedPrice + item.getDiscountedPrice(discountPercentage);
		}
		 
		return Math.round(totalDiscountedPrice - getDiscountBasedOnTotalAmount(totalDiscountedPrice));
	}


	private double getDiscountPercentageForCustomer(Customer customer) {
		CustomerType customerType = customer.getCustomerType();
		if(customerType == CustomerType.AFFILIATE || customerType == CustomerType.EMPLOYEE || customer.isAvailableForLoyaltyDiscount()) {
			return customerType.getDiscountPercentage();
		}
		return 0;
	}
	
	private double getDiscountBasedOnTotalAmount(double totalDiscountedPrice) {
		return Math.floor(totalDiscountedPrice / 100) * DISCOUNT_PER_HUNDRED;
	}
}
