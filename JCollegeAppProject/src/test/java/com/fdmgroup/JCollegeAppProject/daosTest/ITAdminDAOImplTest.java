package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import com.fdmgroup.JCollegeAppProject.daos.ITAdminDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.UserDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.User;

public class ITAdminDAOImplTest {
	
	private String username;
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private ITAdminDAOImpl itadminDao;
	private TypedQuery query;
	private List list;
	private User user;

	@Before
	public void setUp() {
		manager = mock(EntityManager.class);
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		query = mock(TypedQuery.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		itadminDao = new ITAdminDAOImpl(factory);
		
	}
	@Test
	public void testGetITAdminReturnsITAdmin(){
		itadminDao.getITAdmin(username);
		verify(manager).find(User.class, username);
		
//	}
//	@Test 
//	public void testUpdateITAdminUpdatesITAdmin(){
//		ITAdmin itadmin = new ITAdmin();
//		itadminDao.updateITAdmin(itAdmin);
//		verify(manager).merge(itadmin);
//	}
	
	}
}
