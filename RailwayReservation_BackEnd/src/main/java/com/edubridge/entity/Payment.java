package com.edubridge.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="payment_table")
public class Payment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long paymentId;
	
	@Column(name="customerId")
	private long customerId;
		
	@Column(name="trainId")
	private long trainId;
	
	@Column(name="trainName")
	private String trainName;
	
	@Column(name="classType")
	private String classType;
	
	@Column(name="trainPrice")
	private double trainPrice;
	
	@Column(name="totalPrice")
	private  double totalPrice;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="district")
	private String district;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="email")
	public String email;
	
	@Column(name="nameOnCard")
	@Size(min=3 , message="Name must contain atleast 3 characters")
	private String nameOnCard;
	
	@Column(name="cardNumber")
	@Size(min=16 , max=16,message="Card Number must contain 16 digits")
	private String cardNumber;
	
	@Column(name="expYear")
	private String expYear;
	
	@Column(name="cvv")
	@NotNull
	private int cvv;
	
	@Column(name="paidDate")
	private String paidDate;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="customer__id")
	@JsonIgnore
	private Customer customer;

	public Payment() 
	{
		super();
	}

	public Payment(long paymentId,long customerId, long trainId,String trainName, String classType, double trainPrice, double totalPrice, String firstName,
			String lastName, String district, String state, String pincode, String email,String nameOnCard, String cardNumber,
			String expYear, int cvv, String paidDate, Customer customer) 
	{
		super();
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.trainId = trainId;
		this.trainName = trainName;
		this.classType = classType;
		this.trainPrice = trainPrice;
		this.totalPrice = totalPrice;
		this.firstName = firstName;
		this.lastName = lastName;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.email = email;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expYear = expYear;
		this.cvv = cvv;
		this.paidDate = paidDate;
		this.customer = customer;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public double getTrainPrice() {
		return trainPrice;
	}

	public void setTrainPrice(double trainPrice) {
		this.trainPrice = trainPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
