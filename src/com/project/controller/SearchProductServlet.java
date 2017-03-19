package com.project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.bean.Product;
import com.project.bl.CustomerBl;
@Controller
public class SearchProductServlet{
	@Autowired
	private CustomerBl customerBl;
	
	private static Logger logger=Logger.getLogger(SearchProductServlet.class);
	
	
	@RequestMapping(value="/searchProduct")
	
	public String searchProduct( @RequestParam("productName") String productName, ModelMap model)
	{	Product product =null ;
		try{
		     product= customerBl.searchProductByName(productName);
			}
			catch (ClassNotFoundException | SQLException e) {
			// call error page
			}
		ArrayList<Product> pList = new ArrayList<Product>();
		pList.add(product);
		model.addAttribute("productObject", pList);
		return("SearchResult");
			}
	
	
}
