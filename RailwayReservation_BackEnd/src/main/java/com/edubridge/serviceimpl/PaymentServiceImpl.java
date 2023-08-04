package com.edubridge.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.entity.Customer;
import com.edubridge.entity.Payment;
import com.edubridge.entity.Train;
import com.edubridge.exception.PaymentNotFoundException;
import com.edubridge.repository.PaymentRepository;
import com.edubridge.service.CustomerService;
import com.edubridge.service.PaymentService;
import com.edubridge.service.TrainService;

@Service
public class PaymentServiceImpl implements PaymentService 
{
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private TrainService trainService;
	
	@Autowired
	private CustomerService customerService;

	@Override
	public Payment addPayment(Payment payment, long trainId, long customerId, long bookingId) 
	{
		Train train = trainService.getTrainById(trainId);
		payment.setTrainId(train.getTrainId());
		payment.setTrainName(train.getTrainName());
		payment.setTrainPrice(train.getTrainPrice());
		payment.setClassType(train.getClassType());
		Customer customer=customerService.getCustomerById(customerId);
		payment.setCustomerId(customer.getCustomerId());
		payment.setFirstName(customer.getFirstName());
		payment.setLastName(customer.getLastName());
		payment.setEmail(customer.getEmail());
		payment.setDistrict(customer.getDistrict());
		payment.setState(customer.getState());	
		payment.setPincode(customer.getPincode());
		payment.setCustomer(customer);
        return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getAllPayment() 
	{
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(long paymentId) 
	{
		return paymentRepository.findById(paymentId).orElseThrow(()->new PaymentNotFoundException("Payment","paymentId",paymentId));
	}

	@Override
	public void deletePayment(long paymentId) 
	{	
		paymentRepository.findById(paymentId).orElseThrow(()->new PaymentNotFoundException("Payment","paymentId",paymentId));
		paymentRepository.deleteById(paymentId);
	}

	@Override
	public List<Payment> getAllPaymentBytrainId(long trainId) 
	{
		return paymentRepository.findByTrainId(trainId);
	}

	@Override
	public Payment getPaymentByCustomerId(long customerId) 
	{
		return paymentRepository.findByCustomerId(customerId);
	}

}
