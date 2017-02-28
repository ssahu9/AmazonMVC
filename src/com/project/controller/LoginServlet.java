package com.project.controller;
 
 import java.io.IOException;
 import java.io.PrintWriter;
 import java.sql.SQLException;
 
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;

 import com.project.bean.Customer;
  import com.project.bl.CustomerBl;
  
  public class LoginServlet extends HttpServlet {
  	private static final long serialVersionUID = 1L;
  	CustomerBl customerBL = new CustomerBl();
  
  	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
  		response.setContentType("text/html");
  		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
  		
  		String email = request.getParameter("email");
  		String password = request.getParameter("password");
  		Customer customer = null;
  		try {
  			out.print("test");
  			customer = customerBL.signIn(email, password);
  			out.print("test2");
  			out.print("test"+customer.getEmail());
  		} catch (ClassNotFoundException | SQLException e) {
  			e.printStackTrace();
  			out.print("EXCEPTION"+e);
  		}
  		
  		
  			if(customer == null) { // login failed
  				out.print("Sorry, you entered the wrong credentials");
  				try {
					request.getRequestDispatcher("index.jsp").include(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					out.print("EXCEPTION"+e);
					e.printStackTrace();
				} // redirecting to index.jsp
  			}
  			else if(customer.getEmail().equals("admin") || customer.getPassword().equals("admin123")) {
  				HttpSession session = request.getSession(); // creating session
  				session.setAttribute("email", email);
  				session.setAttribute("customerObject", customer);
  				// setting session attribute
  				try {
					request.getRequestDispatcher("admin.jsp").forward(request, response); // redirecting to admin.jsp
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
  			}
  			else { // customer login successful
  				HttpSession session = request.getSession(); // creating session
  				session.setAttribute("email", email); // setting session attribute
  				try {
					request.getRequestDispatcher("index.jsp").forward(request, response); // redirecting to index.jsp
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					out.print("EXCEPTION"+e);
				}
  			
  			}
  	
  	}
  
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		doGet(request, response);
  	}
  
  }