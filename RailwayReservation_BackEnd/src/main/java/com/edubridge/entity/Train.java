package com.edubridge.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="train_table")
public class Train {
	
	@Id
	@SequenceGenerator(name = "train_seq", sequenceName = "train_seq", allocationSize = 1, initialValue = 2000)
	@GeneratedValue(generator="train_seq")
	@Column(name="trainId")
	private long trainId;
	
	@Column(name="trainImage")
	@NotEmpty
	private String trainImage;
	
	@Column(name="trainName")
	@NotEmpty
	@Size(min=5 , message="Train Name must contain atleast 5 characters")
	private String trainName;
	
	@Column(name="source")
	@NotEmpty
	@Size(min=5, message="Source must contain atleast 5 characters")
	private String source;
	
	@Column(name="destination")
	@NotEmpty
	@Size(min=5, message="destination must contain atleast 5 characters")
	private String destination;
	
	@Column(name="arrivalTime")
	@NotNull
	private LocalDateTime arrivalTime;
	
	@Column(name="departureTime")
	@NotNull
	private LocalDateTime departureTime;
	
	@Column(name="distance")
	private double distance;
	
	@Column(name="classType")
	@NotEmpty
	private String classType;
	
	@Column(name="totalSeats")
	@NotNull
	private int totalSeats;
	
	@Column(name="availableSeats")
	@NotNull
	private int availableSeats;
	
	@Column(name="trainPrice")
	@NotNull
	private double trainPrice;
	
	public Train() 
	{
		super();
	}

	public Train(String trainImage, long trainId,String trainName,String source,String destination,LocalDateTime arrivalTime,LocalDateTime departureTime, double distance,String classType,int totalSeats,int availableSeats, double trainPrice) 
	{
		super();
		this.trainImage = trainImage;
		this.trainId = trainId;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.distance = distance;
		this.classType = classType;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.trainPrice = trainPrice;
	}



	public String getTrainImage() {
		return trainImage;
	}

	public void setTrainImage(String trainImage) {
		this.trainImage = trainImage;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public double getTrainPrice() {
		return trainPrice;
	}

	public void setTrainPrice(double trainPrice) {
		this.trainPrice = trainPrice;
	}
	
}