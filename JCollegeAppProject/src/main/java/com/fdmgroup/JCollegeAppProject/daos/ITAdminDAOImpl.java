package com.fdmgroup.JCollegeAppProject.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;

public class ITAdminDAOImpl implements ITAdminDAO {

	@Autowired
	private EntityManagerFactory factory;

	public ITAdminDAOImpl(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	public ITAdminDAOImpl() {
		super();
	}
	@Override
	public ITAdmin getITAdmin(String username) {
		EntityManager manager = factory.createEntityManager();
		ITAdmin itadmin = manager.find(ITAdmin.class, username);
		manager.close();
		return itadmin;
	}
	
	public void updateITAdmin(ITAdmin itAdmin){
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(itAdmin);
		manager.getTransaction().commit();
	}

}
