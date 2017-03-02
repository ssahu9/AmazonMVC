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

public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(ForgotPasswordServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
 	    logger.info("forgot password working!!");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		CustomerBl customerBL = new CustomerBl();
		
		if(request.getParameter("pwd").equals(request.getParameter("rpwd"))) {
			HttpSession session = request.getSession(false);
			Customer customer = (Customer) session.getAttribute("customerObject");
			customer.setPassword(request.getParameter("pwd"));
			try {
				customerBL.updateDetails(customer);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			out.println("Password change failed!");
			request.getRequestDispatcher("ForgotPassword.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
