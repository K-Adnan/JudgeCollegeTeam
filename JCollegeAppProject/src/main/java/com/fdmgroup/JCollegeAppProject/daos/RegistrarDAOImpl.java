package com.fdmgroup.JCollegeAppProject.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Registrar;

public class RegistrarDAOImpl implements RegistrarDAO {

	@Autowired
	private EntityManagerFactory factory;

	public RegistrarDAOImpl(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	public RegistrarDAOImpl() {
		super();
	}
	@Override
	public Registrar getRegistrar(String username) {
		EntityManager manager = factory.createEntityManager();
		Registrar registrar = manager.find(Registrar.class, username);
		return registrar;
	}

	@Override
	public void updateRegistrar(Registrar registrar) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(registrar);
		manager.getTransaction().commit();
	}

}
