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
import com.project.bl.AdminBL;

public class RemoveCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = null;
		HttpSession session=request.getSession(false);
		AdminBL admin=new AdminBL();
		String cName = request.getParameter("cname");
		try {
			admin.deleteCategory(cName);
		} catch (ClassNotFoundException | SQLException e) {
			//request.setAttribute("errorMessage", "error deleting category");
		//request.getRequestDispatcher("error404error.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
