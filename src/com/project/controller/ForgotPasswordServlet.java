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
import com.sun.xml.internal.ws.resources.HttpserverMessages;

public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
