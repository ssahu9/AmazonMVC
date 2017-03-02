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

import com.project.bean.Product;
import com.project.bl.AdminBL;

public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(RemoveProductServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BasicConfigurator.configure();
 	    logger.info("remove product servlet working!!");
		
		response.setContentType("text/html");
		PrintWriter out = null;
		HttpSession session=request.getSession(false);
		Product product = new Product();
		int pID = (Integer.parseInt(request.getParameter("pid")));

		AdminBL adminBl = new AdminBL();
		try {
		boolean	status= adminBl.deleteProduct(pID);
		if(status){
			response.sendRedirect("admin.jsp");
		}
		else{
			//Product is not deleted.
			//call error page
		}
		} catch (ClassNotFoundException | SQLException e) {
			//request.setAttribute("errorMessage", "Failed to remove product");
			//request.getRequestDispatcher("error404admin.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
