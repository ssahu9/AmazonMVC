package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.validation.Valid;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Customer;
import com.project.bean.User;
import com.project.bl.CustomerBl;
import com.project.validator.CustomerInsertGroup;

@Controller
public class Register  {
	
	private static Logger logger=Logger.getLogger(Register.class);
	
	@Autowired
	private CustomerBl customerBl ;

	@RequestMapping("/regForm")
	
	public String showRegisterform(ModelMap model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);	
		
		User user = new User(); 
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ModelAttribute("user")
	public String saveRegistration(@Validated(CustomerInsertGroup.class) Customer customer,
			BindingResult result, ModelMap model) {
		

		if (result.hasErrors()) {
			String url = "/regForm";
			//return	new ModelAndView("redirect:"+ url);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n>>>>>>>>>>>>>>>>>>>\n>>>>");
//			return "redirect:"+ url;
			return "register";
		}
		logger.info("register working!!");
		try {
			if (customerBl.signUp(customer) > 0) {
				model.addAttribute("user", new User());
			return "index";
		}
		} catch (ClassNotFoundException | SQLException e) {
			model.addAttribute("errorMessage", "Invalid Entry, please retry again");
			return("error404page");
		}
		model.addAttribute("user", new User());
		return "index";
	}

}
