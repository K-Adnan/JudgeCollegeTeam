package com.fdmgroup.JCollegeAppProject.controllersTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import com.fdmgroup.JCollegeAppProject.controllers.ProfessorController;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;




public class ProfessorControllerTest {
	
	ProfessorController professorController;
	String username;
	int courseCode;

	
	
	@Mock
	Model model;
    HttpSession session;
    Principal principal;
    CourseDAO courseDao;
    ProfessorDAO professorDao;
    StudentDAO studentDao;
    DepartmentDAO departmentDao;
    GradeDAO gradeDao;
    Professor professor;
    ArrayList<Course> courseList;
    ArrayList<Student> studentList;
    Course course;
	
	@Before
	public void setUp(){
		model = mock(Model.class);
        principal = mock(Principal.class);
        session = mock(HttpSession.class);
        professorDao = mock(ProfessorDAO.class);
        courseDao = mock(CourseDAO.class);
        gradeDao = mock(GradeDAO.class);
        studentDao = mock(StudentDAO.class);
        departmentDao = mock(DepartmentDAO.class);
        professorController = new ProfessorController(professorDao, studentDao, departmentDao, gradeDao, courseDao);
        professor = mock(Professor.class);
        courseList = new ArrayList<Course>();
        course = mock(Course.class);
        studentList = new ArrayList<Student>();
	}
	
	
	@Test
	public void testGoToShowCoursesShowsTheCourses(){
		 when(principal.getName()).thenReturn(username);
		 when(professorDao.getProfessor(username)).thenReturn(professor);
		 when(courseDao.getAllCoursesByProfessor(professor)).thenReturn(courseList);
		 assertEquals("professor/professorViewCourses", professorController.goToShowCourses(model, principal));
	}
	
	@Test
	public void testProcessChooseCourseAllowsYouToChooseACourse(){
		when(principal.getName()).thenReturn(username);
		when(professorDao.getProfessor(username)).thenReturn(professor);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(course.getCourseName()).thenReturn("Darryl");
		assertEquals("redirect:viewCourses", professorController.processChooseCourse(model, courseCode, principal));		
	}
	
	@Test
	public void testGoToTaughtCoursesGoesToTheTaughtCourses() {
		when(principal.getName()).thenReturn(username);
        when(professorDao.getProfessor(username)).thenReturn(professor);
        assertEquals("professor/professorViewCourses", professorController.goToTaughtCourses(model, session, principal));
		}
	
	@Test
	public void testProcessTaughtCoursesProcessesTheTaughtCourses(){
		when(principal.getName()).thenReturn(username);
        when(professorDao.getProfessor(username)).thenReturn(professor);
        when(courseDao.getCourse(courseCode)).thenReturn(course);
        when(course.getCourseName()).thenReturn("Chizh");
        assertEquals("professor/professorViewCourses", professorController.processTaughtCourses(session, principal));
		}
	
	@Test
	public void testProcessShowStudentsShowsTheStudents(){
		when(studentDao.getAllStudents()).thenReturn(studentList);
		assertEquals("professor/professorViewStudents", professorController.processShowStudents());
		}
	
	@Test
	public void testViewProfileGoesToViewProfiles(){
		when(principal.getName()).thenReturn(username);
		when(professorDao.getProfessor(username)).thenReturn(professor);
		assertEquals("professor/professorViewProfile", professorController.goToViewProfile(model, principal));
	}
	

}
