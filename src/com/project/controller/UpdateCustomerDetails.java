package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Cart;
import com.project.bean.Customer;
import com.project.bean.User;
import com.project.bl.CustomerBl;

@Controller
public class UpdateCustomerDetails extends HttpServlet {

	@Autowired
	private CustomerBl customerBl;
	private static Logger logger = Logger.getLogger(UpdateCustomerDetails.class);

	@RequestMapping("/updateForm")
	public String showRegisterform(ModelMap model) {
		Customer customer2 = new Customer();
		model.addAttribute("customer2", customer2);
		return "UpdateCustomerProfile";
	}

	@RequestMapping(value = "/updateCustomerProfile", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView updateProfile(@ModelAttribute("customer2") Customer customer2, HttpSession session) {
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

		customer.setFirstName(customer2.getFirstName());
		customer.setLastName(customer2.getLastName());
		customer.setPassword(customer2.getPassword());
		customer.setPhoneNumber(customer2.getPhoneNumber());
		try {
			status = customerBl.updateDetails(customer);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (status == true) {
			mv.addObject("user", new User());
			mv.setViewName("index");
			return mv;

		} else {
			// call error page
		}
		return null;
	}

}
