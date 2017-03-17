package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.bean.Customer;
import com.project.bean.User;
import com.project.bl.CustomerBl;

@Controller
public class Register  {
	
	private static Logger logger=Logger.getLogger(Register.class);
	
	Customer customer = new Customer();
	CustomerBl customerBL = new CustomerBl();

	@RequestMapping("/regForm")
	/*@ModelAttribute("customer")*/
	public String showRegisterform(ModelMap model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);	
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ModelAttribute("user")
	public String saveRegistration(@Valid Customer customer,
			BindingResult result, ModelMap model) {
		

		if (result.hasErrors()) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>error");
			return "register";
		}
		logger.info("register working!!");
		try {
			if (customerBL.signUp(customer) > 0) {
				model.addAttribute("user", new User());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>Signup");
			return "index";
		}
		} catch (ClassNotFoundException | SQLException e) {
			model.addAttribute("errorMessage", "Invalid Entry, please retry again");
			return("error404page");
		}
		return "index";
	}
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();
 	    logger.info("register working!!");
 	    
		response.setContentType("text/html");

		
		String password1 = request.getParameter("pwd");
		String password2 = request.getParameter("rpwd");

		if (password1.equals(password2)) { // passwords match
			customer.setFirstName(request.getParameter("fname"));
			customer.setLastName(request.getParameter("lname"));
			customer.setEmail(request.getParameter("email"));
			customer.setPhoneNumber(request.getParameter("phone"));
			customer.setPassword(request.getParameter("pwd"));

			try {
				if (customerBL.signUp(customer) > 0) {
					request.getRequestDispatcher("index.jsp").include(request, response); // redirecting
																							// to
																							// index.jsp
				}
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("errorMessage", "Invalid Entry, please retry again");
				request.getRequestDispatcher("error404page.jsp").include(request, response);
			}
		} // register.jsp
		else {
			request.setAttribute("errorMessage", "Failed Registration.. go back to retry or go home");
			request.getRequestDispatcher("error404page.jsp").include(request, response);// redirecting
																						// to
																						// registerz.jsp
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
*/
}
