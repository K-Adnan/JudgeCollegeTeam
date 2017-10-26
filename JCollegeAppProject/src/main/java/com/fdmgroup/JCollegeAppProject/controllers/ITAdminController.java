package com.fdmgroup.JCollegeAppProject.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.UserDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

@Controller
public class ITAdminController {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private UserDAOImpl userDao;
	@Autowired
	private StudentDAOImpl studentDao;
	@Autowired
	private ProfessorDAOImpl professorDao;
	
	public ITAdminController() {
		super();
	}	
	
	public ITAdminController(UserDAOImpl userDAO) {
		super();
		this.userDao = userDAO;
	}

	@RequestMapping("/itAdmin/HomePage")
	public String ITAdminHomePage(HttpSession session, Model model){		
		return "itAdmin/HomePage";
	}
	@RequestMapping("/itAdmin/addStudent")
	public String goToAddStudent (Model model){
		Student student = new Student ();
		model.addAttribute("student", student);		
		return "itAdmin/AddStudent";
	}
	@RequestMapping("/itAdmin/processAddStudent")
	public String processAddStudent (Model model, Student student){
		studentDao.addStudent(student);
		model.addAttribute("message", "Student added successfully");		
		return "itAdmin/HomePage";
	}
	@RequestMapping("/itAdmin/addProfessor")
	public String goToAddProfessor (Model model){
		Professor professor = new Professor ();
		model.addAttribute("professor", professor);		
		return "itAdmin/AddProfessor";
	}
	@RequestMapping("/itAdmin/processAddProfessor")
	public String processAddProfessor (Model model, Professor professor){
		professorDao.addProfessor(professor);
		model.addAttribute("message", "Professor added successfully");		
		return "itAdmin/HomePage";
	}	
	@RequestMapping("/itAdmin/removeUser")
	public String goToRemoveUser (Model model){
		User user = new User ();
		model.addAttribute("user", user);
		return "itAdmin/RemoveUser";
	}
	@RequestMapping("/itAdmin/processRemoveUser")
	public String processRemoveUser(User user, Model model) {
		userDao.removeUser(user.getUsername());
		model.addAttribute("message2", "User removed successfully");
		return "itAdmin/HomePage";
		
	}
	

}
