package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Absence;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class AbsenceDAOImpl implements AbsenceDAO {

	@Autowired
	private EntityManagerFactory factory;

	public AbsenceDAOImpl() {
	}

	public AbsenceDAOImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addAbsence(Absence absence) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(absence);
		manager.getTransaction().commit();
	}

	@Override
	public void removeAbsence (int absenceId) {
		EntityManager manager = factory.createEntityManager();
		Absence absence = manager.find(Absence.class, absenceId);
		manager.getTransaction().begin();
		manager.remove(absence);
		manager.getTransaction().commit();
	}

	@Override
	public void updateAbsence(Absence absence) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(absence);
		manager.getTransaction().commit();
	}

	@Override
	public Absence getAbsence(int absenceId) {
		EntityManager manager = factory.createEntityManager();
		Absence absence = manager.find(Absence.class, absenceId);
		return absence;
	}

}

