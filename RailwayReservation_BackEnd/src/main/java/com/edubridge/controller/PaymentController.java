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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.entity.Payment;
import com.edubridge.service.PaymentService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/payment")
public class PaymentController 
{
	
	@Autowired
	private PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) 
	{
	super();
	this.paymentService = paymentService;	
	}
	
	//making payment
	@PostMapping("{trainId}/{customerId}/{bookingId}")
	public ResponseEntity<Payment> addPayment( @RequestBody Payment payment,@PathVariable long trainId,@PathVariable long customerId,@PathVariable long bookingId)
	{
		return new ResponseEntity<Payment>(paymentService.addPayment(payment,trainId,customerId,bookingId),HttpStatus.CREATED);
	}
	
	//getting list of payments
	@GetMapping("/payments")
	public List<Payment> getAllPayment()
	{
		return paymentService.getAllPayment();
	}

	//to get payment by payment id(for receipt)
	@GetMapping("{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") long paymentId)
	{
		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId),HttpStatus.OK);
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Payment> getPaymentByCustomerId(@PathVariable("customerId") long customerId)
	{
		return new ResponseEntity<Payment>(paymentService.getPaymentByCustomerId(customerId),HttpStatus.OK);
	}
	
	// to delete payment
	@DeleteMapping("{paymentId}")
	public ResponseEntity<Boolean> deletePayment(@PathVariable("paymentId") long paymentId)
	{
		paymentService.deletePayment(paymentId);
		boolean flag=true;
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
	}
}