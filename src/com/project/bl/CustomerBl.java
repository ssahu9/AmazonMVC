package com.project.bl;

import java.sql.SQLException;
import java.util.List;

import com.project.bean.Bill;
import com.project.bean.BillDetails;
import com.project.bean.Cart;
import com.project.bean.CartDetails;
import com.project.bean.Category;
import com.project.bean.Customer;
import com.project.bean.Product;
import com.project.dao.BillDao;
import com.project.dao.BillDaoImpl;
import com.project.dao.CartDao;
import com.project.dao.CartDaoImpl;
import com.project.dao.CategoryDao;
import com.project.dao.CategoryDaoImpl;
import com.project.dao.CustomerDao;
import com.project.dao.CustomerDaoImpl;
import com.project.dao.ProductDao;
import com.project.dao.ProductDaoImpl;

public class CustomerBl {

	private CustomerDao user = new CustomerDaoImpl();			//new object created of CustomerDaoImpl
	private CartDao cart = new CartDaoImpl();					//new object created of CartDaoImpl
	private CategoryDao category1 = new CategoryDaoImpl();		//new object created of CategoryDaoImpl
	private BillDao bill = new BillDaoImpl();					//new object created of BillDaoImpl
	private ProductDao product = new ProductDaoImpl();			//new object created of ProductDaoImpl

	
	//email validation for customer using signIn method in CustomerDaoImpl
	public Customer signIn(String email, String password) throws ClassNotFoundException, SQLException {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		if (m.matches()) {
			return user.validation(email, password);
		} else
			System.out.println("email ID is not valid");

		return null;

	}

	
	//password length check and email validation for customer signUp method in CustomerDaoImpl
	public int signUp(Customer customer) throws ClassNotFoundException, SQLException {

		if ((customer.getPassword().length() < 8)) {
			System.out.println("Password needs to be atleast 8 character longer");
			return 0;
		}
		if (customer.getPhoneNumber().contains("[a-zA-Z]+") == true || customer.getPhoneNumber().length() < 10) {
			System.out.println("Please check Phone Number");
			return 0;
		}
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(customer.getEmail());
		if (!m.matches()) {
			System.out.println("Invalid Email ID");
			return 0;
		}
		System.out.println(customer); // test
		return user.insert(customer);
	}

	
	//new function of updateDetails() method in CustomerDaoImpl
	public boolean updateDetails(Customer customer) throws ClassNotFoundException, SQLException {

		if ((customer.getPassword().length() < 8)) {
			System.out.println("Password needs to be atleast 8 character longer");
			return false;
		}
		if (customer.getPhoneNumber().contains("[a-zA-Z]+") == true || customer.getPhoneNumber().length() < 10) {
			System.out.println("Please check Phone Number");
			return false;
		}
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(customer.getEmail());
		if (!m.matches()) {
			System.out.println("Invalid Email ID");
			return false;
		}
		return user.update(customer);
	}

	
	//new function of viewCart() method in CartDaoImpl
	public List<CartDetails> viewCart(int customerId) throws ClassNotFoundException, SQLException {
		return cart.viewCart(customerId);
	}

	
	//new function of addToCart() method in CartDaoImpl
	public boolean addToCart(List<Cart> cartList) throws ClassNotFoundException, SQLException {

		return cart.addToCart(cartList);
	}

	
	//new function of removeFromCart() method in CartDaoImpl
	public boolean removeFromCart(int productId, int customerId) throws ClassNotFoundException, SQLException {
		return cart.removeFromCart(productId, customerId);
	}

	
	//new function of viewCategory() method in CategoryDaoImpl
	public List<Category> viewCategory() throws ClassNotFoundException, SQLException {
		return category1.viewCategory();
	}

	
	//new function of generateBill() method in BillDaoImpl
	public Bill generateBill(int customerId) throws ClassNotFoundException, SQLException {
		return bill.generateBill(customerId);
	}

	
	//new function of getBillDetails() method in BillDaoImpl
	public List<BillDetails> getBillDetails(int customerId) throws ClassNotFoundException, SQLException {
		return bill.getBillDetails(customerId);
	}

	
	//new function of getCurrentDetails() method in BillDaoImpl
	public List<BillDetails> getCurrentBill(Bill bill1) throws ClassNotFoundException, SQLException {
		return bill.getCurrentBill(bill1);
	}

	
	//new function of viewProduct() method in ProductDaoImpl
	public List<Product> viewProduct(String pcategory) throws ClassNotFoundException, SQLException {
		return product.viewProduct(pcategory);
	}

	
	//new function of searchProductByNames() method in ProductDaoImpl
	public Product searchProductByName(String productName) throws ClassNotFoundException, SQLException {
		return product.searchProductByName(productName);
	}

}
