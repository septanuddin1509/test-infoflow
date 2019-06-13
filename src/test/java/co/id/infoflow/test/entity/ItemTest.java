package co.id.infoflow.test.entity;

import org.junit.Assert;
import org.junit.Test;

import co.id.infoflow.test.base.BillingSystemBuilder;
import co.id.infoflow.test.infoflow.entity.Item;
import co.id.infoflow.test.infoflow.entity.Product;

public class ItemTest {
	
	
	@Test
	public void shouldGetNoDiscountForNonDiscountableProduct() {
		Product product = BillingSystemBuilder.getNonDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(199.96, item.getDiscountedPrice(5), 0);
	}
	
	@Test
	public void shouldGetDiscountedPriceForDiscountableProduct() {
		Product product = BillingSystemBuilder.getDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(220.36, item.getDiscountedPrice(5), 0.1);
	}
	
	@Test
	public void shouldGetNoDiscountForZeroDiscountPercentage() {
		Product product = BillingSystemBuilder.getDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(231.96, item.getDiscountedPrice(0), 0);
		
	}

}
