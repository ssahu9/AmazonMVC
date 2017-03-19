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

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.CartDetails;
import com.project.bean.Category;
import com.project.bean.Customer;
import com.project.bean.Product;
import com.project.bean.User;
import com.project.bl.CustomerBl;

@Controller

@SessionAttributes("cartList")
public class CheckoutServlet {
	@Autowired
	private CustomerBl customerBl;
	private static Logger logger = Logger.getLogger(CheckoutServlet.class);

	@RequestMapping(value = "/checkout", method = { RequestMethod.GET, RequestMethod.POST })
	
	public ModelAndView checkout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String email = (String) session.getAttribute("email");
		boolean status = false;
		if (email == null) {
			// Unauthorized user
			// redirect to index view
			mv.addObject("user", new User());
			mv.setViewName("index");
			return mv;
		}
		LinkedList<CartDetails> cartDetails = null;
		Customer customer = (Customer) session.getAttribute("customer");
		try {
			cartDetails = (LinkedList<CartDetails>) customerBl.viewCart(customer.getCustomerId());
			mv.addObject("product", new Product());
			System.out.println(cartDetails);
			mv.addObject("cartList", cartDetails);
			mv.setViewName("checkout");
		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
			// call error page and display appropriate message
			// request.setAttribute("errorMessage", "Unable to checkout");
			// request.getRequestDispatcher("error404page.jsp").forward(request,
			// response);
		}
		return mv;
	}

}
