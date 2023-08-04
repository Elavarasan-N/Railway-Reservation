package com.edubridge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.entity.Account;
import com.edubridge.entity.Booking;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> 
{
	public Account findByAccountId(long accountId);
	public Account findAccountByCustomerId(long customerId);
}