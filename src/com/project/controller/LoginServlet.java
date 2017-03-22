package com.project.controller;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.ApplicationScope;

import com.project.bean.Category;
import com.project.bean.Customer;
import com.project.bean.User;
import com.project.bl.CustomerBl;

@Controller
@RequestMapping("/")
@SessionAttributes({ "customer", "email" , "admin" , "category" })

public class LoginServlet {
	private ServletContext servletContext;
	@Autowired
	private CustomerBl customerBl;	
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap model, HttpServletRequest request) {
		this.servletContext = request.getServletContext();
		//CustomerBl customerBl = new CustomerBl();
		ArrayList<Category> category = new ArrayList<Category>();
		Category category1 = new Category();
		category1.setCategoryName("Sports");
		 try {
		 category = (ArrayList<Category>) customerBl.viewCategory();
		 } catch (ClassNotFoundException | SQLException e) {
		
		 return "error404admin";
		 }
		 String demo="asasasas";
		User user = new User();
		model.addAttribute("user", user);
		category.add(category1);
		model.addAttribute("demo", "demo apllcation scope");
		
		servletContext.setAttribute("categoryList", category);
		return "index";
	}


	@RequestMapping("/login")

	protected String login(ModelMap model, @ModelAttribute("user") User user) {

		Customer customer = new Customer();
		 //logger.info("Login working!!");
		
		if (user.getEmail().equals("admin@admin.com") && user.getPassword().equals("admin123")) {
			model.addAttribute("admin", "admin");
			model.addAttribute("category", new Category());
			return "admin";
			
		} else {
			try {
				customer = customerBl.signIn(user.getEmail(), user.getPassword());
				System.out.println(customer);

			} catch (ClassNotFoundException | SQLException e) {
				model.addAttribute("errorMessage", "<a href=\"index.jsp\">Invalid User, please retry again</a>");
				System.out.println(e);
				User user2 = new User();
				model.addAttribute("user", user2);
				return ("index");

			}
			if (customer == null) { // login failed

				model.addAttribute("errorMessage", "<a href=\"index.jsp\">Invalid User, please retry again</a>");
				return ("error404page");

			} else { // customer login successful
				model.addAttribute("customer", customer);
				model.addAttribute("customer2", new Customer());
				model.addAttribute("email", user.getEmail());
				
			}
		}
		
		model.addAttribute("user", new User());
		return ("index");

	}
}

