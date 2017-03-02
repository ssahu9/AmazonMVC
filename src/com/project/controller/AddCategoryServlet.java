package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.project.bl.AdminBL;

public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(AddCategoryServlet.class);
	
	AdminBL adminBL = new AdminBL();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		String category = request.getParameter("cname");
		System.out.println(category);
		try {
			if(adminBL.addCategory(category))
		 		request.getRequestDispatcher("index.jsp").forward(request, response);
			else request.getRequestDispatcher("admin.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("errorMessage", "Failed to add Category");
			request.getRequestDispatcher("error404page.jsp").include(request, response);
		}
		
		BasicConfigurator.configure();
 	    logger.info("category added successfully!!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
