package com.project.controller;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;

import com.project.bean.Category;
import com.project.bean.Customer;
import com.project.bl.CustomerBl;




@Controller
@RequestMapping("/")

public class LoginServlet{
//	private static final long serialVersionUID = 1L;
//	private static Logger logger=Logger.getLogger(LoginServlet.class);
//	
//	CustomerBl customerBL = new CustomerBl();
	   private ServletContext servletContext;
	@RequestMapping(method = RequestMethod.GET)
	public String newLogin(ModelMap model,  HttpServletRequest request ) {
		this.servletContext=request.getServletContext();
		CustomerBl customerBl = new CustomerBl();
		ArrayList<Category> category = new ArrayList<Category>();
		Category category1 = new Category();
		category1.setCategoryName("Sports");
//		try {
//			category = (ArrayList<Category>) customerBl.viewCategory();
//		} catch (ClassNotFoundException | SQLException e) {
//			
//			return "error404admin";
//		}
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		category.add(category1);
		servletContext.setAttribute("demo","demo apllcation scope");
		servletContext.setAttribute("categoryList", category);
		return "index";
	}
	
	       
	    
//public class LoginServlet  implements ServletContextAware{
////	private static final long serialVersionUID = 1L;
////	private static Logger logger=Logger.getLogger(LoginServlet.class);
////	
////	CustomerBl customerBL = new CustomerBl();
//	   private ServletContext servletContext;
//	@RequestMapping(method = RequestMethod.GET)
//	public String newLogin(ModelMap model,ServletContext servletContext) {
//		
//		CustomerBl customerBl = new CustomerBl();
//		ArrayList<Category> category = null;
//		try {
//			category = (ArrayList<Category>) customerBl.viewCategory();
//		} catch (ClassNotFoundException | SQLException e) {
//			model.addAttribute("error", "No Category");
//			return "error404admin";
//		}
//		Customer customer = new Customer();
//		model.addAttribute("customer", customer);
//		return "index";
//	}
//	@Override
//	 public void setServletContext(ServletContext servletContext) {
//		ArrayList<Category> category = null;
//		  this.servletContext = servletContext;
//	       
//	    }
//	
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		BasicConfigurator.configure();
// 	    logger.info("Login working!!");
// 	   Customer customer = null;
//		response.setContentType("text/html");
//
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		if (email.equals("admin@admin.com") && password.equals("admin123")) {
//			HttpSession session = request.getSession(); // creating session
//			session.setAttribute("email", email);
//			
//			// setting session attribute
//			try {
//				response.sendRedirect("admin.jsp");
//				//request.getRequestDispatcher("admin.jsp").forward(request, response); // redirecting
//																						// to
//																						// admin.jsp
//			} catch (IOException e) {
//				//request.setAttribute("errorMessage", "Unsuccessful Admin Sign in");
//				//request.getRequestDispatcher("error404admin.jsp").forward(request, response);
//				System.out.println(e);
//			}}
//		else {
//			try {
//				customer = customerBL.signIn(email, password);
//				System.out.println(customer);
//			} catch (ClassNotFoundException | SQLException e) {
//				request.setAttribute("errorMessage", "<a href=\"index.jsp\">Invalid User, please retry again</a>");
//				response.sendRedirect("index.jsp");
//				System.out.println(e);
//			}
//			if (customer == null) { // login failed
//				
//				request.setAttribute("errorMessage", "<a href=\"index.jsp\">Invalid User, please retry again</a>");
//				request.getRequestDispatcher("error404page.jsp").include(request, response);
//			
//			} else { // customer login successful
//				HttpSession session = request.getSession(); // creating session
//				session.setAttribute("email", email); // setting session attribute
//			session.setAttribute("customerObject", customer); // setting
//																	// customer
//																	// object in
//																	// session scope
//				try {
//					request.getRequestDispatcher("index.jsp").forward(request, response); // redirecting
//																							// to
//																							// index.jsp
//				} catch (ServletException | IOException e) {
//					// TODO Auto-generated catch block
//				//	request.setAttribute("errorMessage", "Unexpected Error");
//					//request.getRequestDispatcher("error404page.jsp").forward(request, response);
//				}
//			}
//		}
//	}
//
//	
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}

}