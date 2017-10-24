package com.fdmgroup.JCollegeAppProject.daosTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;

public class CourseDAOImplTest {

	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private CourseDAOImpl courseDao;

	@Before
	public void setUp() {
		manager = mock(EntityManager.class);
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		courseDao = new CourseDAOImpl(factory);
	}

	@Test
	public void testAddCourseAddsACourse() {
		Course course = new Course();
		courseDao.addCourse(course);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(course);
	}

	@Test
	public void testRemoveCourseRemovesACourse() {
		Course course = new Course();

		when(manager.find(Course.class, 47)).thenReturn(course);

		courseDao.removeCourse(47);

	}

	@Test
	public void testGetCourseGetsACourse() {
		CourseDAOImpl courseDao = new CourseDAOImpl(factory);
		Course course = new Course();
		when(manager.find(Course.class, 47)).thenReturn(course);

		courseDao.getCourse(47);

	}

	@Test
	public void testUpdateCourseUpdatesACourse() {
		CourseDAOImpl courseDao = new CourseDAOImpl(factory);
		Course course = new Course();

		courseDao.updateCourse(course);

		verify(manager).merge(course);

	}

}
