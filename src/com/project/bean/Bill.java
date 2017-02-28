package com.project.bean;

import java.sql.Date;

public class Bill {
	private int customerId;  //store customer_id to generate bill details
	private int billId;      //to store bill_id
	private Date billDate;   //to generate and store the date of bill creation

	
	//constructors of the above mentioned class to be used for further processing
	public Bill() {

	}

	public Bill(int customerId, int billId, Date billDate) {
		this.customerId = customerId;
		this.billId = billId;
		this.billDate = billDate;
	}

	
	//setters and getters for above mentioned fields:
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Date getBillDate() {
		return billDate;
	}

	
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	
	
	//toString() method used to return the input values of above mentioned fields:
	@Override
	public String toString() {
		return "Bill [customerId=" + customerId + ", billId=" + billId + ", billDate=" + billDate + "]";
	}
}
