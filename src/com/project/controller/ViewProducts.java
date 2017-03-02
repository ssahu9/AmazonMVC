package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.project.bean.Product;
import com.project.bl.AdminBL;

public class ViewProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(ViewProducts.class);
	
	
	AdminBL adminBL = new AdminBL();
	List<Product> viewProducts = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BasicConfigurator.configure();
 	    logger.info(" view product working!!");
 	    
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		try {
			
			//if(adminBL.viewProduct(null) != null) {
				viewProducts = adminBL.viewProduct(null);
				getServletContext().setAttribute("viewProducts", viewProducts);
				response.sendRedirect("viewproduct.jsp");
			//}
		/*	else {request.setAttribute("errorMessage", "Unable to show products");
			request.getRequestDispatcher("error404admin.jsp").include(request, response);
			}
		}*/ 
		}catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("errorMessage", "Unable to show products");
			request.getRequestDispatcher("error404admin.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
