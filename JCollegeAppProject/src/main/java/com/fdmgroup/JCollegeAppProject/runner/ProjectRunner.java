package com.fdmgroup.JCollegeAppProject.runner;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Professor;

public class ProjectRunner {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoPersistence");
		
		CourseDAO courseDao = new CourseDAOImpl(factory);
		StudentDAO studentDao = new StudentDAOImpl(factory);
		GradeDAO gradeDao = new GradeDAOImpl(factory);
		ProfessorDAO professorDao = new ProfessorDAOImpl(factory);
		
		Professor professor = professorDao.getProfessor("professor");
		System.out.println(courseDao.getAllCoursesByProfessor(professor));
		
		factory.close();
	}

}
