package com.project.bean;
import org.hibernate.validator.constraints.Email;

import org.hibernate.validator.constraints.NotEmpty;

import com.project.validator.Phone;

public class Customer {
	
	private int customerId;			//to store the customer_id (auto-generated)
	@NotEmpty
	private String firstName;
	//to store the first name of the customer
	@NotEmpty
	private String lastName;		//to store the last name of the customer
	@Email
	private String email;			//to store the email address of customer(username==email)
	@NotEmpty
	private String password;		//to store the password which the customer has entered

	@NotEmpty
	@Phone
	private String phoneNumber;		//to store the phone number of the customer

	
	//constructors made to be used for further processing
	public Customer() {
		

	}

	public Customer(int customerId, String firstName, String lastName, String email, String password,
			String phoneNumber) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	//toString() method used to return all the values of above mentioned parameters:
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	//setters and getters for above mentioned attributes:
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

}
