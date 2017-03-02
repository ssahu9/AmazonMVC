package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.project.bean.Customer;
import com.project.bl.CustomerBl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(LoginServlet.class);
	
	CustomerBl customerBL = new CustomerBl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BasicConfigurator.configure();
 	    logger.info("Login working!!");
 	    
		response.setContentType("text/html");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (email.equals("admin@admin.com") || password.equals("admin123")) {
			HttpSession session = request.getSession(); // creating session
			session.setAttribute("email", email);
			
			// setting session attribute
			try {
				response.sendRedirect("admin.jsp");
				//request.getRequestDispatcher("admin.jsp").forward(request, response); // redirecting
																						// to
																						// admin.jsp
			} catch (IOException e) {
				//request.setAttribute("errorMessage", "Unsuccessful Admin Sign in");
				//request.getRequestDispatcher("error404admin.jsp").forward(request, response);
			
			}}
		Customer customer = null;
		try {
			customer = customerBL.signIn(email, password);
			System.out.println(customer);
		} catch (ClassNotFoundException | SQLException e) {
			//request.setAttribute("errorMessage", "Unsuccessful Sign in");
			//request.getRequestDispatcher("error404page.jsp").forward(request, response);
		}

		if (customer == null) { // login failed
			request.setAttribute("errorMessage", "Invalid User, please retry again");
			//request.getRequestDispatcher("error404page.jsp").forward(request, response);
		
		} else { // customer login successful
			HttpSession session = request.getSession(); // creating session
			session.setAttribute("email", email); // setting session attribute
			session.setAttribute("customerObject", customer); // setting
																// customer
																// object in
																// session scope
			try {
				request.getRequestDispatcher("index.jsp").forward(request, response); // redirecting
																						// to
																						// index.jsp
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
			//	request.setAttribute("errorMessage", "Unexpected Error");
				//request.getRequestDispatcher("error404page.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}