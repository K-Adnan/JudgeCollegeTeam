package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Profile;

public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	private EntityManagerFactory factory;

	public ProfileDAOImpl() {
	}

	public ProfileDAOImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public void addProfile(Profile profile) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(profile);
		manager.getTransaction().commit();
	}

	@Override
	public void removeProfile(String username) {
		EntityManager manager = factory.createEntityManager();
		Profile profile = manager.find(Profile.class, username);
		manager.getTransaction().begin();
		manager.remove(profile);
		manager.getTransaction().commit();
	}

	@Override
	public void updateProfile(Profile profile) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(profile);
		manager.getTransaction().commit();
	}

	@Override
	public Profile getProfile(String username) {
		EntityManager manager = factory.createEntityManager();
		Profile profile = manager.find(Profile.class, username);
		manager.close();
		return profile;
	}

	@Override
	public List<Profile> getAllProfiles() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Profile> query = manager.createQuery("FROM Profile p", Profile.class);
		List<Profile> profileList = query.getResultList();
		manager.close();
		return profileList;
	}

}
