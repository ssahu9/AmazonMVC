package com.project.bean;

public class Category {
	
	private String CategoryName; 	//to store the name of the category
	
	//constructor made to be used for further processing
	public Category() {

	}

	//toString() method used to return the values of above mentioned parameter
	@Override
	public String toString() {
		return "Category [CategoryName=" + CategoryName + "]";
	}
	
	//setters and getters made for above mentioned attributes:
	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public Category(String categoryName) {
		super();
		CategoryName = categoryName;
	}

	

}
