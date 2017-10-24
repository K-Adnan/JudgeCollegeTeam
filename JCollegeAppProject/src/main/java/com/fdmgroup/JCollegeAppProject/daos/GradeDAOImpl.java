package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.fdmgroup.JCollegeAppProject.entities.Grade;

public class GradeDAOImpl implements GradeDAO {
	
	private EntityManagerFactory factory;
	
	

	public GradeDAOImpl(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	public GradeDAOImpl() {
		super();
	}

	@Override
	public void addGrade(Grade grade) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(grade);
		manager.getTransaction().commit();
	}

	@Override
	public void removeGrade(int gradeId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Grade grade = manager.find(Grade.class, gradeId);
		manager.remove(grade);
		manager.getTransaction().commit();
	}

	@Override
	public void updateGrade(Grade grade) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(grade);
		manager.getTransaction().commit();
		
	}

	@Override
	public Grade getGrade(int gradeId) {
		EntityManager manager = factory.createEntityManager();
		Grade grade = manager.find(Grade.class, gradeId);
		return null;
	}

	@Override
	public List<Grade> getAllGrades() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery <Grade> query = manager.createQuery("FROM Grades", Grade.class);
		return null;
	}

	@Override
	public List<Grade> getAllGradesByStudent() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Grade> query = manager.createQuery("FROM Grades g WHERE g.student =?", Grade.class);
		List <Grade> gradeList = query.getResultList();
		manager.close();
		return gradeList;
	}

	@Override
	public List<Grade> getAllGradesByProfessor() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Grade> query = manager.createQuery("FROM Grades g WHERE g.professsor =?", Grade.class);
		List <Grade> gradeList = query.getResultList();
		manager.close();
		return gradeList;
	}

}
