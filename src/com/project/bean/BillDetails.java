package com.project.bean;

import java.sql.Date;

public class BillDetails {
	private int customerId;     //to store customer_id
	private int billId;         //to store bill_id
	private int productId;      //to store product_id
	private double price;       //to store the price of the product
	private int discount;       //to store the discount for each product
	private int quantity;       //to store the quantity of the product purchased
	private double totalPrice;  //to store the total price of all the products purchased
	private Date date;          //to store the date on which bill is generated

	//toString() method used to return the values of the above mentioned fields:
	@Override
	public String toString() {
		return "BillDetails [customerId=" + customerId + ", billId=" + billId + ", productId=" + productId + ", price="
				+ price + ", discount=" + discount + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", date="
				+ date + "]";
	}
	
	//setters and getters for the above mentioned fields:

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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
