package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.User;
@Controller
public class CallErrorPageServlet  {
	private static Logger logger=Logger.getLogger(CallErrorPageServlet.class);
	@RequestMapping(value="/CallErrorPageServlet")
	public ModelAndView displayErrorPage()
	{
	
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new User());
		  mv.addObject("errorMessage", "Failed to save");
		  mv.setViewName("error404page");
		  return mv;
	}
	
}
