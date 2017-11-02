package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import com.fdmgroup.JCollegeAppProject.daos.GradeDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.UserDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

public class GradeDAOImplTest {
	
	private String username;
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private GradeDAOImpl gradeDao;
	private TypedQuery query;
	private List list;
	private Grade grade;
	private Student student;
	private Professor professor;
	private Course course;

	@Before
	public void setUp() {
		manager = mock(EntityManager.class);
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		query = mock(TypedQuery.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		gradeDao = new GradeDAOImpl(factory);
		
	}
	@Test
	public void testAddGradeAddsAGrade() {
		Grade grade = new Grade();
		gradeDao.addGrade(grade);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(grade);
	}

	@Test
	public void testRemoveGradeRemovesAGrade() {
		gradeDao.removeGrade(1);
		when(manager.find(Grade.class, 1)).thenReturn(grade);
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).remove(grade);
	}
	@Test
	public void testUpdateGradeUpdatesAGrade() {
		Grade grade = new Grade();
		gradeDao.updateGrade(grade);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).merge(grade);
	}
	
	@Test
	public void testGetGradeGetsAGrade() {
		gradeDao.getGrade(1);
		verify(manager).find(Grade.class, 1);
	}
	@Test
	public void testGetAllGradesReturnsGradeList(){
		List<Grade> list = new ArrayList <Grade>();
		when(manager.createQuery("FROM Grade g", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, gradeDao.getAllGrades());
	}
	@Test
	public void testGetAllGradesByStudenReturnsGradesByStudents(){
		List<User> list = new ArrayList <User>();
		when(manager.createQuery("SELECT g FROM Grade g WHERE g.student=?", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, gradeDao.getAllGradesByStudent(student));
	}
	@Test
	public void testGetAllGradesByProfessorReturnsGradesByProfessors(){
		List<User> list = new ArrayList <User>();
		when(manager.createQuery("FROM Grade g WHERE g.professor.username =?", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, gradeDao.getAllGradesByProfessor(professor));
	}
	@Test
	public void testGetAllGradesByCourseReturnsGradesByCourses(){
		List<User> list = new ArrayList <User>();
		when(manager.createQuery("FROM Grade g WHERE g.course.courseCode =?", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, gradeDao.getAllGradesByCourse(course));
	}
	
	

	

	
	
}
