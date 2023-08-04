package com.edubridge.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.resource.transaction.spi.TransactionStatus;

@Entity
@Table(name="transaction_table")
public class Transaction 
{
	@Id
	@SequenceGenerator(name = "transaction_seq", sequenceName = "transaction_seq", allocationSize = 1, initialValue = 12000000)
	@GeneratedValue(generator="transaction_seq")
	@Column(name="transactionId")
	private Long transactionId;
	
	@Column(name="accountId")
	private Long accountId;
	
	@Column(name="customerId")
	private Long customerId;
	
	@Column(name = "amount")
	private Double amount;
	
	@CreationTimestamp
	@Column(name="transactionDateTime")
	private LocalDateTime transactionDateTime;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "info")
	private String info;
	
	@Column(name = "paymentType")
	private String paymentType;
	
	@Column(name="pointsEarned")
	private Integer pointsEarned;
	
	@Column(name="redeemed")
	private Character redeemed;

	//@Enumerated(EnumType.STRING)
	@Column(name = "transactionStatus")
	private String transactionStatus;

	public Transaction() 
	{
		super();
	}

	public Transaction(Long transactionId,Long accountId,Long customerId, Double amount, LocalDateTime transactionDateTime, String remarks,
			String info, Integer pointsEarned, Character redeemed,String paymentType, String transactionStatus) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.customerId = customerId;
		this.amount = amount;
		this.transactionDateTime = transactionDateTime;
		this.remarks = remarks;
		this.info = info;
		this.pointsEarned = pointsEarned;
		this.redeemed = redeemed;
		this.paymentType = paymentType;
		this.transactionStatus = transactionStatus;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(Integer pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public Character getRedeemed() {
		return redeemed;
	}

	public void setRedeemed(Character redeemed) {
		this.redeemed = redeemed;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
