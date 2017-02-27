package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("button");
		
		switch (str) {
		case "View Category":
			request.getRequestDispatcher("index.jsp").include(request, response);
			break;
		case "Add Product":
			request.getRequestDispatcher("index.jsp").include(request, response);
			break;
		case "Add Category":
			request.getRequestDispatcher("index.jsp").include(request, response);
			break;
		case "Remove Category":
			request.getRequestDispatcher("index.jsp").include(request, response);
			break;
		case "Remove Product":
			request.getRequestDispatcher("index.jsp").include(request, response);
			break;
		case "Bill History":
			request.getRequestDispatcher("index.jsp").include(request, response);
			break;
		case "Update Product":
			request.getRequestDispatcher("index.jsp").include(request, response);
			break;
		case "View Products":
			request.getRequestDispatcher("index.jsp").include(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
