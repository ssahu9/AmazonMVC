package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.annotation.ApplicationScope;

import com.project.bean.Category;
import com.project.bean.Customer;
import com.project.bean.User;
import com.project.bl.CustomerBl;

@Controller
@RequestMapping("/")
@SessionAttributes({ "customer", "email" })
public class LoginServlet {
	private ServletContext servletContext;
	private CustomerBl customerBl = new CustomerBl();	
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap model, HttpServletRequest request) {
		this.servletContext = request.getServletContext();
		CustomerBl customerBl = new CustomerBl();
		ArrayList<Category> category = new ArrayList<Category>();
		Category category1 = new Category();
		category1.setCategoryName("Sports");
		 try {
		 category = (ArrayList<Category>) customerBl.viewCategory();
		 } catch (ClassNotFoundException | SQLException e) {
		
		 return "error404admin";
		 }

		User user = new User();
		model.addAttribute("user", user);
		category.add(category1);
		servletContext.setAttribute("demo", "demo apllcation scope");
		servletContext.setAttribute("categoryList", category);
		return "index";
	}


	@RequestMapping("/login")

	protected String login(ModelMap model, @ModelAttribute("user") User user) {

		Customer customer = new Customer();
		 //logger.info("Login working!!");
		
		if (user.getEmail().equals("admin@admin.com") && user.getPassword().equals("admin123")) {
			
			
		} else {
			try {
				customer = customerBl.signIn(user.getEmail(), user.getPassword());
				System.out.println(customer);

			} catch (ClassNotFoundException | SQLException e) {
				model.addAttribute("errorMessage", "<a href=\"index.jsp\">Invalid User, please retry again</a>");
				System.out.println(e);
				return ("index");

			}
			if (customer == null) { // login failed

				model.addAttribute("errorMessage", "<a href=\"index.jsp\">Invalid User, please retry again</a>");
				return ("error404page");

			} else { // customer login successful
				model.addAttribute("customer", customer);
				model.addAttribute("email", user.getEmail());
				
			}
		}
		return ("index");

	}
}

