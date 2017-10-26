package com.fdmgroup.JCollegeAppProject.runner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class ProjectRunner {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoPersistence");
		
		CourseDAO courseDao = new CourseDAOImpl(factory);
		StudentDAO studentDao = new StudentDAOImpl(factory);
		
		System.out.println(courseDao.getAllNonEnrolledCoursesByStudent(studentDao.getStudent("student")));
		
		
		
		
		factory.close();
	}

}
