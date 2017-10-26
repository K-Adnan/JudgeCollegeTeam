package com.fdmgroup.JCollegeAppProject.runner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAOImpl;

public class ProjectRunner {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoPersistence");
		
		CourseDAO courseDao = new CourseDAOImpl(factory);
		StudentDAO studentDao = new StudentDAOImpl(factory);
		GradeDAO gradeDao = new GradeDAOImpl(factory);
		
//		System.out.println(gradeDao.getAllGradesByStudent(studentDao.getStudent("student")));
		System.out.println(studentDao.getAllStudentsByCourse(courseDao.getCourse(101)));
		
		factory.close();
	}

}
