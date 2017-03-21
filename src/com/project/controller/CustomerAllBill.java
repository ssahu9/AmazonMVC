package com.project.controller;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.BillDetails;
import com.project.bean.Customer;
import com.project.bean.User;
import com.project.bl.CustomerBl;

@Controller
public class CustomerAllBill {

	@Autowired
	private CustomerBl customerBl;
	private static Logger logger = Logger.getLogger(CustomerAllBill.class);

	@RequestMapping(value = "/getAllBill", method = { RequestMethod.GET, RequestMethod.POST })

	public ModelAndView allBill(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String email = (String) session.getAttribute("email");
		Customer customer = (Customer) session.getAttribute("customer");
		boolean status = false;
		if (email == null) {
			 mv.addObject("user", new User());
			  mv.addObject("errorMessage", "please Login");
			  mv.setViewName("error404page");			
			  return mv;
		}

		try {

			LinkedList<BillDetails> list = (LinkedList<BillDetails>) customerBl
					.getBillDetails(customer.getCustomerId());

			mv.addObject("allBill", list);
			mv.setViewName("CustomerBillDetails");
			return mv;

		} catch (ClassNotFoundException | SQLException e) {
			 mv.addObject("user", new User());
			  mv.addObject("errorMessage", "Some internal problem occured please try again!!!");
			  mv.setViewName("error404page");
		}

		return mv;
	}

}
