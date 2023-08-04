package com.edubridge.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.entity.Account;
import com.edubridge.entity.Customer;
import com.edubridge.repository.AccountRepository;
import com.edubridge.service.AccountService;
import com.edubridge.service.CustomerService;

@Service
public class AccountServiceImpl implements AccountService
{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;

	@Override
	public Account createAccount(Account account, long customerId) 
	{
		Customer customer = customerService.getCustomerById(customerId);
		account.setCustomerId(customer.getCustomerId());
		account.setFirstName(customer.getFirstName());
		account.setLastName(customer.getLastName());
		account.setEmail(customer.getEmail());
		account.setDateOfBirth(customer.getDateOfBirth());
		account.setGender(customer.getGender());
		account.setPhoneNumber(customer.getPhoneNumber());
		account.setDistrict(customer.getDistrict());
		account.setState(customer.getState());
		account.setPincode(customer.getPincode());
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccount() 
	{
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(long accountId) 
	{
		return accountRepository.findById(accountId).orElseThrow();
	}

	@Override
	public void deleteAccount(long accountId) 
	{
		accountRepository.findById(accountId).orElseThrow();
		accountRepository.deleteById(accountId);
	}

	@Override
	public Account updateAccount(Account account, long accountId) 
	{
		Account existingAccount = accountRepository.findById(accountId).orElseThrow();
		existingAccount.setAmount(account.getAmount());
		existingAccount.setFirstName(account.getFirstName());
		existingAccount.setLastName(account.getLastName());
		existingAccount.setEmail(account.getEmail());
		existingAccount.setGender(account.getGender());
		existingAccount.setPhoneNumber(account.getPhoneNumber());
		existingAccount.setDateOfBirth(account.getDateOfBirth());
		existingAccount.setDistrict(account.getDistrict());
		existingAccount.setState(account.getState());
		existingAccount.setPincode(account.getPincode());
		accountRepository.save(existingAccount);
		return existingAccount;
	}

	@Override
	public Account getAccountByCustomerId(long customerId) 
	{
		return accountRepository.findAccountByCustomerId(customerId);
	}

}
