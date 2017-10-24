package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.JCollegeAppProject.daos.StudentDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class StudentDAOImplTest {

	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private StudentDAOImpl studentDao;

	@Before
	public void setUp() {
		manager = mock(EntityManager.class);
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		studentDao = new StudentDAOImpl(factory);
	}

	@Test
	public void testAddStudentAddsAStudent() {
		Student student = new Student();
		studentDao.addStudent(student);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(student);
	}

	@Test
	public void testRemoveStudentRemovesAStudent() {
		Student student = new Student();

		when(manager.find(Student.class, 47)).thenReturn(student);

		studentDao.removeStudent(47);

	}

	@Test
	public void testGetStudentGetsAStudent() {
		StudentDAOImpl studentDao = new StudentDAOImpl(factory);
		Student student = new Student();
		when(manager.find(Student.class, 47)).thenReturn(student);

		studentDao.getStudent(47);

	}

	@Test
	public void testUpdateStudentUpdatesAStudent() {
		StudentDAOImpl studentDao = new StudentDAOImpl(factory);
		Student student = new Student();

		studentDao.updateStudent(student);

		verify(manager).merge(student);

	}

}
