package com.edubridge.service;

import java.util.List;

import com.edubridge.entity.Account;

public interface AccountService 
{

	Account createAccount(Account account, long customerId);
	List<Account> getAllAccount();
	Account getAccountById(long accountId);
	void deleteAccount(long accountId);
	Account updateAccount(Account account, long accountId);
	Account getAccountByCustomerId(long customerId);

}
