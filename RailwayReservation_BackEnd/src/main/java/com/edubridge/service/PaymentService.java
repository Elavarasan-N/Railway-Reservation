package com.edubridge.service;

import java.util.List;

import com.edubridge.entity.Payment;

public interface PaymentService 
{
	Payment addPayment(Payment payment,long trainId,long customerId, long bookingId);
	List<Payment> getAllPayment();
	Payment getPaymentById(long paymentId);
	void deletePayment(long paymentId);
	public List<Payment> getAllPaymentBytrainId(long trainId);
	Payment getPaymentByCustomerId(long customerId);
}
