package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	private Logger logger=Logger.getLogger(getClass());
	
	public WelcomeController() {
		super();
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, HttpServletRequest request, Principal principal){
		String userID = principal.getName();
		session.setAttribute("userID", userID);
		if (request.isUserInRole("//set here Role1")) {
			return "redirect://parentfolder/subfolder of homepage for Role1";
		} else {
			if (request.isUserInRole("//set here Role2")) {
			logger.trace("login ");
			return "redirect://parentfolder/subfolder of homepage for Role2";
			}
			logger.trace("loginfailure ");
			return "//homepage with pop up";
			
		}
				
	}
	
}
