package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Customer;
import com.project.bean.Product;
import com.project.bean.User;
import com.project.bl.CustomerBl;

@Controller
public class RemoveFromCart extends HttpServlet {

	@Autowired
	private CustomerBl customerBl;
	private static Logger logger = Logger.getLogger(RemoveFromCart.class);

	@RequestMapping(value = "/removeFromCart", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView removeFromCart(@ModelAttribute("product") Product product, HttpSession session) {
		BasicConfigurator.configure();
		logger.info("remove from cart working!!");
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
			customerBl.removeFromCart(product.getProductId(), customer.getCustomerId());
			String url = "/checkout";
			return new ModelAndView("redirect:" + url);
		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
			// TODO Auto-generated catch block
			/*
			 * request.setAttribute("errorMessage",
			 * "Failed to Remove the product from the cart");
			 * request.getRequestDispatcher("error404page.jsp").include(request,
			 * response);
			 */
		}
		
return null;
	}

}
