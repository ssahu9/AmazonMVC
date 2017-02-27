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

import javafx.scene.control.Alert;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Customer customer = new Customer();
	CustomerBl customerBL = new CustomerBl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String password1 = request.getParameter("pwd");
		String password2 = request.getParameter("rpwd");
		int customer2 = 0;
		
		try {
			customer2 = customerBL.signUp(customer);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if(customer2 == 0) {
			out.print("Sorry, you could not be registered!");
			request.getRequestDispatcher("index.jsp").include(request, response); // redirecting to index.jsp
		}
		else if(password1.equals(password2)) {
			out.println("You have registered successfully, "+customer.getFirstName()+"!");
			request.getRequestDispatcher("index.jsp").forward(request, response); // redirecting to index.jsp
		}
		else if(!password1.equals(password2)) {
			out.println("Passwords do not match!"); // password mismatch
			request.getRequestDispatcher("index.jsp").include(request, response); // redirecting to index.jsp
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
