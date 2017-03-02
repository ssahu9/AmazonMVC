package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.project.bean.Category;
import com.project.bl.CustomerBl;

public class AvailableCategory extends HttpServlet {

	private static Logger logger=Logger.getLogger(AvailableCategory.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BasicConfigurator.configure();
 	    logger.info("category display successfull!!");
 	    
		response.setContentType("text/html");

		CustomerBl customerBl = new CustomerBl();
		ArrayList<Category> category = null;
		try {
			category = (ArrayList<Category>) customerBl.viewCategory();
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("errorMessage", "request failed");
			request.getRequestDispatcher("error404admin.jsp").include(request, response);
		}
		getServletContext().setAttribute("categoryList", category);

		response.sendRedirect("index.jsp");
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
