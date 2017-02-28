package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.Product;
import com.project.bl.AdminBL;

public class ViewProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminBL adminBL = new AdminBL();
	List<Product> viewProducts = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try {
			if(adminBL.viewProduct(null) != null) {
				viewProducts = adminBL.viewProduct(null);
				getServletContext().setAttribute("viewProducts", viewProducts);
			}
			else {
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
