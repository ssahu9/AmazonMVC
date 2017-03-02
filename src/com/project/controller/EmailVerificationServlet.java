package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.project.bean.Customer;

public class EmailVerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(EmailVerificationServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BasicConfigurator.configure();
 	    logger.info("email verification working!!");
 	    
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("customerObject");
		if(request.getParameter("email").equals(customer.getEmail()) && request.getParameter("phone").equals(customer.getPhoneNumber())) {
			request.getRequestDispatcher("ForgorPassword.jsp").forward(request, response);
		}
		else {
			out.println("Sorry, your details do no match. Please try again.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
