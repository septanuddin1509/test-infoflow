package co.id.infoflow.test.infoflow.services;

import java.util.List;

import co.id.infoflow.test.infoflow.entity.Customer;
import co.id.infoflow.test.infoflow.entity.Item;

public interface BillCalculatorService {
	
	double calculateTotalPayableAmount(Customer customer, List<Item> items);

}
