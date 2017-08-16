package com.store.service;

import com.store.vo.Customer;
import com.store.vo.Product;

public class OutletStoreService {
	// 1. Print all names of products sold to customer
	public void printAllProductNamesByCustomer(Customer customer, Product[] products) {
		System.out.println(" ========== Product names of " + customer.getCustomerName() + " bought ==========" );
		for(Product product : products)
			System.out.print(product.getModel() + "\t");
		System.out.println();
	}
	
	// 2. Print all customer information
	public void printAllCustomers(Customer[] customers){
		System.out.println(" ========== Customer names ==========" );
		for(Customer customer : customers)
			System.out.println(customer.getSsn() + " " + customer.getCustomerName() + " " + customer.getAddress() );
	}
	
	// 3. Return all products of a customer --> print product with price over 10000
	public Product[] getAllProductsOfCustomer(Customer customer){
		return customer.getProducts();
	}
	// 4. Return the most expecsive products prie of a customer
	public int getMostExpensivePrice(Customer customer){
		int result = 0;
		for(Product product : customer.getProducts()){
			if(result < product.getPrice() )
				result = product.getPrice();
		}
		return result;
	}
}
