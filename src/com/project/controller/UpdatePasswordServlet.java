package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.bean.Admin;
import com.project.bl.AdminBL;

public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = null;
		HttpSession session = request.getSession(false);
		if (session == null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		Admin admin = (Admin) session.getAttribute("customerObject");
		String oldpass = request.getParameter("opwd");
		if(oldpass.equals(admin.getPassword()))
			request.getRequestDispatcher("index.jsp").forward(request, response);
		String password = request.getParameter("pwd");
		String rpassword = request.getParameter("rpwd");
		if (password.equals(rpassword))
			admin.setPassword(rpassword);
		else
			request.getRequestDispatcher("updatepassword.jsp").forward(request, response);
		AdminBL adminBl = new AdminBL();
		try {
			adminBl.updatePassword(admin);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
