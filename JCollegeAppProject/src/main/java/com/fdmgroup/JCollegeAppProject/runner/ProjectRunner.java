package com.fdmgroup.JCollegeAppProject.runner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProjectRunner {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceInCreateMode");
		
		factory.close();
	}

}
