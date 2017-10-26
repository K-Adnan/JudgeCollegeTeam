package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

@Controller
public class ProfessorController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ProfessorDAOImpl professorDao;

	public ProfessorController() {
		super();

	}

	public ProfessorController(ProfessorDAOImpl professorDao) {
		super();
		this.professorDao = professorDao;
	}

	@Autowired
	private StudentDAOImpl studentDao;

	@Autowired
	private DepartmentDAOImpl departmentDao;

	@Autowired
	private GradeDAOImpl gradeDao;

	@Autowired
	private CourseDAOImpl courseDao;

	@RequestMapping("/professor/professorHome")
	public String goToProfessorHome() {
		logger.trace("Client request to url : /professor/professorHome");
		return "professor/professorHome";

	}

	@RequestMapping("/professor/logout") //
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";

	}

	@RequestMapping("/professor/viewCourses")
	public String goToShowCourses(Model model) {
		List<Course> courseList = courseDao.getAllCourses();
		model.addAttribute("courseList", courseList);
		return "professor/professorViewCourses";

	}

	@RequestMapping("/professor/processViewCourses")
	public String processShowCourses() {
		courseDao.getAllCourses();
		return "professor/professorViewCourses";
	}

	@RequestMapping("/professor/processChooseCourse")
	public String processChooseCourse(Model model, int courseCode) {

		Course course = courseDao.getCourse(courseCode);
		List<Course> courseList = courseDao.getAllCourses();
		courseDao.updateCourse(course);
		model.addAttribute("course", course);
		model.addAttribute("courseList", courseList);
		logger.info("Course is chosen :" + courseCode);

		return "professor/professorViewCourses";
	}

	@RequestMapping("/professor/viewTaughtCourses")
	public String goToTaughtCourses(Model model, HttpSession session, Principal principal) {
		String username = principal.getName();
		Professor professor = professorDao.getProfessor(username);
		List<Course> taughtCourseList = courseDao.getAllCoursesByProfessor(professor);
		model.addAttribute("taughtCourseList", taughtCourseList);
		return "professor/professorViewCourses";

	}

	@RequestMapping("/professor/processViewTaughtCourses")
	public String processTaughtCourses(HttpSession session, Principal principal) {
		String username = principal.getName();
		Professor professor = professorDao.getProfessor(username);
		courseDao.getAllCoursesByProfessor(professor);
		return "professor/professorViewCourses";
	}

	@RequestMapping("/professor/viewStudents")
	public String goToShowStudents(Model model) {
		List<Student> studentList = studentDao.getAllStudents();
		model.addAttribute("studentList", studentList);
		return "professor/professorViewStudents";

	}

	@RequestMapping("/professor/processViewStudents")
	public String processShowStudents() {
		studentDao.getAllStudents();
		return "professor/professorViewStudents";
	}

	
	@RequestMapping("/professor/viewProfile")
	public String goToViewProfile(Model model, Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());
		model.addAttribute("professor", professor);
		return "professor/professorViewProfile";
	}
	
	
//	@RequestMapping("/professor/processViewProfile")
//	public String processViewProfile(Model model,Principal principal) {
//	
//		Professor professor = professorDao.getProfessor(principal.getName());
//		return "professor/professorViewProfile";
//
//	}
//	
	
	
	@RequestMapping("/professor/editprofile")
	public String goToEditProfilepage(Model model, Principal principal) {
		
		Professor professor = professorDao.getProfessor(principal.getName());
		
		professorDao.updateProfessor(professor);
		model.addAttribute("professor",professor);
		model.addAttribute("message", "Details successfully updated");
		return "professor/professorEditProfile";

	}

	@RequestMapping("/donor/processEditProfile")
	public String editProfile(Model model, HttpSession session, Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());
		
		
		
		professorDao.updateProfessor(professor);
		
		return "professor/professorEditProfile";
	}

}