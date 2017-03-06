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

import com.project.bean.Product;
import com.project.bl.CustomerBl;


public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(GetProducts.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	}

}
