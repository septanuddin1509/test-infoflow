package co.id.infoflow.test.entity;

import junit.framework.Assert;

import org.junit.Test;

import co.id.infoflow.test.base.BillingSystemBuilder;
import co.id.infoflow.test.infoflow.entity.Customer;

public class CustomerTest {
	
	@Test
	public void shouldReturnTrueForMoreThanTwoYearOldRegistration() {
		Customer customer = BillingSystemBuilder.getCustomerWithMoreThanTwoYearOldRegistration();
		Assert.assertTrue(customer.isAvailableForLoyaltyDiscount());
	}
	
	@Test
	public void shouldReturnFalseForNonEmployee() {
		Customer customer = BillingSystemBuilder.getAffiliateCustomer();
		Assert.assertFalse(customer.isAvailableForLoyaltyDiscount());
	}
	
	@Test
	public void shouldReturnFalseForLessThanTwoYearOldRegistration() {
		Customer customer = BillingSystemBuilder.getCustomerWithLessThanTwoYearOldRegistration();
		Assert.assertFalse(customer.isAvailableForLoyaltyDiscount());
	}
}
