package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.CartDetails;
import com.project.bean.Category;
import com.project.bean.Customer;
import com.project.bl.CustomerBl;


public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false); 
		
		response.setContentType("text/html");
		CustomerBl customerBl = new CustomerBl();
			LinkedList<CartDetails> cartDetails = null;
		Customer customer=(Customer)session.getAttribute("customerObject");
		try {
			cartDetails = (LinkedList<CartDetails>) customerBl.viewCart(customer.getCustomerId());
			System.out.println(cartDetails);

		} catch (ClassNotFoundException | SQLException |NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("null pointer error");
			e.printStackTrace();
		}
		
		session.setAttribute("cartList",cartDetails);

		response.sendRedirect("checkout.jsp");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
