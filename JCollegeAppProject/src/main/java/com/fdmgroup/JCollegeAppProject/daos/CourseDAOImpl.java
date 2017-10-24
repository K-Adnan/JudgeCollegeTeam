package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;

public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private EntityManagerFactory factory;

	public CourseDAOImpl() {
	}

	public CourseDAOImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addCourse(Course course) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(course);
		manager.getTransaction().commit();
	}

	@Override
	public void removeCourse(int courseId) {
		EntityManager manager = factory.createEntityManager();
		Course course = manager.find(Course.class, courseId);
		manager.getTransaction().begin();
		manager.remove(course);
		manager.getTransaction().commit();
	}

	@Override
	public void updateCourse(Course course) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(course);
		manager.getTransaction().commit();
	}

	@Override
	public Course getCourse(int courseId) {
		EntityManager manager = factory.createEntityManager();
		Course course = manager.find(Course.class, courseId);
		manager.close();
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Course> query = manager.createQuery("FROM Course c", Course.class);
		List<Course> courseList = query.getResultList();
		manager.close();
		return courseList;
	}

	@Override
	public List<Course> getAllCoursesByDepartment(Department department) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Course> query = manager.createQuery("FROM Course c WHERE c.department=?", Course.class);
		query.setParameter(1, department);
		List<Course> courseList = query.getResultList();
		manager.close();
		return courseList;
	}

}
