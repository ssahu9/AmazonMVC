package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Category;
import com.project.bean.Product;
import com.project.helper.CreateConnection;

public class CategoryDaoImpl implements CategoryDao {
//	CreateConnection cd = new CreateConnection();
	Connection con = null;
	PreparedStatement pstmt = null;
	Category category = null;

	
	//view category function made for customers to view all categories
	public List<Category> viewCategory() throws SQLException, ClassNotFoundException {

		List<Category> categoryList = new ArrayList<Category>();
		con = CreateConnection.getCon();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from category");
		while (rs.next()) {
			String categoryname = rs.getString("category_name");
			category = new Category();
			category.setCategoryName(categoryname);
			categoryList.add(category);

		}
		con.close();
		// return null;
		return categoryList;
	}

	
	//function to insert new category used by admin
	@Override
	public boolean insertCategory(String categoryname) throws SQLException, ClassNotFoundException {
		con = CreateConnection.getCon();
		pstmt = con.prepareStatement("insert into category values(?)");

		pstmt.setString(1, categoryname);
		int rows = pstmt.executeUpdate();
		con.close();
		if (rows > 0) {
			return true;
		}
		return false;
	}

	//function to delete pre-existing category used by admin
	@Override
	public boolean deleteCategory(String categoryname) throws SQLException, ClassNotFoundException {
	
		con = CreateConnection.getCon();
		pstmt = con.prepareStatement("delete from category where category_name=?");
		pstmt.setString(1, categoryname);

		int rows = pstmt.executeUpdate();
		if (rows > 0) {
			return true;
		}
		return false;

	}

}
