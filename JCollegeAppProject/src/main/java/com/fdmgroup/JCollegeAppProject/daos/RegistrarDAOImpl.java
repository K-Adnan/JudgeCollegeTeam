package com.fdmgroup.JCollegeAppProject.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.JCollegeAppProject.entities.Registrar;

public class RegistrarDAOImpl implements RegistrarDAO {

	private EntityManagerFactory factory;

	public RegistrarDAOImpl(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	public RegistrarDAOImpl() {
		super();
	}
	@Override
	public Registrar getRegistrar(int registrarId) {
		EntityManager manager = factory.createEntityManager();
		Registrar registrar = manager.find(Registrar.class, registrarId);
		return registrar;
	}

}
