package com.edubridge;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edubridge.entity.Customer;
import com.edubridge.repository.CustomerRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerTestCase {

@Autowired
CustomerRepository customerRepository;




//adding customer
@Test
@Order(1)
public void testCreate()
{

Customer customer=new Customer();
customer.setFirstName("Ashwin");
customer.setLastName("Kunder");
customer.setPhoneNumber("9880676232");
customer.setGender("Male");
customer.setDistrict("Udupi");
customer.setState("Karnataka");
customer.setPincode("576111");
customer.setEmail("ash@gmail.com");
customer.setPassword("Ashwin@123");
customer.setConfirmPassword("Ashwin@123");
customerRepository.save(customer);
assertNotNull(customerRepository.findById(2L).get());
}




//deleting customer
@Test
@Order(3)
public void testDelete()
{
customerRepository.deleteById(1L);
assertFalse(customerRepository.existsById(1L));
}



}