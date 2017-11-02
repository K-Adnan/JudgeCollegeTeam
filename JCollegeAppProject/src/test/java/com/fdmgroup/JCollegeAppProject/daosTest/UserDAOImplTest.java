package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import com.fdmgroup.JCollegeAppProject.daos.UserDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.User;

public class UserDAOImplTest {

	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private UserDAOImpl userDao;
	private TypedQuery query;
	private List userlist;
	private User user;

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
		String username = new String();
		userDao.removeUser(username);
		when(manager.find(User.class, "user")).thenReturn(user);
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).remove(user);
	}
	
	@Test
	public void testGetUserGetsAUser() {
		UserDAOImpl userDao = new UserDAOImpl(factory); 
		User user = new User();
		when(manager.find(User.class, "user")).thenReturn(user);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).find(User.class, "user");

	}
}
//
//	@Test
//	public void testUpdateUserUpdatesAUser() {
//		UserDAOImpl userDao = new UserDAOImpl(factory);
//		User user = new User();
//
//		userDao.updateUser(user);
//
//		verify(transaction).begin();
//		verify(transaction).commit();
//		verify(manager).merge(user);
//	}
//	
//	@Test
//	public void testGetAllUsersReturnsUserList(){
//		when(manager.createQuery("select u from user u", User.class)).thenReturn(query);
//		when(query.getResultList()).thenReturn(userlist);
//		userDao = new UserDAOImpl(factory);
//		
//		verify(transaction).begin();
//		verify(transaction).commit();
//		assertEquals(query.getResultList(), userlist);
//	}
//
//}
