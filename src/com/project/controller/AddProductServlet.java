package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Category;
import com.project.bean.Product;
import com.project.bl.AdminBL;

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Product product = new Product();
		HttpSession session=request.getSession(false);
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
		//System.out.println(product);
		
		try {
			boolean status=adminBl.addProduct(product);
			if(status)
			{
				response.sendRedirect("admin.jsp");
					
			}
			else{
				//request.setAttribute("errorMessage", "Unable to Process bill");
				//request.getRequestDispatcher("error404admin.jsp").include(request, response);
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
