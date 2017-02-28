package com.project.bean;

import java.sql.Date;

public class Cart {
	private int customerId;		//to store the customer_id whose cart is being used
	private int productId;		//to store the product_id of the product in the cart
	private int quantity;		//to store the quantity of the product in the cart
	private Date cartDate;		//to store the date on which cart was created 

	
	//constructors:to be used for further processing
	public Cart() {

	}

	
	public Cart(int customerId, int productId, int quantity, Date cartDate) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.cartDate = cartDate;
	}
	
	
	//toString() method used to return the above mentioned values: 
	@Override
	public String toString() {
		return "Cart [customerId=" + customerId + ", productId=" + productId + ", quantity=" + quantity + ", cartDate="
				+ cartDate + "]";
	}

	
	//setters and getters for above mentioned attributes:
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCartDate() {
		return cartDate;
	}

	public void setCartDate(Date date) {
		this.cartDate = date;
	}

}
