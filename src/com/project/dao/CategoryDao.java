package com.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.project.bean.Category;
import com.project.bean.Product;

public interface CategoryDao {
	
	//viewCategory function linked to CategoryDaoImpl
	public List<Category> viewCategory() throws ClassNotFoundException, SQLException;

	//insertCategory function linked to CategoryDaoImpl
	public boolean insertCategory(String categoryname) throws SQLException, ClassNotFoundException;

	//deleteCategory function linked to CategoryDaoImpl
	public boolean deleteCategory(String categoryname) throws SQLException, ClassNotFoundException;

}
