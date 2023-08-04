package com.edubridge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>
{
	public Transaction findById(long transactionId);
	public Transaction findTransactionByAccountId(long accountId);
	public Transaction findTransactionByCustomerId(long customerId);
	List<Transaction> findAllTransactionByCustomerId(long customerId);
}
