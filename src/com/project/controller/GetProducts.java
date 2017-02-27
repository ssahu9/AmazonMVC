package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.Category;
import com.project.bean.Product;
import com.project.bl.CustomerBl;


public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CustomerBl customerBl = new CustomerBl();
		ArrayList<Product> proList =null;
		try {
		String	pcategory =request.getParameter("selectedCategory");
			proList = (ArrayList<Product>)customerBl.viewProduct(pcategory);
			System.out.println(proList);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productList",proList);
		request.getRequestDispatcher("women.jsp").include(request, response);

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
