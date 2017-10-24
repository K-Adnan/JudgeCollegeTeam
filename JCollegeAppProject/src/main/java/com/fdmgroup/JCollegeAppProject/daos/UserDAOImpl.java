package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.User;

public class UserDAOImpl implements UserDAO {

	@Autowired
	private EntityManagerFactory factory;

	public UserDAOImpl() {
	}

	public UserDAOImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public void addUser(User user) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
	}

	@Override
	public void removeUser(String username) {
		EntityManager manager = factory.createEntityManager();
		User user = manager.find(User.class, username);
		manager.getTransaction().begin();
		manager.remove(user);
		manager.getTransaction().commit();
	}

	@Override
	public void updateUser(User user) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(user);
		manager.getTransaction().commit();
	}

	@Override
	public User getUser(String username) {
		EntityManager manager = factory.createEntityManager();
		User user = manager.find(User.class, username);
		manager.close();
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> query = manager.createQuery("FROM User p", User.class);
		List<User> userList = query.getResultList();
		manager.close();
		return userList;
	}

}
