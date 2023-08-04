package com.edubridge.service;

import java.util.List;

import com.edubridge.entity.Customer;
import com.edubridge.entity.Train;

public interface CustomerService 
{

	Customer saveCustomer(Customer customer);
	Customer loginCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer getCustomerById(long customerId);
	Customer updateCustomer(Customer customer, long customerId);
	void deleteCustomer(long customerId);
	Customer getCustomerByEmail(Customer customer);
	
}
