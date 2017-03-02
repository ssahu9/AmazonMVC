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

public class UpdateCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(UpdateCustomerDetails.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();
 	    logger.info("update customer details working!!");
		
		response.setContentType("text/html");
		PrintWriter out = null;

		HttpSession session = request.getSession(false);
		if (session == null){
			request.setAttribute("errorMessage", "Sign in first");
			request.getRequestDispatcher("error404page.jsp").include(request, response);
		}
		Customer customer = new Customer();
		Customer customer2 = (Customer) session.getAttribute("customerObject");
		String password = request.getParameter("pwd");
		String rpassword = request.getParameter("rpwd");
		if (password.equals(rpassword)) {
			customer.setPassword(rpassword);
			String lastName = request.getParameter("lname");
			customer.setLastName(lastName);
			String firstName = request.getParameter("fname");
			customer.setFirstName(firstName);
			String phoneNo = request.getParameter("phone");
			customer.setPhoneNumber(phoneNo);
			String email= customer2.getEmail();
			customer.setEmail(email);
			int id=customer2.getCustomerId();
			customer.setCustomerId(id);
			CustomerBl customerBl = new CustomerBl();
			
			try {
			customerBl.updateDetails(customer);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("errorMessage", "Unable to update");
				request.getRequestDispatcher("error404page.jsp").include(request, response);
			}
		} else {
			
			request.getRequestDispatcher("UpdateCutomerProfile.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
