  package com.project.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Cart;
import com.project.bean.Customer;
import com.project.bean.Product;
import com.project.bean.User;
import com.project.bl.CustomerBl;

@Controller
public class InsertIntoCart  {
	  @Autowired
	private CustomerBl customerBL ; 
	
	  @RequestMapping(value="/insertIntoCart",method = {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView insertIntoCart(@ModelAttribute( "cart") Cart cart, HttpSession session)
	  {
		  ModelAndView mv = new ModelAndView();
		  String email = (String)session.getAttribute("email");
		 
		  boolean status= false;
		  if(email== null){
			  // Unauthorized user
			  // redirect to index view
			  mv.addObject("user", new User());
			  mv.setViewName("error404page");
			  return mv;
		  }
		  else{
			  // continue to product insertion 
			  String	currentCategory=(String)session.getAttribute("currentCategory");  
			 
			  Customer customer = (Customer) session.getAttribute("customer");
			  long millis=System.currentTimeMillis();  
			  java.sql.Date date=new java.sql.Date(millis);
			  cart.setCartDate(date);
			  cart.setCustomerId(customer.getCustomerId());
			  ArrayList<Cart> cartList= new ArrayList<Cart>();
				cartList.add(cart);
				try {
					 status=customerBL.addToCart(cartList);
					 System.out.println(status);
				} catch (ClassNotFoundException | SQLException e) {
					  mv.addObject("user", new User());
					  mv.addObject("errorMessage", "Some internal error occured please try again!!!!");
					  mv.setViewName("error404page"); 	
		  }
				 if(status== true){
					// call get product controller
					String url = "/getProducts?category="+currentCategory;
				return	new ModelAndView("redirect:"+ url);
					 // response.sendRedirect("GetProducts?selectedCategory="+currentCategory);
									 }
				 else{
					  mv.addObject("user", new User());
					  mv.addObject("errorMessage", "Failed to save");
					  mv.setViewName("error404page"); 
				 }
		  }
		  return mv;
	  }
	  
	  
	
}
