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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Cart;
import com.project.bean.Customer;
import com.project.bean.Product;
import com.project.bl.CustomerBl;

@Controller
public class ProductDetails  {
	
@RequestMapping(value="/ProductDetails",  method = {RequestMethod.GET, RequestMethod.POST})
@ModelAttribute("pname")
public ModelAndView getProductDetails(@ModelAttribute("product2")Product product2){
	ModelAndView mv = new ModelAndView();
	Product product = new Product();
	CustomerBl customerBL = new CustomerBl();
	try {
		product=customerBL.searchProductByName(product2.getName());
		
	} catch (ClassNotFoundException | SQLException e) {
	// call Error display View	
	
	}
	 if(product!=null){
		 mv.addObject("pname", product);
		 mv.addObject("cart", new Cart());
		 mv.setViewName("details");
		 return mv;
	 }
	 else{
		 // call error message 
	 }

	
	return null;
}
	
	
	
       
	
}
