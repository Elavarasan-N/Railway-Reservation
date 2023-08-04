package com.edubridge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="admin_table")
public class Admin 
{	
	
	@Id
	@SequenceGenerator(name = "admin_seq", sequenceName = "admin_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(generator="admin_seq")
	@Column(name="adminId")
	private long adminId;
	
	@Column(name="firstName")
	@NotEmpty
	@Size(min=5,message="Name must contain atleast 5 characters")
	private String firstName;
	
	@Column(name="lastName")
	@NotEmpty
	@Size(min=5,message="Name must contain atleast 5 characters")
	private String lastName;
	
	@Column(name="email")
	@NotEmpty
	@Email(message="Email is not valid!")
	private String email;
	
	@Column(name="phoneNumber")
	@NotEmpty
	@Size(min=10,message="Phone Number must contain atleast 10 Numbers")
	private String phoneNumber;
	
	@Column(name="password")
	@NotEmpty
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	private String password;
	
	@Column(name="confirmPassword")
	@NotEmpty
	private String confirmPassword;

	public Admin() 
	{
		super();
	}

	public Admin(long adminId, String firstName, String lastName, String email, String phoneNumber, String password,String confirmPassword) 
	{
		super();
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
