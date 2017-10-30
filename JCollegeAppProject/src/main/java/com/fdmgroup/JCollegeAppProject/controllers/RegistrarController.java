package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.RegistrarDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.daos.UserDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

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
	@Autowired
	private GradeDAO gradeDao;
	@Autowired
	private UserDAO userDao;
	
	
	public RegistrarController() {
		super();
	}
	
	public RegistrarController(CourseDAOImpl cDAO, ProfessorDAO professorDAO, StudentDAO studentDAO) {
		this.courseDao = cDAO;
		this.professorDao = professorDAO;
		this.studentDao = studentDAO;
	}
	
	@RequestMapping("/registrar/MyProfile")
	public String GoToMyProfile(Principal principal, Model model) {
		logger.info("Client request to url : MyProfile");
		Registrar registrar = registrarDao.getRegistrar(principal.getName());
		model.addAttribute("registrar", registrar);
		return "registrar/MyProfile";
	}

	@RequestMapping("/registrar/SystemUsers")
	public String GoToSystemUsers(Model model){
		logger.info("Client request to url : SystemUsers");
		
		List<User> userList = userDao.getAllUsers();
		model.addAttribute("userList", userList);
		
		return "registrar/SystemUsers";
	}
	
	@RequestMapping("/registrar/ViewAndUpdate")
	public String doChooseUser(Model model, @RequestParam String username){
		User user = userDao.getUser(username);
		Professor professor = professorDao.getProfessor(username);
		Student student = studentDao.getStudent(username);
		
		model.addAttribute("user", user);
		model.addAttribute("professor", professor);
		model.addAttribute("student", student);
		
		logger.info("User is chosen :"+username);
		return "registrar/ViewAndUpdate";
	}
	
	@RequestMapping("/registrar/RemoveUser")
	public String doRemoveUser(Model model, @RequestParam String username, RedirectAttributes ra){
		User user = userDao.getUser(username);
		List<User> userList = userDao.getAllUsers();
		
		userDao.removeUser(username);
		
		ra.addFlashAttribute("message", "User is removed!");
		logger.info("User is removed :"+username);
		return "redirect:SystemUser";
	}
	
	@RequestMapping("/registrar/EditInformation")
	public String EditInformation(Model model, String username){
		logger.info("Information are edited :"+username);
		return "registrar/EditInformation";
	}
	
	@RequestMapping("/registrar/Courses")
	public String goToCourses(Model model, @ModelAttribute("message") String message) {
		logger.info("Client request to url : Courses");
		
		List<Course> courseList = courseDao.getAllCourses();
		List<Professor> professorList = professorDao.getAllProfessors();
		
		Course course = courseList.get(0);
		List<Student> studentList = studentDao.getAllStudentsByCourse(course);
		model.addAttribute("studentList", studentList);
		model.addAttribute("courseList", courseList);
		model.addAttribute("course", course);
		model.addAttribute("professorList", professorList);
		model.addAttribute("message",message);
		return "registrar/Courses";
	}
	
	@RequestMapping("/registrar/cancelCourse")
	public String courseCancellation(@RequestParam int code, Model model, RedirectAttributes ra) {
		Course course = courseDao.getCourse(code);
		List<Grade> gradeList = gradeDao.getAllGradesByCourse(course);
		
		for (int i=0;i<gradeList.size();i++){
			Grade grade = gradeList.get(i);
			gradeDao.removeGrade(grade.getGradeId());
		}
		
		courseDao.removeCourse(code);
		ra.addFlashAttribute("message", "Course is cancelled!");
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
