package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;
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

	@Override
	public List<User> getAllUsersByProfessor(Professor professor) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> query = manager.createQuery("select u FROM User as u join fetch u.professorList p WHERE p.username =?", User.class);
        query.setParameter(1, professor.getUsername());
		List<User> userList = query.getResultList();
		manager.close();
		return userList;
	}

	@Override
	public List<User> getAllUsersByStudent(Student student) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> query = manager.createQuery("select u FROM User as u join fetch u.studentList s WHERE s.username =?", User.class);
        query.setParameter(1, student.getUsername());
		List<User> userList = query.getResultList();
		manager.close();
		return userList;
	}

	@Override
	public List<User> getAllUsersByRegistrar(Registrar registrar) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> query = manager.createQuery("select u FROM User as u join fetch u.registrarList r WHERE r.username =?", User.class);
        query.setParameter(1, registrar.getUsername());
		List<User> userList = query.getResultList();
		manager.close();
		return userList;
	}

	@Override
	public List<User> getAllUsersByITAdmin(ITAdmin itAdmin) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> query = manager.createQuery("select u FROM User as u join fetch u.itAdminList i WHERE i.username =?", User.class);
        query.setParameter(1, itAdmin.getUsername());
		List<User> userList = query.getResultList();
		manager.close();
		return userList;
	}
	
	
	

}
