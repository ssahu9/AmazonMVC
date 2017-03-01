package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Bill;
import com.project.bean.BillDetails;
import com.project.bean.CartDetails;
import com.project.bean.Customer;
import com.project.bl.CustomerBl;
public class Placeorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerBl customerBL = new CustomerBl();
		
		HttpSession session = request.getSession(false);
		 String mail=(String)request.getAttribute("mail");
			if(mail==null){
				request.setAttribute("errorMessage", "Please Login ");
				request.getRequestDispatcher("error404page.jsp").include(request, response);
			}
		Customer customer = (Customer) session.getAttribute("customerObject");
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		
		try {
			LinkedList<CartDetails> cartDetails = (LinkedList<CartDetails>) customerBL.viewCart(customer.getCustomerId());
			if(cartDetails==null){
				// bill will not generate as Cart is empty 
				// call error message
				request.setAttribute("errorMessage", "Cart is empty");
				request.getRequestDispatcher("error404page.jsp").include(request, response);
			}
			else{
				
				Bill bill = null;
				System.out.println("customer id"+customer.getCustomerId());
				bill = customerBL.generateBill(customer.getCustomerId());
				if(bill == null){
					// something went wrong
					// call error message
					request.setAttribute("errorMessage", "Unable to Process bill");
					request.getRequestDispatcher("error404page.jsp").include(request, response);
					
					
				}
				else{
					// bill generated successful 
					// display current bill
					System.out.println("billllll"+bill);
					List<BillDetails> list = customerBL.getCurrentBill(bill);
					session.setAttribute("allBill", list);
					request.getRequestDispatcher("CustomerBillDetails.jsp").forward(request, response);
					
					
					
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
