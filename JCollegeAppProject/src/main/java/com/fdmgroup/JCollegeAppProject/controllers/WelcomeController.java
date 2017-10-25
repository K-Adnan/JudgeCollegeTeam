package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	private Logger logger = Logger.getLogger(getClass());

	public WelcomeController() {
		super();
	}

	@RequestMapping("/")
	public String goToIndex() {
		return "index";
	}

	@RequestMapping("/index")
	public String goBackToIndex() {
		return "redirect:/";
	}

	@RequestMapping("/login")
	public String goToLogin(String username, HttpSession session, Principal principal, HttpServletRequest request) {
		session.setAttribute("username", principal.getName());
		
		if (request.isUserInRole("Student")){
			return "redirect:student/home";
		}else if (request.isUserInRole("Professor")){
			return "redirect:professor/home";
		}else if (request.isUserInRole("Registrar")){
			return "redirect:registrar/home";
		}else if (request.isUserInRole("ITAdmin")){
			return "redirect:itadmin/home";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/student/home")
	public String goToStudentHome() {
		return "student/studentHome";
	}
	
	@RequestMapping("/professor/home")
	public String goToProfessorHome() {
		return "professor/professorHome";
	}
	
	@RequestMapping("/registrar/home")
	public String goToRegistrarHome() {
		return "registrar/registrarHome";
	}
	
	@RequestMapping("/itadmin/home")
	public String goToITAdminHome() {
		return "itadmin/itadminHome";
	}
	
	@RequestMapping("/logout")
	public String doLogOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
