package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.project.bean.BillDetails;
import com.project.bean.Customer;
import com.project.bl.CustomerBl;

public class CustomerAllBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(CustomerAllBill.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BasicConfigurator.configure();
 	    logger.info("customer all bill working!!");
 	    
		HttpSession session = request.getSession(false);
		String mail=(String)session.getAttribute("email");
		if (mail == null) {
			request.setAttribute("errorMessage", "Please Login ");
			request.getRequestDispatcher("error404page.jsp").forward(request, response);
		}
		CustomerBl customerBl = new CustomerBl();
		Customer customer = (Customer) session.getAttribute("customerObject");
		try {
			System.out.println("test test" + customer);
			LinkedList<BillDetails> billList = (LinkedList<BillDetails>) customerBl
					.getBillDetails(customer.getCustomerId());
			session.setAttribute("allBill", billList);
			request.getRequestDispatcher("CustomerBillDetails.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("errorMessage", "Unable to Process");
			request.getRequestDispatcher("error404admin.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
