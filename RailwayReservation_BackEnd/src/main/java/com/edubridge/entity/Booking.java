package com.edubridge.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="booking_table")
public class Booking 
{
	@Id
	@SequenceGenerator(name = "booking_seq", sequenceName = "booking_seq", allocationSize = 1, initialValue = 5000)
	@GeneratedValue(generator="booking_seq")
	@Column(name="bookingId")
	private long bookingId;
	
	@Column(name="trainId")
	private long trainId;
	
	@Column(name="trainName")
	private String trainName;
	
	@Column(name="departureTime")
	private LocalDateTime departureTime;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="classType")
	private String classType;
	
	@Column(name="traveller")
	@NotNull
	private int traveller;
	
	@Column(name="trainPrice")
	private double trainPrice;
	
	@Column(name="bookedDate")
	private String bookedDate;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="customer_id")
	@JsonIgnore
    private Customer customer;

	public Booking() 
	{
		super();
	}

	public Booking(long bookingId, long trainId, String trainName,LocalDateTime departureTime, String firstName, String lastName, String classType,
		int traveller, double trainPrice, String bookedDate, Customer customer) {
		super();
		this.bookingId = bookingId;
		this.trainId = trainId;
		this.trainName = trainName;
		this.departureTime = departureTime;
		this.firstName = firstName;
		this.lastName = lastName;
		this.classType = classType;
		this.traveller = traveller;
		this.trainPrice = trainPrice;
		this.bookedDate = bookedDate;
		this.customer = customer;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
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

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
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

	public String getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getTraveller() {
		return traveller;
	}

	public void setTraveller(int traveller) {
		this.traveller = traveller;
	}
	
}
