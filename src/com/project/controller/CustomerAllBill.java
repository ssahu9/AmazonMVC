package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.BillDetails;
import com.project.bean.Customer;
import com.project.bl.CustomerBl;
public class CustomerAllBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CustomerBl customerBl = new CustomerBl();
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("customerObject");
		try {
			System.out.println("test test"+customer);
			LinkedList<BillDetails> billList = (LinkedList<BillDetails>)customerBl.getBillDetails(customer.getCustomerId());
			session.setAttribute("allBill", billList);
			request.getRequestDispatcher("CustomerBillDetails.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("errorMessage", "Unable to Process");
			request.getRequestDispatcher("error404admin.jsp").include(request, response);
		}
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
