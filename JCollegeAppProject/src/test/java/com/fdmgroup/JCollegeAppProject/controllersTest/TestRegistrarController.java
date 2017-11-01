package com.fdmgroup.JCollegeAppProject.controllersTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
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

public class TestRegistrarController {
        
        RegistrarController registrarController;
        String username;
        int courseCode;
        
        @Mock
        Model model;
        HttpSession session;
        Principal principal;
        Grade grade;
        RedirectAttributes ra;
        CourseDAO courseDao;
        StudentDAO studentDao;
        Department department;
        Registrar registrar;
        ITAdmin itAdmin;
        ProfessorDAO professorDao;
        RegistrarDAO registrarDao;
        ITAdminDAO itAdminDao;
        GradeDAO gradeDao;
        Student student;
        Professor professor;
        ArrayList<Course> courseList;
        Course course;
        UserDAO userDao;
        User user;
        DepartmentDAO departmentDao;
        AbsenceDAO absenceDao;
        HttpServletRequest request;
        
        @Before
        public void setUp(){
                model = mock(Model.class);
                principal = mock(Principal.class);
                grade = mock(Grade.class);
                session = mock(HttpSession.class);
                itAdmin = mock(ITAdmin.class);
                department = mock(Department.class);
                ra = mock(RedirectAttributes.class);
                studentDao = mock(StudentDAO.class);
                courseDao = mock(CourseDAO.class);
                user = mock(User.class);
                registrar = mock(Registrar.class);
                request = mock(HttpServletRequest.class);
                gradeDao = mock(GradeDAO.class);
                itAdminDao = mock(ITAdminDAO.class);
                registrarDao = mock(RegistrarDAO.class);
                userDao = mock(UserDAO.class);
                departmentDao = mock(DepartmentDAO.class);
                professorDao = mock(ProfessorDAO.class);
                absenceDao = mock(AbsenceDAO.class);
                registrarController = new RegistrarController(courseDao, professorDao, studentDao, registrarDao, departmentDao, gradeDao, userDao, absenceDao);
                student = mock(Student.class);
                professor = mock(Professor.class);
                courseList = new ArrayList<Course>();
                course = mock(Course.class);
        }
        
        @Test
        public void test_GoToMyProfile_ReturnsRegistrarMyProfile(){
                RegistrarController r = new RegistrarController();
                assertEquals("registrar/MyProfile", registrarController.GoToMyProfile(principal, model));
        }
        
        @Test
        public void test_GoToSystemUsers_ReturnsRegistrarSystemUsers(){
                assertEquals("registrar/SystemUsers", registrarController.GoToSystemUsers(model));
        }
        
        @Test
        public void test_DoChooseUserP_ReturnsRegistrarViewAndUpdateStud_WhenUserIsStudent(){
                when(userDao.getUser(username)).thenReturn(student);
                assertEquals("registrar/ViewAndUpdateStud", registrarController.doChooseUserP(model, session, principal, username, request));
        }
        
        @Test
        public void test_DoChooseUserP_ReturnsRegistrarViewAndUpdateProf_WhenUserIsProfessor(){
                when(userDao.getUser(username)).thenReturn(professor);
                assertEquals("registrar/ViewAndUpdateProf", registrarController.doChooseUserP(model, session, principal, username, request));
        }
        
        @Test
        public void test_DoChooseUserP_ReturnsRedirectSystemUsers_WhenUserIsOtherThanProfessorAndStudent(){
                when(userDao.getUser(username)).thenReturn(registrar);
                assertEquals("redirect:SystemUsers", registrarController.doChooseUserP(model, session, principal, username, request));
        }
        
        @Test
        public void test_DoRemoveUser_ReturnsRedirectSystemUsers_WhenUserIsProfessor(){
                when(userDao.getUser(username)).thenReturn(professor);
                List<Course> list = new ArrayList<Course>();
                list.add(course);
                List<Grade> listGrades = new ArrayList<Grade>();
                listGrades.add(grade);
                when(courseDao.getAllCoursesByProfessor(professor)).thenReturn(list);
                when(gradeDao.getAllGradesByProfessor(professor)).thenReturn(listGrades);
                when(professor.getDepartment()).thenReturn(department);
                assertEquals("redirect:SystemUsers", registrarController.doRemoveUser(model, username, ra));
        }
        
        @Test
        public void test_DoRemoveUser_ReturnsRedirectSystemUsers_WhenUserIsProfessor_WithoutDepartment(){
                when(userDao.getUser(username)).thenReturn(professor);
                List<Course> list = new ArrayList<Course>();
                list.add(course);
                List<Grade> listGrades = new ArrayList<Grade>();
                listGrades.add(grade);
                when(courseDao.getAllCoursesByProfessor(professor)).thenReturn(list);
                when(gradeDao.getAllGradesByProfessor(professor)).thenReturn(listGrades);
                when(professor.getDepartment()).thenReturn(null);
                assertEquals("redirect:SystemUsers", registrarController.doRemoveUser(model, username, ra));
        }
        
        
        
        @Test
        public void test_DoRemoveUser_ReturnsRedirectSystemUsers_WhenUserIsStudent(){
                List<Course> list = new ArrayList<Course>();
                list.add(course);
                when(userDao.getUser(username)).thenReturn(student);
                when(courseDao.getAllCoursesByStudent(student)).thenReturn(list);
                assertEquals("redirect:SystemUsers", registrarController.doRemoveUser(model, username, ra));
        }
        
