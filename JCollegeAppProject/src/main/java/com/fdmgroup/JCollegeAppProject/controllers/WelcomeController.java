package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.JCollegeAppProject.daos.ITAdminDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.RegistrarDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;

@Controller
public class WelcomeController {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	StudentDAO studentDao;
	@Autowired
	ProfessorDAO professorDao;
	@Autowired
	ITAdminDAO itAdminDao;
	@Autowired
	RegistrarDAO registrarDao;

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
			return "redirect:itAdmin/HomePage";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/student/home")
	public String goToStudentHome(HttpSession session) {
		String username = (String) session.getAttribute("username");
		Student student = studentDao.getStudent(username);
		student.setNoOfIncorrectAttempts(0);
		studentDao.updateStudent(student);
		return "student/studentHome";
	}
	
	@RequestMapping("/professor/home")
	public String goToProfessorHome(HttpSession session) {
		String username = (String) session.getAttribute("username");
		Professor professor = professorDao.getProfessor(username);
		professor.setNoOfIncorrectAttempts(0);
		professorDao.updateProfessor(professor);
		return "professor/professorHome";
	}
	
	@RequestMapping("/registrar/home")
	public String goToRegistrarHome(HttpSession session) {
		String username = (String) session.getAttribute("username");
		Registrar registrar= registrarDao.getRegistrar(username);
		registrar.setNoOfIncorrectAttempts(0);
		registrarDao.updateRegistrar(registrar);
		return "registrar/registrarHome";
	}
	
	@RequestMapping("/itadmin/home")
	public String goToITAdminHome(HttpSession session) {
		String username = (String) session.getAttribute("username");
		ITAdmin itAdmin = itAdminDao.getITAdmin(username);
		itAdmin.setNoOfIncorrectAttempts(0);
		itAdminDao.updateITAdmin(itAdmin);
		return "itadmin/itadminHome";
	}
	
	@RequestMapping("/logout")
	public String doLogOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
