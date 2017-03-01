package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Product;
import com.project.bl.AdminBL;

public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = null;
		HttpSession session=request.getSession(false);
		Product product = new Product();
		int pID = (Integer.parseInt(request.getParameter("pid")));

		AdminBL adminBl = new AdminBL();
		try {
			adminBl.deleteProduct(pID);
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("errorMessage", "Failed to remove product");
			request.getRequestDispatcher("error404admin.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
