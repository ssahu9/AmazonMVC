package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Category;
import com.project.bl.AdminBL;
import com.project.bl.CustomerBl;

@Controller
public class CategoryOperation  {
	List<Category> categoryList = null;
	private static Logger logger=Logger.getLogger(CategoryOperation.class);
	@Autowired
	private AdminBL adminBl ;
	@Autowired
	private CustomerBl customerBl;
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public ModelAndView addCategory(@Valid Category category, BindingResult result){
		boolean status= false;
		 ModelAndView mv = new ModelAndView();
		 
		 
		 if(result.hasErrors()){
			mv.setViewName("admin");
			}
			
		try {
		 status=adminBl.addCategory(category.getCategoryName());
			
			if(status){
				mv.addObject("message", "Category Addded !!!");
				mv.setViewName("admin");
				
			}else{
				mv.addObject("message", "Category Not Addded !!!");
				mv.setViewName("admin");

			}
		} catch (ClassNotFoundException | SQLException e) {
			// call error page
			}
		return mv;
		
		
	}

	@RequestMapping(value="/removeCategory", method=RequestMethod.POST)
	public ModelAndView removeCategory(@ModelAttribute ("category") Category category){
		boolean status= false;
		 ModelAndView mv = new ModelAndView();
		 
		/* if(result.hasErrors()){
				mv.setViewName("admin");
				}
		*/	
		 try {
				 status=	adminBl.deleteCategory(category.getCategoryName());
				if(status){
					mv.addObject("rcStatus", "Category Removed !!!");
					mv.setViewName("admin");
				}else{
					mv.addObject("rcStatus", "Category Not Removed !!!");
					mv.setViewName("admin");

				}
				} catch (ClassNotFoundException | SQLException e) {
					// call error page
				}		return mv;
		
		
	}

	@RequestMapping(value="/viewCategory")
	public ModelAndView viewCategory(){
		
		 ModelAndView mv = new ModelAndView();
		 
		/* if(result.hasErrors()){
				mv.setViewName("admin");
				}
		*/	
		 try {		
			 categoryList = adminBl.viewCategory();
			 
				if(categoryList!= null){
					
					
					mv.addObject("categoryList", categoryList);
					mv.setViewName("viewcategories");
				}else{
					mv.addObject("message", "Category Not Found !!!");
					mv.setViewName("admin");

				}
				} catch (ClassNotFoundException | SQLException e) {
					
				}	
		 return mv;
		
		
	}

	
	
}
