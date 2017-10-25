package com.fdmgroup.JCollegeAppProject.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Professor;

@Controller
public class RegistrarController {
	
	private Logger logger=Logger.getLogger(getClass());

	@Autowired
	private CourseDAO courseDao;
	@Autowired
	private ProfessorDAO professorDao;
	
	
	public RegistrarController() {
		super();
	}
	
	public RegistrarController(CourseDAOImpl cDAO, ProfessorDAO professorDAO) {
		this.courseDao = cDAO;
		this.professorDao = professorDAO;
	}
	
	@RequestMapping("/registrar/Courses")
	public String goToCourses(Model model) {
		logger.info("Client request to url : Courses");
		
		List<Course> courseList = courseDao.getAllCourses();
		List<Professor> professorList = professorDao.getAllProfessors();
		
		Course course = courseList.get(0);
		model.addAttribute("courseList", courseList);
		model.addAttribute("course", course);
		model.addAttribute("professorList", professorList);
		return "registrar/Courses";
	}
	
	@RequestMapping("/courseCancellation")
	public String courseCancellation(@RequestParam int courseId, Model model, Course course) {
		courseDao.getCourse(courseId);
		courseDao.removeCourse(courseId);
		model.addAttribute("course", course);
		model.addAttribute("message", "Course is cancelled!");
		logger.info("Course is cancelled :"+courseId);
		return "CourseCancellation";
	}
	
	@RequestMapping("/registrar/updateProfessor")
	public String courseUpdate(@RequestParam String professorUsername, @RequestParam int code, Model model){
		
		List<Course> courseList = courseDao.getAllCourses();
		List<Professor> professorList = professorDao.getAllProfessors();
		Course course = courseDao.getCourse(code);
		if (professorUsername.equals("empty")){
			course.setProfessor(null);
		}else{
			Professor professor = professorDao.getProfessor(professorUsername);
			course.setProfessor(professor);
		}
		courseDao.updateCourse(course);
		
		model.addAttribute("courseList", courseList);
		model.addAttribute("professorList", professorList);
		model.addAttribute("course", course);
		model.addAttribute("message", "Professer has been updated!");
		
		logger.info("Course is updated :" + code);
		return "registrar/Courses";
	}
	
	@RequestMapping("/courseAdding")
	public String courseAdding(Model model, int courseId){
		Course course = courseDao.getCourse(courseId);
		courseDao.addCourse(course);
		model.addAttribute("message", "Course added successfully!");
		model.addAttribute("course",course);
		logger.info("Course is added :"+courseId);
		return "CourseAdding";
	}
	
	@RequestMapping("/registrar/processChooseCourse")
	public String doChooseCourse(Model model, int courseId){
		Course course = courseDao.getCourse(courseId);
		List<Course> courseList = courseDao.getAllCourses();
		List<Professor> professorList = professorDao.getAllProfessors();
		
		model.addAttribute("course",course);
		model.addAttribute("courseList", courseList);
		logger.info("Course is chosen :"+courseId);
		model.addAttribute("professorList", professorList);
		return "registrar/Courses";
	}
	
}
