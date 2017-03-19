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

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Bill;
import com.project.bean.BillDetails;
import com.project.bean.CartDetails;
import com.project.bean.Customer;
import com.project.bean.User;
import com.project.bl.CustomerBl;

@Controller

public class Placeorder  {
	
	private static Logger logger=Logger.getLogger(Placeorder.class);
	@Autowired
	private CustomerBl customerBl;
	@RequestMapping(value = "/placeOrder", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView placeOrder( HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		String email = (String) session.getAttribute("email");
		Customer customer = (Customer) session.getAttribute("customer");
		boolean status = false;
		if (email == null) {
			// Unauthorized user
			// redirect to index view
			mv.addObject("user", new User());
			mv.setViewName("index");
			return mv;
		}
		
		try {
			LinkedList<CartDetails> cartDetails = (LinkedList<CartDetails>) customerBl.viewCart(customer.getCustomerId());
			if(cartDetails==null){
				// bill will not generate as Cart is empty 
				// call error message
//				request.setAttribute("errorMessage", "Cart is empty");
//				request.getRequestDispatcher("error404page.jsp").forward(request, response);
			}
			else{
				
				Bill bill = null;

				bill = customerBl.generateBill(customer.getCustomerId());
				if(bill == null){
					// something went wrong
					// call error message
					
				}
				else{
					// bill generated successful 
					// display current bill
					
					List<BillDetails> list = customerBl.getCurrentBill(bill);
					
					mv.addObject("allBill", list);
					mv.addObject("user", new User());
					mv.setViewName("CustomerBillDetails");
					return mv;
					
					
					
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// call error page and display appropriate message
		}
		
		
		
		
		
		return mv;
	}
	
	
	
	
}
