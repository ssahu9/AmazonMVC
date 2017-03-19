package com.project.controller;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.bean.User;

@Controller
public class Logout {

	private static Logger logger = Logger.getLogger(Logout.class);

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.setAttribute("email", null);
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		// redirecting to index page after logout
		mv.setViewName("index");
		mv.addObject("user", new User());
		return mv;

	}

}