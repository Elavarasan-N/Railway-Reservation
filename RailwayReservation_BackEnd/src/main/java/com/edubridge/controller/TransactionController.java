package com.edubridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.entity.Transaction;
import com.edubridge.service.CardService;
import com.edubridge.service.TransactionService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/transaction")
public class TransactionController 
{
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/{customerId}/{accountId}")
	public ResponseEntity<Transaction> addtransaction(@PathVariable long accountId,@PathVariable long customerId,@RequestBody  Transaction transaction)
	{
		return new ResponseEntity<Transaction>(transactionService.addtransaction(transaction,accountId,customerId),HttpStatus.CREATED);
	}
	
	@GetMapping("/{transactionId}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable("transactionId") long transactionId)
	{
		return new ResponseEntity<Transaction>(transactionService.getTransactionById(transactionId),HttpStatus.OK);
	}
	
	@GetMapping("/account/{accountId}")
	public ResponseEntity<Transaction> getTransactionByAccountId(@PathVariable("accountId") long accountId)
	{
		return new ResponseEntity<Transaction>(transactionService.getTransactionByAccountId(accountId),HttpStatus.OK);
	}
	
	/*@GetMapping("/customer/{customerId}")
	public ResponseEntity<Transaction> getTransactionByCustomerId(@PathVariable("customerId") long customerId)
	{
		return new ResponseEntity<Transaction>(transactionService.getTransactionByCustomerId(customerId),HttpStatus.OK);
	}*/
	
	@GetMapping("/customer/{customerId}")
	public List<Transaction> getTransactionByCustomerId(@PathVariable("customerId") long customerId)
	{
		return transactionService.getTransactionByCustomerId(customerId);
	}
	
}
