package kosa.bank;

import java.util.Arrays;

public class MyBank {
	Customer[] customers;
	int customersNum;
	
	public MyBank() {
		this.customers = new Customer[100];
		this.customersNum = 0;
	}

	public void addCustomer(String id, String name, long balance) {
		this.customers[this.customersNum++] = new Customer(id, name, balance);
	}
	
	public int getCustomerNum() {
		return this.customersNum;
	}
	
	public Customer getCustomer(String id) {
		for (int idx = 0; idx < this.customersNum; idx++) {
			if (id.equals(this.customers[idx].getId())) {
				return this.customers[idx];
			}
		}
		
		return null;
	}
	
	public Customer[] getAllCustomers() {
		return Arrays.copyOf(this.customers, this.customersNum);
	}
}
