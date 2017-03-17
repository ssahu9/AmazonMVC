package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.bean.Product;
import com.project.bean.User;
import com.project.bl.CustomerBl;

@Controller

@SessionAttributes("proList")
public class GetProducts  {
	
	private static Logger logger=Logger.getLogger(GetProducts.class);
	@RequestMapping(value="/getProducts")
	
	public String getProducts( @RequestParam("category") String pCategory, ModelMap model)
	{	System.out.println(">>>>>>>>>>>>>>>>gdgdgdgdgd>>>>>>product list");
		CustomerBl customerBl = new CustomerBl();
		ArrayList<Product> proList =null;
		
		try {
			
			proList = (ArrayList<Product>)customerBl.viewProduct(pCategory);
			System.out.println(proList);
			model.addAttribute("currentCategory", proList);
			model.addAttribute("user", new User());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>product list");
		} catch (ClassNotFoundException | SQLException e) {
			model.addAttribute("errorMessage", "Invalid Entry, please retry again");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>product error");
			return("error404page");
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>product list2");

		return "women";
	}
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BasicConfigurator.configure();
 	    logger.info(" get products working!!");
 	    
		response.setContentType("text/html");
	HttpSession session=request.getSession(false);
		CustomerBl customerBl = new CustomerBl();
		ArrayList<Product> proList =null;
		String pcategory=null;
		try {
			pcategory =request.getParameter("selectedCategory");
			proList = (ArrayList<Product>)customerBl.viewProduct(pcategory);
			System.out.println(proList);
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("errorMessage", "Unable to Get Product");
			request.getRequestDispatcher("error404page.jsp").include(request, response);
		}
		if(session!=null){
			session.setAttribute("currentCategory",pcategory);
		}
		request.setAttribute("productList",proList);
		request.getRequestDispatcher("women.jsp").include(request, response);

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
