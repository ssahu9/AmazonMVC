package com.project.dao;

import java.sql.SQLException;

import com.project.bean.Customer;

public interface CustomerDao {

	//insert function linked to CustomerDaoImpl to insert customer information
	int insert(Customer customer) throws ClassNotFoundException, SQLException;

	//validation function linked to CustomerDaoImpl to check email and password
	Customer validation(String mail, String password) throws ClassNotFoundException, SQLException;

	//update function linked to CustomerDaoImpl to update customer details
	boolean update(Customer customer) throws ClassNotFoundException, SQLException;

}
