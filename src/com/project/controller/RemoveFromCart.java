package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Customer;
import com.project.bl.CustomerBl;

public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String mail = (String) request.getAttribute("mail");
		if (mail == null) {
			request.setAttribute("errorMessage", "Please Login ");
			request.getRequestDispatcher("error404page.jsp").include(request, response);
		}
		Customer customer = (Customer) session.getAttribute("customerObject");
		response.setContentType("text/html");

		CustomerBl customerBl = new CustomerBl();
		int pid = Integer.parseInt(request.getParameter("pId"));

		try {
			customerBl.removeFromCart(pid, customer.getCustomerId());

		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorMessage", "Failed to Remove the product from the cart");
			request.getRequestDispatcher("error404page.jsp").include(request, response);
		}
		response.sendRedirect("CheckoutServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
