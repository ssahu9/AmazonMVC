package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.Category;
import com.project.bl.AdminBL;

public class ViewCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminBL AdminBL = new AdminBL();;
	List<Category> categoryList = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if(categoryList == null) {
			request.getRequestDispatcher("admin.jsp").include(request, response);
		}
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
