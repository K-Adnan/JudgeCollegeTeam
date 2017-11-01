package com.fdmgroup.JCollegeAppProject.daosTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Professor;


public class ProfessorDAOImplTest {



	private EntityManagerFactory factory;
	private EntityManager manager;
	private EntityTransaction transaction;
	private ProfessorDAOImpl professorDao;
	private Professor professor;
	
//	private TypedQuery <Manager> mquery;
//	private TypedQuery <Donor> dquery;

	
	@Before
	public void setUp(){
		
		factory = mock(EntityManagerFactory.class);
		manager = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
		when(factory.createEntityManager()).thenReturn(manager); 
		when(manager.getTransaction()).thenReturn(transaction);
		professorDao = new ProfessorDAOImpl (factory);
		
	}
	

	
	@Test
	public void test_addProfessor_invokesTransactionMethodsAndPersist() {
		Professor p = new Professor ();
		professorDao.addProfessor(p);	
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(p);	
	}

	
	@Test
	public void test_removeProfessor_invokesTransactionMethodsAndInvokesRemove() {
	
		Professor p = new Professor();
		professorDao.removeProfessor(p.getUsername());
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).remove(p.getUsername());	
		
	}
	
	
	
	@Test
	public void testUpdateProfessorUpdatesAProfessor() {
		
		Professor p = new Professor();
		professorDao.updateProfessor(p);
		verify(manager).merge(p);

	}
	
	
	@Test
	public void test_getProfessor_invokesFind() {
		professorDao.getProfessor("username");
		verify(manager).find(Professor.class, "username");
	}

	@Test 
	public void test_getProfessor_returnsProfessorObjectReturnedByFind() { 
															
		Professor p = new Professor();
		
		when(manager.find(Professor.class, 1)).thenReturn(p);
		
		Professor professorRetrieved = professorDao.getProfessor("username");
	
		assertEquals(p, professorRetrieved);

	}

	
	
	

	
	
}