        @Test
        public void test_DoRemoveUser_ReturnsRedirectSystemUsers_WhenUserIsRegistrar(){
                when(userDao.getUser(username)).thenReturn(registrar);
                assertEquals("redirect:SystemUsers", registrarController.doRemoveUser(model, username, ra));
        }
        
        @Test
        public void test_EditInformationStud_ReturnsRegistrarEditInformationStud(){
                assertEquals("registrar/EditInformationStud", registrarController.EditInformationStud(model, session));
        }
        
        @Test
        public void test_DoRemoveFromCourse_ReturnsRedirectViewAndUpdate(){
                assertEquals("redirect:ViewAndUpdateStud", registrarController.DoRemoveFromCourse(username, model, "ABC"));
        }
        
        @Test
        public void test_GoToCourses_ReturnsRegistrarCourses(){
                List<Course> list = new ArrayList<Course>();
                list.add(course);
                when(courseDao.getAllCourses()).thenReturn(list);
                assertEquals("registrar/Courses", registrarController.goToCourses(model, "ABC"));
        }
        
        @Test
        public void test_CourseCancellation_ReturnsRedirectCourses(){
                List<Grade> list = new ArrayList<Grade>();
                list.add(grade);
                when(courseDao.getCourse(101)).thenReturn(course);
                when(gradeDao.getAllGradesByCourse(course)).thenReturn(list);
                assertEquals("redirect:Courses", registrarController.courseCancellation(101, model, ra));
        }
        
        @Test
        public void test_CourseUpdate_ReturnsRegistrarCourses(){
                List<Course> list = new ArrayList<Course>();
                List<Professor> listP = new ArrayList<Professor>();
                when(courseDao.getCourse(101)).thenReturn(course);
                when(courseDao.getAllCourses()).thenReturn(list);
                assertEquals("registrar/Courses", registrarController.courseUpdate("ABC", 101, model));
        }
        
        @Test
        public void test_CourseUpdate_ReturnsRegistrarCourses_WhenProfessorUsernameIsEmpty(){
                List<Course> list = new ArrayList<Course>();
                List<Professor> listP = new ArrayList<Professor>();
                when(courseDao.getCourse(101)).thenReturn(course);
                when(courseDao.getAllCourses()).thenReturn(list);
                assertEquals("registrar/Courses", registrarController.courseUpdate("empty", 101, model));
        }
        
        @Test
        public void test_DoChooseCourse_ReturnsRegistrarCourses(){
                List<Course> list = new ArrayList<Course>();
                List<Professor> listP = new ArrayList<Professor>();
                List<Student> listS = new ArrayList<Student>();
                when(courseDao.getCourse(101)).thenReturn(course);
                when(studentDao.getAllStudentsByCourse(course)).thenReturn(listS);
                when(courseDao.getAllCourses()).thenReturn(list);
                assertEquals("registrar/Courses", registrarController.doChooseCourse(model, 101));
        }
        
        @Test
        public void test_GoToAddCourse_ReturnsRegistrarAddCourse(){
                List<Course> list = new ArrayList<Course>();
                List<Professor> listP = new ArrayList<Professor>();
                when(courseDao.getCourse(101)).thenReturn(course);
                when(courseDao.getAllCourses()).thenReturn(list);
                assertEquals("registrar/AddCourse", registrarController.GoToAddCourse(model));
        }
        
        @Test
        public void test_DoAddCourse_ReturnsRegistrarCourses(){
                when(departmentDao.getDepartment(1)).thenReturn(department);
                List<Course> list = new ArrayList<Course>();
                List<Professor> listP = new ArrayList<Professor>();
                when(courseDao.getCourse(101)).thenReturn(course);
                when(courseDao.getAllCourses()).thenReturn(list);
                assertEquals("registrar/Courses", registrarController.DoAddCourse(model, course, 1));
        }
        
        @Test
        public void test_GoToGrades_ReturnsRegistrarGrades(){
                assertEquals("registrar/Grades", registrarController.GoToGrades());
        }
        
        @Test
        public void test_GoToAddAbsence_ReturnsRegistrarAddAbsence(){
                assertEquals("registrar/AddAbsence", registrarController.GoToAddAbsence(username, model));
        }
        
        @Test
        public void test_GoToAddTimetable_ReturnsRegistrarTimetable(){
                assertEquals("registrar/Timetable", registrarController.GoToTimetable());
        }
        
        @Test
        public void test_EditInformationProf_ReturnsRegistrarEditInformationStud(){
                assertEquals("registrar/EditInformationProf", registrarController.EditInformationProf(model, session));
        }
        
        @Test
        public void test_DoAddAbsence_ReturnsRegistrarViewAndUpdateStud(){
                List<Course> list = new ArrayList<Course>();
                List<Professor> listP = new ArrayList<Professor>();
                when(courseDao.getCourse(101)).thenReturn(course);
                when(courseDao.getAllCourses()).thenReturn(list);
                assertEquals("registrar/ViewAndUpdateStud", registrarController.doAddAbsence(username, "ABC", "11/11/2011", model));
        }
        
        @Test
        public void test_DoAddAbsence_ReturnsRegistrarViewAndUpdateStud_WhenDateIsNotParseable(){
                List<Course> list = new ArrayList<Course>();
                List<Professor> listP = new ArrayList<Professor>();
                when(courseDao.getCourse(101)).thenReturn(course);
                when(courseDao.getAllCourses()).thenReturn(list);
                assertEquals("registrar/ViewAndUpdateStud", registrarController.doAddAbsence(username, "ABC", "e11/11/2011", model));
        }
        
}
