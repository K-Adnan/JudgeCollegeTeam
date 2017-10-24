package com.fdmgroup.JCollegeAppProject.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class ITAdminController {

	private Logger logger = Logger.getLogger(getClass());

	public ITAdminController() {
	}
	
	
	@RequestMapping("itAdmin/HomePage")
	public String ITAdminHomePage(HttpSession session, Model model){
		
		
		
		
		return "itAdmin/HomePage";
	}

}
