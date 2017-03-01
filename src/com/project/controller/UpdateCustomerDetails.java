package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Customer;
import com.project.bl.CustomerBl;

public class UpdateCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = null;

		HttpSession session = request.getSession(false);
		if (session == null){
			request.setAttribute("errorMessage", "Sign in first");
			request.getRequestDispatcher("error404page.jsp").include(request, response);
		}
		Customer customer = (Customer) session.getAttribute("customerObject");
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
			CustomerBl customerBl = new CustomerBl();
			try {
				customerBl.updateDetails(customer);
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
