package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Category;
import com.project.bean.Product;
@Controller
public class AdminEntry  {
		private static Logger logger=Logger.getLogger(AdminEntry.class);

		
		
		
		
		@RequestMapping(value="/adminEntry")
		protected ModelAndView adimnOperation(HttpServletRequest request)  {
		
		BasicConfigurator.configure();
 	    logger.info("admin entry class working!!");
 	    System.out.println(">>>>>>>>>>>>>>>>>>>>>>\n\n\n\n>>>>>>>>>>>");
		String str = request.getParameter("button");
		System.out.println(str);
		ModelAndView mv = new ModelAndView();
		switch (str.trim()) {
		case "View Category":
			String url = "/viewCategory";
			return	new ModelAndView("redirect:"+ url);

			//call controller
			
		case "Add  Product":
			
			//call view
			mv.addObject("product", new Product());
			mv.setViewName("addcategory");
			break;
		case "Add Category":
		
			mv.addObject("category", new Category());
			mv.setViewName("addcategory");

			break;
		case "Remove Category":
			//call view
			System.out.println("remove category");
			mv.addObject("category", new Category());
			mv.setViewName("removecategory");
			break;
		case "Remove Product":
			System.out.println("remove product");
			mv.addObject("product", new Product());
			mv.setViewName("removeproduct");
			break;
		
		case "Update Product":
			//call view
			mv.addObject("product", new Product());
			mv.setViewName("updateproduct");
			break;
		case "View Products":
			//call controller
			break;
		
		default:
			break;
		}
		return mv;
	}

}
