package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.JCollegeAppProject.daos.RegistrarDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;

public class RegistrarDAOImplTest {

	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private RegistrarDAOImpl registrarDao;

	@Before
	public void setUp() {
		manager = mock(EntityManager.class);
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		registrarDao = new RegistrarDAOImpl(factory);
	}

	@Test
	public void testAddRegistrarAddsARegistrar() {
		Registrar registrar = new Registrar();
		registrarDao.addRegistrar(registrar);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(registrar);
	}

	@Test
	public void testRemoveRegistrarRemovesARegistrar() {
		Registrar registrar = new Registrar();
		registrarDao.removeRegistrar(registrar.getUsername());
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).remove(registrar.getUsername());
	}

	@Test
	public void testGetRegistrarInvokesFind() {
		registrarDao.getRegistrar("username");
		when(manager.find(Registrar.class, "username"));
	}

	@Test
	public void testGetRegistrarGetsARegistrar() {

		Registrar registrar = new Registrar();
		when(manager.find(Registrar.class, "username")).thenReturn(registrar);
		Registrar foundRegistrar = registrarDao.getRegistrar("username");
		assertEquals(registrar, foundRegistrar);
	}

	@Test
	public void testUpdateRegistrarUpdatesARegistrar() {
		Registrar registrar = new Registrar();
		registrarDao.updateRegistrar(registrar);
		verify(manager).merge(registrar);
	}

}
