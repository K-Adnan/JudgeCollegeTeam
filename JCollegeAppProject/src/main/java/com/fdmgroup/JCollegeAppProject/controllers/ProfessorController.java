package com.fdmgroup.JCollegeAppProject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;


public class ProfessorController {

	private Logger logger = Logger.getLogger(getClass());
	
	
	@Autowired
	private ProfessorDAOImpl professorDao ;

	
	

	public ProfessorController() {
		super();
		
	}

	public ProfessorController(ProfessorDAOImpl professorDao) {
		super();
		this.professorDao = professorDao;
	}

	
	@Autowired
	private StudentDAOImpl studentDao ;
	
	
	@Autowired
	private DepartmentDAOImpl departmentDao ;
	
	
	@Autowired
	private GradeDAOImpl gradeDao ;
	
	@Autowired
	private CourseDAOImpl courseDao ;
	
	

	@RequestMapping("/professor/professorHome")
	public String goToProfessorHome() {
		logger.trace("Client request to url : /professor/professorHome");
		return "professor/professorHome";

	}
	
	
	@RequestMapping("/professor/professorHome")
	public String goToProfessorHome(@RequestParam String username, HttpSession session) {
		session.setAttribute("username", username);
		return "professor/professorHome";

	}
	
	
	
	@RequestMapping("/professor/logout") //
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";

	}
	
	
	
	@RequestMapping("/professor/showCourses")
	public String goToShowCourses(Model model) {
		List<Course> courseList = courseDao.getAllCourses();
		model.addAttribute("courseList", courseList);
		return "professor/professorViewCourses";

	}

	
	@RequestMapping("/professor/processShowCourses")
	public String processShowCourses() {
		courseDao.getAllCourses();	
		return "professor/professorViewCourses";
	}
	
	@RequestMapping("/professor/processChooseCourse")
	public String processChooseCourse(Model model, int courseCode) {
		
		Course course = courseDao.getCourse(courseCode);
		List<Course> courseList = courseDao.getAllCourses();	
		model.addAttribute("course",course);
		model.addAttribute("courseList", courseList);
		logger.info("Course is chosen :"+courseCode);
		
		return "professor/professorViewCourses";
	}
	
		
	
	@RequestMapping("/professor/showStudents")
	public String goToShowStudents(Model model) {
		List<Student> studentList = studentDao.getAllStudents();
		model.addAttribute("studentList", studentList);
		return "professor/ShowStudents";

	}
	
	
	@RequestMapping("/professor/processShowStudents")
	public String processShowStudents() {
		studentDao.getAllStudents();	
		return "professor/ShowStudents";
	}
	
	
	@RequestMapping("/professor/editprofile")
	public String goToEditProfilepage(Professor professor, Model model) {
		professorDao.updateProfessor(professor);
		model.addAttribute("message", "Details successfully updated");
		return "professor/professorEditProfile";

	}

	 @RequestMapping("/donor/EditProfile")
	 public String editProfile(Model model, HttpSession session){
	 String username = (String)session.getAttribute("username");
	 Professor professor = professorDao.getProfessor(username);
//	 professor.setRole(professor);
	 model.addAttribute("professor",professor);
	 return "professor/professorEditProfile";
	 }

	
	
	

	
	
}