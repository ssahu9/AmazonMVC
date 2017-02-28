package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.Customer;
import com.project.bl.CustomerBl;



public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Customer customer = new Customer();
	CustomerBl customerBL = new CustomerBl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String password1 = request.getParameter("pwd");
		String password2 = request.getParameter("rpwd");
		
			if(password1.equals(password2)) { // passwords match 
				customer.setFirstName(request.getParameter("fname"));
				customer.setLastName(request.getParameter("lname"));
				customer.setEmail(request.getParameter("email"));
				customer.setPhoneNumber(request.getParameter("phone"));
				customer.setPassword(request.getParameter("pwd"));
				request.getRequestDispatcher("index.jsp").include(request, response); // redirecting to index.jsp
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
