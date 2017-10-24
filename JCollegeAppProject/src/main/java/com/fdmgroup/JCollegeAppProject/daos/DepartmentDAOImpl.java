package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.fdmgroup.JCollegeAppProject.entities.Department;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	private EntityManagerFactory factory;

	public void addDepartment(Department department) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(department);
		manager.getTransaction().commit();
	}

	public void updateDepartment(Department department) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(department);
		manager.getTransaction().commit();
	}

	public void removeDepartment(int id) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Department department = manager.find(Department.class, id);
		manager.remove(department);
		manager.getTransaction().commit();
	}

	public Department getDepartment(int id) {
		EntityManager manager = factory.createEntityManager();
		Department department = manager.find(Department.class, id);
		return department;
	}

	public List<Department> getAllDepartment() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Department> query = manager.createQuery("select d from Department d", Department.class);
		List<Department> departmentList = query.getResultList();
		manager.close();
		return departmentList;
	}

}
