package com.project.bean;

import java.sql.Date;

public class CartDetails {
	private int productId;			//to store product_id of the products of the cart
	private String productName;		//to store the product_name of the products in the cart
	private double price;			//to store the price of the products in the cart
	private int quantity;			//to store the quantity of the products in the cart
	private int discount;			//to store the discount given on the products in the cart
	private double totalPrice;		//to store the total_price of all the products stored in the cart
	private String category;		//to store the category of each product in the cart to which they belong 
	private Date date;				//to store the date when the cart was created

	
	//constructors made to be used for further processing
	public CartDetails() {

	}

	public CartDetails(int productId, String productName, double price, int quantity, int discount, double totalPrice,
			String category, Date date) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
		this.totalPrice = totalPrice;
		this.category = category;
		this.date = date;
	}

	//toString() method used to return the values od above mentioned parameters:
	@Override
	public String toString() {
		return "CartDetails [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + ", discount=" + discount + ", totalPrice=" + totalPrice + ", category="
				+ category + ", date=" + date + "]";
	}

	
	
	//setters and getters for the above mentioned parameters:
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
