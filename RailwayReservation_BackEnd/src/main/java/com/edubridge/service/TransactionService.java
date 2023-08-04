package com.edubridge.service;

import java.util.List;

import com.edubridge.entity.Transaction;

public interface TransactionService 
{
	public Transaction addtransaction(Transaction transaction, long accountId, long customerId);
	public Transaction getTransactionById(long transactionId);
	public Transaction getTransactionByAccountId(long accountId);
	public List<Transaction> getTransactionByCustomerId(long customerId);
}
