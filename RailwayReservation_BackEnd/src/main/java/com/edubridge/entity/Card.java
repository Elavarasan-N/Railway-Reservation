package com.edubridge.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="card")
public class Card 
{
	@Id
	@SequenceGenerator(name = "card_seq", sequenceName = "card_seq", allocationSize = 1, initialValue = 6000)
	@GeneratedValue(generator="card_seq")
	@Column(name="cardId")
	private long cardId;
	
	@Column(name="nameOnCard")
	@NotEmpty
	@Size(min=3 , message="Name must contain atleast 3 characters")
	private String nameOnCard;
	
	@Column(name="cardNumber")
	@NotEmpty
	@Size(min=16 , max=16,message="Card Number must contain 16 digits")
	private String cardNumber;
	
	@Column(name="expYear")
	private String expYear;
	
	@Column(name="cvv")
	@NotNull
	private int cvv;
	
	@Column(name="money")
	@NotNull
	private double money;
	
	@CreationTimestamp
	@Column(name="CREATED_TIMESTAMP")
	private LocalDateTime createdTimeStamp;

	public Card() 
	{
		super();
	}

	public Card(long cardId, String nameOnCard,String cardNumber,
			String expYear,int cvv,double money,LocalDateTime createdTimeStamp) {
		super();
		this.cardId = cardId;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expYear = expYear;
		this.cvv = cvv;
		this.money = money;
		this.createdTimeStamp = createdTimeStamp;
	}

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public LocalDateTime getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	
}
