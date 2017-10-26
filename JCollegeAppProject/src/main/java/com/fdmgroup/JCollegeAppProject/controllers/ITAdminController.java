package com.fdmgroup.JCollegeAppProject.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.JCollegeAppProject.daos.UserDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.User;

@Controller
public class ITAdminController {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private UserDAOImpl userDao;
	
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
	@RequestMapping("/itAdmin/addUser")
	public String goToAddUser (Model model){
		
		User user = new User ();
		model.addAttribute("user", user);		
		return "itAdmin/AddUser";
	}
	@RequestMapping("/itAdmin/processAddUser")
	public String processAddUser (Model model, User user){
		userDao.addUser(user);
		model.addAttribute("message", "User added successfully");		
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
