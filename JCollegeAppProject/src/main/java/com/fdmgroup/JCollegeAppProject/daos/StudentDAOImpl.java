package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;


public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private EntityManagerFactory factory;

	public StudentDAOImpl() {
	}

	public StudentDAOImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addStudent(Student student) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(student);
		manager.getTransaction().commit();
	}

	@Override
	public void removeStudent(int studentId) {
		EntityManager manager = factory.createEntityManager();
		Student student = manager.find(Student.class, studentId);
		manager.getTransaction().begin();
		manager.remove(student);
		manager.getTransaction().commit();
	}

	@Override
	public void updateStudent(Student student) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(student);
		manager.getTransaction().commit();
	}

	@Override
	public Student getStudent(int studentId) {
		EntityManager manager = factory.createEntityManager();
		Student student = manager.find(Student.class, studentId);
		manager.close();
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Student> query = manager.createQuery("FROM Student s", Student.class);
		List<Student> studentList = query.getResultList();
		manager.close();
		return studentList;
	}

	@Override
	public List<Student> getAllStudentsByProfessor(Professor professor) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Student> query = manager.createQuery("FROM Student s WHERE s.professor =?", Student.class);
		query.setParameter(1, professor);
		List<Student> studentList = query.getResultList();
		manager.close();
		return studentList;
	}

	@Override
	public List<Student> getAllStudentsByCourse(Course course) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Student> query = manager.createQuery("FROM Student s WHERE s.course =?", Student.class);
		query.setParameter(1, course);
		List<Student> studentList = query.getResultList();
		manager.close();
		return studentList;
	}

}
