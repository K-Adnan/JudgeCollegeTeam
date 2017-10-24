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
	
	public RegistrarController(CourseDAOImpl cDAO) {
		this.courseDAO = cDAO;
	}
	
	@RequestMapping("/courseCancellation")
	public String courseCancellation(@RequestParam int courseId, Model model, Course course) {
		courseDAO.getCourse(courseId);
		courseDAO.removeCourse(courseId);
		model.addAttribute("course", course);
		model.addAttribute("message", "Course is cancelled!");
		logger.info("Course is cancelled :"+courseId);
		return "CourseCancellation";
	}
	
	@RequestMapping("/courseUpdate")
	public String courseUpdate(@RequestParam int courseId, Model model){
		Course course = courseDAO.getCourse(courseId);
		courseDAO.updateCourse(course);
		model.addAttribute("course", course);
		model.addAttribute("message", "Course is cancelled!");
		logger.info("Course is updated :"+courseId);
		return "CourseUpdate";
	}
	
	@RequestMapping("/courseAdding")
	public String courseAdding(Model model, int courseId){
		Course course = courseDAO.getCourse(courseId);
		courseDAO.addCourse(course);
		model.addAttribute("message", "Course added successfully!");
		model.addAttribute("course",course);
		logger.info("Course is added :"+courseId);
		return "CourseAdding";
	}
}
