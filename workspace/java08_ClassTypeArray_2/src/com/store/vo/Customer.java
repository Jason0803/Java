package com.store.vo;

public class Customer {
	private int ssn;
	private String customerName;
	private String address;
	private Product[] products;
	
	// Constructor for ssn, customerName, address
	public Customer(int ssn, String customerName, String address) {
		super();
		this.ssn = ssn;
		this.customerName = customerName;
		this.address = address;
	}

	// getters for ALL field
	public int getSsn() {
		return ssn;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getAddress() {
		return address;
	}

	public Product[] getProducts() {
		return products;
	}
	
	

	// Product[] --> setters
	public void setProducts(Product[] products) {
		this.products = products;
	}
	
	// address --> setter
	public void changeAddress(String address) {
		this.address = address;
	}
	
}
