package com.fdmgroup.JCollegeAppProject.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;

public class ITAdminDAOImpl implements ITAdminDAO {

	private EntityManagerFactory factory;

	public ITAdminDAOImpl(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	public ITAdminDAOImpl() {
		super();
	}
	@Override
	public ITAdmin getITAdmin(int ITAdminId) {
		EntityManager manager = factory.createEntityManager();
		ITAdmin itadmin = manager.find(ITAdmin.class, ITAdminId);
		return itadmin;
	}

}
