package com.project.bean;

public class BillHistory {
	private int billId;             //to store bill_id of the generated bill
	private int productId;			//to store product_id of the products in the bill
	private int quantity;			//to store the quantity of the product bought
	private int discount;			//to store the discount given on the product
	private double productPrice;	//to store price of the product

	
	//constructors made of BillHistory class to be used for further processing:
	public BillHistory() {

	}

	public BillHistory(int billId, int productId, int quantity, int discount, double productPrice) {
		super();
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
		this.discount = discount;
		this.productPrice = productPrice;
	}

	
	//toString() method used to return all the above mentioned values:
	@Override
	public String toString() {
		return "BillHistory [billId=" + billId + ", productId=" + productId + ", quantity=" + quantity + ", discount="
				+ discount + ", productPrice=" + productPrice + "]";
	}

	
	
	//setters and getters for all the above mentioned fields: 
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

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}
