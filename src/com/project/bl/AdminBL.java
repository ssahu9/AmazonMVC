package com.project.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Admin;
import com.project.bean.BillDetails;
import com.project.bean.Category;
import com.project.bean.Product;
import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;
import com.project.dao.BillDao;
import com.project.dao.BillDaoImpl;
import com.project.dao.CategoryDao;
import com.project.dao.CategoryDaoImpl;
import com.project.dao.ProductDao;
import com.project.dao.ProductDaoImpl;

public class AdminBL {

	private AdminDao admin1 = new AdminDaoImpl(); 			//new object of AdminDaoImpl created to be used for further functionality
	private ProductDao product1 = new ProductDaoImpl();		//new object of ProductDaoImpl created to be used for further functionality
	private BillDao bill1 = new BillDaoImpl();				//new object of BillDaoImpl created to be used for further functionality
	private CategoryDao category1 = new CategoryDaoImpl();	//new object of CategoryDaoImpl created to be used for further functionality

	
	
	//to check the email validation of admin using adminDaoImpl
	public boolean signIn(String email, String password) throws ClassNotFoundException, SQLException {
		
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		if (m.matches()) {
			return admin1.validation(email, password);
		} else
			System.out.println("email ID is not valid");

		return false;
	}

	
	// check password length of admin using adminDaoImpl
	public boolean updatePassword(Admin admin) throws SQLException, ClassNotFoundException {
		if ((admin.getPassword().length() < 8)) {
			System.out.println("Password needs to be atleast 8 character longer");
			return false;
		}
		return admin1.update(admin);
	}

	
	//function to call addCategory() method from CategoryDaoImpl
	public boolean addCategory(String categoryname) throws SQLException, ClassNotFoundException {
		return category1.insertCategory(categoryname);
	}

	//function to call viewCategory() method from CategoryDaoImpl
	public List<Category> viewCategory() throws ClassNotFoundException, SQLException {
		return category1.viewCategory();

	}

	
	//function to call deleteCategory() method from CategoryDaoImpl
	public boolean deleteCategory(String categoryname) throws SQLException, ClassNotFoundException {
		return category1.deleteCategory(categoryname);
	}

	//function to call addProduct() method from ProductDaoImpl
	public boolean addProduct(Product product) throws SQLException, ClassNotFoundException {
		return product1.addProduct(product);
	}

	//function to call viewProduct() method from ProductDaoImpl
	public List<Product> viewProduct(String pcategory) throws ClassNotFoundException, SQLException {
		return product1.viewProduct(pcategory);
	}

	//function to call updateProduct() method from ProductDaoImpl
	public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		return product1.updateProduct(product);

	}

	//function to call deleteProduct() method from ProductDaoImpl
	public Boolean deleteProduct(int pid) throws ClassNotFoundException, SQLException {
		return product1.deleteProduct(pid);
	}

	//function to call getAllBillDetails() method from BillDaoImpl
	public List<BillDetails> getAllBillDetails() throws SQLException, ClassNotFoundException {
		return bill1.getAllBillDetails();
	}
}
