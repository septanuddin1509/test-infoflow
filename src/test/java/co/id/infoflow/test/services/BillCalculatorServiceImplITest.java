package co.id.infoflow.test.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.id.infoflow.test.base.BillingSystemBuilder;
import co.id.infoflow.test.infoflow.entity.Customer;
import co.id.infoflow.test.infoflow.entity.Item;
import co.id.infoflow.test.infoflow.services.BillCalculatorService;
import co.id.infoflow.test.infoflow.services.BillCalculatorServiceImpl;

/*
 * Following is the goal of this program
 * 
 * On a retail website, the following discounts apply: 
 * 
 * 1. If the user is an employee of the store, he gets a 30% discount 
 * 2. If the user is an affiliate of the store, he gets a 10% discount 
 * 3. If the user has been a customer for over 2 years, he gets a 5% discount. 
 * 4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount). 
 * 5. The percentage based discounts do not apply on groceries. 
 * 6. A user can get only one of the percentage based discounts on a bill.  
 * 
 * 
 * 
 */

public class BillCalculatorServiceImplITest {
	
	private BillCalculatorService billCalculatorService;
	private List<Item> items;
	
	@Before
	public void setUp() {
		billCalculatorService = new BillCalculatorServiceImpl();
		items = BillingSystemBuilder.getItemListWithMultipleProducts();
	}
	
	@Test
	public void shouldCalculateBillForDiscountEligibleCustomer() {
		Customer customer = BillingSystemBuilder.getCustomerWithMoreThanTwoYearOldRegistration();
		Assert.assertEquals(761.00, billCalculatorService.calculateTotalPayableAmount(customer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillForNonEligibleCustomer() {
		Customer customer = BillingSystemBuilder.getCustomerWithLessThanTwoYearOldRegistration();
		Assert.assertEquals(790.00, billCalculatorService.calculateTotalPayableAmount(customer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillforAffiliateCustomer() {
		Customer affiliateCustomer = BillingSystemBuilder.getAffiliateCustomer();
		Assert.assertEquals(737.00, billCalculatorService.calculateTotalPayableAmount(affiliateCustomer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillForEmployeeCustomer() {
		Customer employeeCustomer = BillingSystemBuilder.getEmployeeCustomer();
		Assert.assertEquals(626.00, billCalculatorService.calculateTotalPayableAmount(employeeCustomer, items), 0);
	}
}
