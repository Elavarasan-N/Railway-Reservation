package com.edubridge.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.edubridge.entity.Account;
import com.edubridge.entity.Customer;
import com.edubridge.entity.Transaction;
import com.edubridge.repository.TransactionRepository;
import com.edubridge.service.AccountService;
import com.edubridge.service.CustomerService;
import com.edubridge.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService
{
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerService customerService;
	
	@Override
	public Transaction getTransactionById(long transactionId) 
	{
		return transactionRepository.findById(transactionId);
	}

	@Override
	public Transaction addtransaction(Transaction transaction, long accountId,long customerId)
	{
		Account account=accountService.getAccountById(accountId);
		Customer customer=customerService.getCustomerById(customerId);
		transaction.setCustomerId(customer.getCustomerId());
		transaction.setAccountId(account.getAccountId());
		transaction.setAmount(account.getAmount());
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction getTransactionByAccountId(long accountId) 
	{
		return transactionRepository.findTransactionByAccountId(accountId);
	}

	@Override
	public List<Transaction> getTransactionByCustomerId(long customerId) 
	{
		return transactionRepository.findAllTransactionByCustomerId(customerId);
	}


}
