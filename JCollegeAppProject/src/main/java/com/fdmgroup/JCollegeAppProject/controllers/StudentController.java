package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Student;

@Controller
public class StudentController {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private CourseDAO courseDao;
	
	@Autowired
	private StudentDAO studentDao;
	
	@Autowired
	private GradeDAO gradeDao;

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
	public String doEnrollOnCourse(@RequestParam int courseCode, HttpSession session, Model model, Principal principal){
		Student student = studentDao.getStudent(principal.getName());
		Course course = courseDao.getCourse(courseCode);
		System.out.println("************* Add course to student **************************");
		student.addCourse(course);
		courseDao.updateCourse(course);
		model.addAttribute("message", "Successfully enrolled on : " + course.getCourseName());
		return "redirect:ViewCourses";
	}
	
	@RequestMapping("student/vacateCourse")
	public String doVacateCourse(@RequestParam int courseCode, HttpSession session, Model model, Principal principal){
		Student student = studentDao.getStudent(principal.getName());
		Course course = courseDao.getCourse(courseCode);
		
		student.removeCourse(course);
		course.removeStudent(student);
		courseDao.updateCourse(course);
		
		model.addAttribute("message", "Successfully vacated from : " + course.getCourseName());
		return "redirect:ViewCourses";
	}
	
	@RequestMapping("student/ViewProfile")
	public String goToViewProfile(HttpSession session, Model model, Principal principal){
		Student student = studentDao.getStudent(principal.getName());
		
		model.addAttribute("student", student);
		return "student/studentViewProfile";
	}
	
	@RequestMapping("student/editProfile")
	public String goToEditProfile(Model model, Principal principal){
		Student student = studentDao.getStudent(principal.getName());
		
		model.addAttribute("student", student);
		return "student/editProfile";
	}
	
	@RequestMapping("student/updateProfile")
	public String doUpdateProfile(Student student, Model model, Principal principal){
		Student oldStudent = studentDao.getStudent(principal.getName());
		
		oldStudent.setAddress(student.getAddress());
		oldStudent.setPhoneNumber(student.getPhoneNumber());
		oldStudent.setEmailAddress(student.getEmailAddress());
		
		studentDao.updateStudent(oldStudent);
		
		return "student/studentViewProfile";
	}
	
	@RequestMapping("student/changePassword")
	public String goToChangePassword(Model model, Principal principal){
		return "student/changePassword";
	}
	
	@RequestMapping("student/updatePassword")
	public String doChangePassword(@RequestParam String password, @RequestParam String newPassword, @RequestParam String confirmPassword, Model model, Principal principal){
		Student student = studentDao.getStudent(principal.getName());
		
		if (password.equals(student.getPassword())){
			if (newPassword.equals(confirmPassword)){
				student.setPassword(newPassword);
				studentDao.updateStudent(student);
				model.addAttribute("message", "Password successfully updated!");
				model.addAttribute("student", student);
				return "student/editProfile";
			}else{
				model.addAttribute("message", "Passwords do not match");
				return "student/changePassword";
			}
		}else{
			model.addAttribute("message", "Current password is incorrect");
			return "student/changePassword";
		}
	}
	
	@RequestMapping("student/ViewGrades")
	public String goToViewGrades(Model model, Principal principal){
		Student student = studentDao.getStudent(principal.getName());
		List<Course> listOfCourses = courseDao.getAllCoursesByStudent(student);
		List<Grade> listOfGrades = gradeDao.getAllGradesByStudent(student);
		
		model.addAttribute("courseList", listOfCourses);
		model.addAttribute("gradeList", listOfGrades);
		
		return "student/viewGrades";
	}
	
	@RequestMapping("student/searchCourse")
	public String doSearchCourse(@RequestParam String search, Model model, Principal principal){
		Student student = studentDao.getStudent(principal.getName());
		List<Course> enrolledCourseList = courseDao.getAllCoursesByStudent(student);
		
		List<Course> courseList = null;
		try{
			int code = Integer.parseInt(search);
			Course course = courseDao.getCourse(code);
			courseList = new ArrayList<Course>();
			courseList.add(course);
		}catch(NumberFormatException n){
			courseList = courseDao.getCourseByName(search);
		}
		
		model.addAttribute("enrolledCourses", enrolledCourseList);
		model.addAttribute("courseList", courseList);
		return "student/studentViewCourses";
	}
	
}
