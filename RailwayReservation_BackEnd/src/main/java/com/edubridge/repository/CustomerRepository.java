package com.edubridge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edubridge.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> 
{
	Optional<Customer> findByEmailAndPassword(String email,String password);
	public List<Customer> findByCustomerId(long customerId);
	Optional<Customer> findByEmail(String email);
}
