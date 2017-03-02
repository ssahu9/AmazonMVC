package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.project.bean.Product;
import com.project.bl.AdminBL;

public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(UpdateProductServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BasicConfigurator.configure();
 	    logger.info(" update productservlet working!!");
		
		response.setContentType("text/html");
		PrintWriter out = null;
		
		Product product=new Product();
		int pID = (Integer.parseInt(request.getParameter("pid")));
		product.setProductId(pID);
		String name = (request.getParameter("pname"));
		product.setName(name);
		String category = (request.getParameter("cname"));
		product.setCategory(category);
		double price = (Double.parseDouble(request.getParameter("prodprice")));
		product.setPrice(price);
		int quantity = (Integer.parseInt(request.getParameter("prodquantity")));
		product.setQuantity(quantity);
		int discount = (Integer.parseInt(request.getParameter("pdiscount")));
		product.setDiscount(discount);
		
		AdminBL adminBl = new AdminBL();
		try {
			adminBl.updateProduct(product);
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("errorMessage", "Unable to update");
			request.getRequestDispatcher("error404admin.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
