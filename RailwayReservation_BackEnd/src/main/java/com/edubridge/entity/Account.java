package com.edubridge.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="account_table")
public class Account 
{
	@Id
	@SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize = 1, initialValue = 62000000)
	@GeneratedValue(generator="account_seq")
	@Column(name="accountId")
	private long accountId; 
	
	@Column(name="customerId")
	private long customerId; 
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="email")
	private String email;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="gender")
	public String gender;
	
	@Column(name="phoneNumber")
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private String phoneNumber;
	
	@Column(name="district")
	@Size(min=3 , message="district must contain atleast 3 characters")
    private String district;
	
	@Column(name="state")
	@Size(min=3 , message="state must contain atleast 3 characters")
    private String state;
	
	@Column(name="pincode")
	@Size(min=6 ,max=6, message="Pincode must contain 6 digits")
	private String pincode;
	
	@CreationTimestamp
	@Column(name="CREATED_TIMESTAMP")
	private LocalDateTime createdTimeStamp;

	public Account() 
	{
		super();
	}

	public Account(long accountId,long customerId, double amount, String email, String firstName,String lastName,Date dateOfBirth,
			String gender, String phoneNumber, String district,String state, String pincode,LocalDateTime createdTimeStamp) 
	{
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.amount = amount;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.createdTimeStamp = createdTimeStamp;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountNumber) {
		this.accountId = accountNumber;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public LocalDateTime getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	
}
