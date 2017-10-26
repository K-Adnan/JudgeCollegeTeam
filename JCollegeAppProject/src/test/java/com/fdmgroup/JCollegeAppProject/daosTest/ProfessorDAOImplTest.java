package com.fdmgroup.JCollegeAppProject.daosTest;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;


import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Professor;

public class ProfessorDAOImplTest {

	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private ProfessorDAOImpl professorDao;

	@Before
	public void setUp() {
		manager = mock(EntityManager.class);
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		professorDao = new ProfessorDAOImpl(factory);
	}

	public void testAddProfessorAddsAProfessor() {
		Professor professor = new Professor();
		professorDao.addProfessor(professor);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(professor);
	}

	public void testRemoveProfessorRemovesAProfessor() {
		Professor professor = new Professor();

		when(manager.find(Professor.class, 47)).thenReturn(professor);

//		professorDao.removeProfessor(47);

	}

	public void testGetProfessorGetsAProfessor() {
		ProfessorDAOImpl professorDao = new ProfessorDAOImpl(factory);
		Professor professor = new Professor();
		when(manager.find(Professor.class, 47)).thenReturn(professor);

//		professorDao.getProfessor(47);

	}

	public void testUpdateProfessorUpdatesAProfessor() {
		ProfessorDAOImpl professorDao = new ProfessorDAOImpl(factory);
		Professor professor = new Professor();

		professorDao.updateProfessor(professor);

		verify(manager).merge(professor);

	}

}
