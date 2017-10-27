package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.RegistrarDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;

@Controller
public class RegistrarController {
	
	private Logger logger=Logger.getLogger(getClass());

	@Autowired
	private CourseDAO courseDao;
	@Autowired
	private ProfessorDAO professorDao;
	@Autowired
	private StudentDAO studentDao;
	@Autowired
	private RegistrarDAO registrarDao;
	@Autowired
	private DepartmentDAO departmentDao;
	
	
	public RegistrarController() {
		super();
	}
	
	public RegistrarController(CourseDAOImpl cDAO, ProfessorDAO professorDAO) {
		this.courseDao = cDAO;
		this.professorDao = professorDAO;
	}
	
	@RequestMapping("/registrar/registrarHome")
	public String GoToregistrarHome(){
		logger.info("Client request to url : registrarHome");
		return "registrar/registrarHome";
	}
	
	@RequestMapping("/registrar/MyProfile")
	public String GoToMyProfile(Principal principal, Model model) {
		logger.info("Client request to url : MyProfile");
		Registrar registrar = registrarDao.getRegistrar(principal.getName());
		model.addAttribute("registrar", registrar);
		return "registrar/MyProfile";
	}

	@RequestMapping("/registrar/SystemUsers")
	public String GoToSystemUsers(){
		logger.info("Client request to url : SystemUsers");
		return "registrar/SystemUsers";
	}
	
	@RequestMapping("/registrar/Courses")
	public String goToCourses(Model model) {
		logger.info("Client request to url : Courses");
		
		List<Course> courseList = courseDao.getAllCourses();
		List<Professor> professorList = professorDao.getAllProfessors();
		
		Course course = courseList.get(0);
		List<Student> studentList = studentDao.getAllStudentsByCourse(course);
		model.addAttribute("studentList", studentList);
		model.addAttribute("courseList", courseList);
		model.addAttribute("course", course);
		model.addAttribute("professorList", professorList);
		return "registrar/Courses";
	}
	
	@RequestMapping("/registrar/cancelCourse")
	public String courseCancellation(@RequestParam int code, Model model) {
		courseDao.removeCourse(code);
		model.addAttribute("message", "Course is cancelled!");
		logger.info("Course is cancelled :" + code);
		return "redirect:Courses";
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
	
	@RequestMapping("/registrar/processChooseCourse")
	public String doChooseCourse(Model model, int courseId){
		Course course = courseDao.getCourse(courseId);
		List<Course> courseList = courseDao.getAllCourses();
		List<Professor> professorList = professorDao.getAllProfessors();
		
		List<Student> studentList = studentDao.getAllStudentsByCourse(course);
		model.addAttribute("studentList", studentList);
		model.addAttribute("course",course);
		model.addAttribute("courseList", courseList);
		logger.info("Course is chosen :"+courseId);
		model.addAttribute("professorList", professorList);
		return "registrar/Courses";
	}
	
	@RequestMapping("/registrar/AddCourse")
	public String GoToAddCourse(Model model){
		List<Professor> professorList = professorDao.getAllProfessors();
		List<Department> departmentList = departmentDao.getAllDepartments();
		model.addAttribute("professorList", professorList);
		model.addAttribute("departmentList", departmentList);
		Course course = new Course();
		model.addAttribute("course",course);
		logger.info("Client request to url : AddCourse");
		return "registrar/AddCourse";
	}
	
	@RequestMapping("/registrar/doAddCourse")
	public String DoAddCourse(Model model, Course course,@RequestParam int departmentId){
	Department department = departmentDao.getDepartment(departmentId);
	course.setDepartment(department);
	courseDao.addCourse(course);
	model.addAttribute("message", "Course added successfully!");
	model.addAttribute("course",course);
	
	List<Course> courseList = courseDao.getAllCourses();
	model.addAttribute("courseList", courseList);
	List<Professor> professorList = professorDao.getAllProfessors();
	model.addAttribute("professorList", professorList);
	//logger.info("Course is added : " +courseCode);
	return "registrar/Courses";
	}
	
	@RequestMapping("/registrar/Timetable")
	public String GoToTimetable(){
		logger.info("Client request to url : Timetable");
		return "registrar/Timetable";
	}
	
	@RequestMapping("/registrar/Grades")
	public String GoToGrades(){
		
		logger.info("Client request to url : Grades");
		return "registrar/Grades";
	}
}
