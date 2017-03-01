package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.BillDetails;
import com.project.bl.AdminBL;

public class BillHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminBL adminBL = new AdminBL();
	List<BillDetails> billHistory = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		try {
			if(adminBL.getAllBillDetails() != null) {
				billHistory = adminBL.getAllBillDetails();
				getServletContext().setAttribute("billHistory", billHistory);
			}
			else {
				request.setAttribute("errorMessage", "Unable to Process bill");
				request.getRequestDispatcher("error404admin.jsp").include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("errorMessage", "Unable to Process bill");
			request.getRequestDispatcher("error404admin.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
