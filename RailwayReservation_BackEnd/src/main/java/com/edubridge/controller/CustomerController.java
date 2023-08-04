package com.edubridge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.entity.Customer;
import com.edubridge.service.CustomerService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/customer")
public class CustomerController 
{
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public  ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerService.loginCustomer(customer),HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomer();
    }
	
	//get customer by email
	@PostMapping("/forgotpass")
	public Customer getCustomerByEmail(@RequestBody Customer customer)
	{
		return customerService.getCustomerByEmail(customer);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") long customerId)
	{
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId),HttpStatus.OK);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@Valid @PathVariable("customerId") long customerId, @RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, customerId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable long customerId)
	{
		customerService.deleteCustomer(customerId);
		boolean flag=true;
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
	}
	
}
