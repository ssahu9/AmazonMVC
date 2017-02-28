package com.project.bean;

public class Product {
	private int productId;		//to store the product_id of the product
	private String name;		//to store the name of the product
	private String category;	//to store the name of the category to which the product belongs
	private double price;		//to store the price of the product
	private int quantity;		//to store the quantity of the product available
	private int discount;		//to store the discount given on the product

	
	//constructors made to be used for further processing
	public Product() {

	}

	public Product(int productId, String name, String category, double price, int quantity, int discount) {
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
	}

	
	//toString() method used to return the values of the above mentioned attributes:
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + ", discount=" + discount + "]";
	}
	
	
	//setters and getters for above mentioned attributes
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	

}
