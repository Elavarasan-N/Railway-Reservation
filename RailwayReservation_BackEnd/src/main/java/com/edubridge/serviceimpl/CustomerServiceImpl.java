package com.edubridge.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.entity.Customer;
import com.edubridge.exception.CustomerNotFoundException;
import com.edubridge.repository.CustomerRepository;
import com.edubridge.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	
	@Autowired
	private CustomerRepository customerRepository; 

	@Override
	public Customer saveCustomer(Customer customer) 
	{
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() 
	{
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(long customerId) 
	{
		return this.customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer","customerId",customerId));
	}

	@Override
	public Customer updateCustomer(Customer customer, long customerId) 
	{
		Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer","customerId",customerId));
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setDateOfBirth(customer.getDateOfBirth());
		existingCustomer.setGender(customer.getGender());
		existingCustomer.setDistrict(customer.getDistrict());
		existingCustomer.setPhoneNumber(customer.getPhoneNumber());
		existingCustomer.setState(customer.getState());
		existingCustomer.setPincode(customer.getPincode());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setConfirmPassword(customer.getConfirmPassword());
		customerRepository.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public void deleteCustomer(long customerId) 
	{
		customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer","customerId",customerId));
		customerRepository.deleteById(customerId);
	}

	@Override
	public Customer loginCustomer(Customer customer) 
	{
		return this.customerRepository.findByEmailAndPassword(customer.getEmail(),customer.getPassword()).orElseThrow(()->new CustomerNotFoundException("Customer ", "customerId",customer.getEmail()+" and password "+customer.getPassword() ));
	}

	@Override
	public Customer getCustomerByEmail(Customer customer) 
	{
		return this.customerRepository.findByEmail(customer.email).orElseThrow(()->new CustomerNotFoundException("Customer ", "Email",customer.email));
	}

}
