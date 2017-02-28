package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bl.AdminBL;

public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminBL adminBL = new AdminBL();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String category = request.getParameter("cname");
		
		try {
			if(adminBL.addCategory(category))
				request.getRequestDispatcher("index.jsp").forward(request, response);
			else request.getRequestDispatcher("admin.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
