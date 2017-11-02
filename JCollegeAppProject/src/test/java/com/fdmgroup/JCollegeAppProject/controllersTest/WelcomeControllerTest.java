package com.fdmgroup.JCollegeAppProject.controllersTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fdmgroup.JCollegeAppProject.controllers.RegistrarController;
import com.fdmgroup.JCollegeAppProject.daos.AbsenceDAO;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.ITAdminDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.RegistrarDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.daos.UserDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import com.fdmgroup.JCollegeAppProject.controllers.StudentController;
import com.fdmgroup.JCollegeAppProject.controllers.WelcomeController;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class WelcomeControllerTest {
        
        WelcomeController welcomeController;
        String username = "ABC";
        int courseCode;
        
        @Mock
        Model model;
        HttpSession session;
        Principal principal;
        CourseDAO courseDao;
        UserDAO userDao;
        StudentDAO studentDao;
        RegistrarDAO registrarDao;
        ProfessorDAO professorDao;
        ITAdminDAO itAdminDao;
        GradeDAO gradeDao;
        Student student;
        Professor professor;
        Registrar registrar;
        ITAdmin itadmin;
        ArrayList<Course> courseList;
        Course course;
        HttpServletRequest request;
       
        
        @Before
        public void setUp(){
                model = mock(Model.class);
                principal = mock(Principal.class);
                session = mock(HttpSession.class);
                userDao = mock(UserDAO.class);
                studentDao = mock(StudentDAO.class);
                professorDao = mock(ProfessorDAO.class);
                registrarDao = mock (RegistrarDAO.class);
                courseDao = mock(CourseDAO.class);
                gradeDao = mock(GradeDAO.class);
                itAdminDao = mock(ITAdminDAO.class);
                welcomeController = new WelcomeController(studentDao, professorDao, itAdminDao, registrarDao, userDao);
                student = mock(Student.class);
                professor = mock(Professor.class);
                registrar = mock(Registrar.class);                
                courseList = new ArrayList<Course>();
                course = mock(Course.class);
                request = mock(HttpServletRequest.class);
                
        }
        
        @Test
        public void testToIndex(){
        	String pageName = welcomeController.goToIndex();
        	assertEquals("redirect:/", welcomeController.goBackToIndex());
        }
        
        @Test
        public void testToLoginFailureReturnsLoginFailure(){
        	String pageName = welcomeController.goToLoginFailure(username, model);
        	assertEquals("index", welcomeController.goToLoginFailure(username, model));
        }
        
        @Test
        public void testToLoginReturnsRedirect(){
        	String pageName = welcomeController.goToLogin(model, session, principal, request);
        	assertEquals("redirect:/", welcomeController.goToLogin(model, session, principal, request));
        }
        
        @Test
        public void testToStudentHomeReturnsStudentHome(){
        	String pageName = welcomeController.goToStudentHome(session);
        	when (studentDao.getStudent(pageName)).thenReturn(student);
        	assertEquals("student/studentHome", welcomeController.goToStudentHome(session));
        }
        
        @Test
        public void testToGoProfessorHomeReturnsProfessorHome(){
        	String pageName = welcomeController.goToProfessorHome(session);
        	when(professorDao.getProfessor(pageName)).thenReturn(professor);
        	assertEquals("professor/professorHome", welcomeController.goToProfessorHome(session));
        }
        
        @Test
        public void testGoToRegistrarHomeReturnsRegistrarHome(){
        	String pageName = welcomeController.goToRegistrarHome(session);
        	when(session.getAttribute("username")).thenReturn(username);
        	when(registrarDao.getRegistrar(username)).thenReturn(registrar);
        	assertEquals("redirect:MyProfile", welcomeController.goToRegistrarHome(session));
        	
        }
        
        @Test
        public void testGoToITAdminHomeReturnITAdminHome(){
        	String pageName = welcomeController.goToITAdminHome(session);
        	when(itAdminDao.getITAdmin(pageName)).thenReturn(itadmin);
        	assertEquals("itadmin/itadminHome", welcomeController.goToITAdminHome(session));
        	
        }
        
        @Test
        public void testLogOutReturnsRedirect(){
        	String pageName = welcomeController.doLogOut(session);
        	verify(session).invalidate();
        	assertEquals("redirect:/", welcomeController.doLogOut(session));
        	
        }
        
        @Test
        public void testGoToForgotPasswordReturnsForgottenPassword(){
        	String pageName = welcomeController.goToForgotPassword();
        	assertEquals("forgotPassword", welcomeController.goToForgotPassword());
        }
        
        @Test
        public void testGoToResetPasswordRedirectsConfirmPasswordReset(){
        	String pageName = welcomeController.doResetPassword(username);
        	when(userDao.getUser(username)).thenReturn(null);
        	assertEquals("confirmPasswordReset", welcomeController.doResetPassword(username));
        }
        	
}


        
