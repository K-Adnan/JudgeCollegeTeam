package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Student;

@Controller
public class StudentController {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private CourseDAO courseDao;
	
	@Autowired
	private StudentDAO studentDao;

	public StudentController() {
	}
	
	
	@RequestMapping("student/ViewCourses")
	public String goToViewCourses(HttpSession session, Model model, Principal principal){
		Student student = studentDao.getStudent(principal.getName());
		List<Course> enrolledCourseList = courseDao.getAllCoursesByStudent(student);
		List<Course> courseList = courseDao.getAllCourses();
		
		model.addAttribute("enrolledCourses", enrolledCourseList);
		model.addAttribute("courseList", courseList);
		return "student/studentViewCourses";
	}
	
	@RequestMapping("student/enrollOnCourse")
	public String doEnrollOnCourse(int courseCode, HttpSession session, Model model, Principal principal){
		Student student = studentDao.getStudent(principal.getName());
		Course course = courseDao.getCourse(courseCode);
		
		student.addCourse(course);
		studentDao.updateStudent(student);
		
		session.setAttribute("message", "Successfully enrolled on : " + course.getCourseName());
		return "redirect:ViewCourses";
	}
	
}
