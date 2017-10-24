package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.JCollegeAppProject.daos.UserDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.User;

public class UserDAOImplTest {

	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private UserDAOImpl userDao;

	@Before
	public void setUp() {
		manager = mock(EntityManager.class);
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		userDao = new UserDAOImpl(factory);
	}

	@Test
	public void testAddUserAddsAUser() {
		User user = new User();
		userDao.addUser(user);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(user);
	}

	@Test
	public void testRemoveUserRemovesAUser() {
		p
         
            causeDao.removeCause(cause);

            verify(transaction).begin();
            verify(transaction).commit();
            verify(manager).remove(cause);

		
		
		User user = new User();	
		
		userDao.removeUser("luffy");
		
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).remove(user);
		

	}

	@Test
	public void testGetUserGetsAUser() {
		User user = new User();
		when(manager.find(User.class, "Doflamingo")).thenReturn(user);
		userDao.removeUser("Doflamingo");
		
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).merge(user);
		

	}

	@Test
	public void testUpdateUserUpdatesAUser() {
		UserDAOImpl userDao = new UserDAOImpl(factory);
		User user = new User();

		userDao.updateUser(user);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).merge(user);

	}

}
