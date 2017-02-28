package com.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.project.bean.Product;

public interface ProductDao {
	
	//addProduct function linked to ProductDaoImpl 
	boolean addProduct(Product p) throws SQLException, ClassNotFoundException;

	//deleteProduct function linked to ProductDaoImpl 
	Boolean deleteProduct(int pid) throws ClassNotFoundException, SQLException;

	//updateProduct function linked to ProductDaoImpl 
	boolean updateProduct(Product p) throws ClassNotFoundException, SQLException;

	//viewProduct function linked to ProductDaoImpl 
	List<Product> viewProduct(String category) throws ClassNotFoundException, SQLException;

	//searchProductByName function linked to ProductDaoImpl 
	Product searchProductByName(String product) throws ClassNotFoundException, SQLException;

}
