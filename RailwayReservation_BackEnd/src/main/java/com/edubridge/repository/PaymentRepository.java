package com.edubridge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>
{
	public List<Payment> findByTrainId(long trainId);
	public Payment findByCustomerId(long customerId);
}