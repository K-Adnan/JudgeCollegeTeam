package com.fdmgroup.JCollegeAppProject.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;

@Controller
public class RegistrarController {
	
	private Logger logger=Logger.getLogger(getClass());

	@Autowired
	private CourseDAOImpl courseDAO;
	
	public RegistrarController() {
		super();
	}
	
	@RequestMapping("/courseCancellation")
	public String courseCancellation(@RequestParam int courseId, Model model, Course course) {
		courseDAO.getCourse(courseId);
		courseDAO.removeCourse(courseId);
		model.addAttribute("course", course);
		model.addAttribute("message", "Course is cancelled!");
		logger.trace("Course is cancelled :"+courseId);
		return "index";
	}
	
	
	
}
