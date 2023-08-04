package com.edubridge.controller;

import java.util.List;

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

import com.edubridge.entity.Account;
import com.edubridge.service.AccountService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/account")
public class AccountController 
{
	@Autowired
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	//creating account for customer
	@PostMapping("{customerId}")
	public ResponseEntity<Account> createAccount(@RequestBody Account account,@PathVariable long customerId)
	{
		return new ResponseEntity<Account>(accountService.createAccount(account,customerId),HttpStatus.CREATED);
	}
	
	//getting list of Accounts
	@GetMapping("/accounts")
	public List<Account> getAllAccount()
	{
		return accountService.getAllAccount();
	}

	//to get account by account id
	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getAccountById(@PathVariable("accountId") long accountId)
	{
		return new ResponseEntity<Account>(accountService.getAccountById(accountId),HttpStatus.OK);
	}
	
	@GetMapping("customer/{customerId}")
	public ResponseEntity<Account> getAccountByCustomerId(@PathVariable("customerId") long customerId)
	{
		return new ResponseEntity<Account>(accountService.getAccountByCustomerId(customerId),HttpStatus.OK);
	}
	
	@PutMapping("/{accountId}")
	public ResponseEntity<Account> updateAccount(@PathVariable("accountId") long accountId, @RequestBody Account account)
	{
		return new ResponseEntity<Account>(accountService.updateAccount(account, accountId),HttpStatus.OK);
	}
	
	// to delete account
	@DeleteMapping("/{accountId}")
	public ResponseEntity<Boolean> deleteAccount(@PathVariable("accountId") long accountId)
	{
		accountService.deleteAccount(accountId);
		boolean flag=true;
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
	}
	
}
