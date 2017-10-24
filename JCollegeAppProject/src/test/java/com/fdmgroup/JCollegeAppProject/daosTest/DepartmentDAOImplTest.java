package com.fdmgroup.JCollegeAppProject.daosTest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;

import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAOImpl;

public class DepartmentDAOImplTest {

	private EntityManagerFactory factory;
	private EntityManager manager;
	private EntityTransaction transaction;
	private DepartmentDAOImpl departmentDao;
	private TypedQuery query;
	private List list;

	@Before
	public void setUp() {
		factory = mock(EntityManagerFactory.class);
		manager = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
		query = mock(TypedQuery.class);
	}

}
