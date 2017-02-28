package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bl.CustomerBl;

public class SearchProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	String pName;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = null;
		
		HttpSession session = request.getSession(false);
		
		
		if (session != null){
			
		String productName = request.getParameter("name");
		
		 pName=productName.toUpperCase();
		
		CustomerBl customerBl = new CustomerBl();
		try{
	      customerBl.searchProductByName(productName);
		}
		catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		request.setAttribute("productName",pName);
		request.getRequestDispatcher("SearchProduct.jsp").include(request, response);
		}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
