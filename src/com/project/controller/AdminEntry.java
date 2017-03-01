package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("button");
		HttpSession session=request.getSession(false);
		
		switch (str) {
		case "View Category":
			
			request.getRequestDispatcher("./ViewCategory").forward(request, response);
			break;
		case "Add Product":
			request.getRequestDispatcher("./AddProductServlet").forward(request, response);
			break;
		case "Add Category":
			request.getRequestDispatcher("./AddCategory").forward(request, response);
			break;
		case "Remove Category":
			request.getRequestDispatcher("./RemoveCategoryServlet").forward(request, response);
			break;
		case "Remove Product":
			request.getRequestDispatcher("./RemoveProductServlet").forward(request, response);
			break;
		case "Bill History":
			request.getRequestDispatcher("./BillHistory").forward(request, response);
			break;
		case "Update Product":
			request.getRequestDispatcher("./UpdateProductServlet").forward(request, response);
			break;
		case "View Products":
			request.getRequestDispatcher("./ViewProducts").forward(request, response);
			break;
		case "Update Password":
			request.getRequestDispatcher("./UpdatePasswordServlet").forward(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
