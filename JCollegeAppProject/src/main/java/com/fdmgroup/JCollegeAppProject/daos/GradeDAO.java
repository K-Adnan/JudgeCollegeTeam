package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Grade;

public interface GradeDAO {
	
	public void addGrade (Grade grade);
	public void removeGrade (int GradeId);
	public void updateGrade (Grade grade);
	public Grade getGrade (int GradeId);
	public List <Grade> getAllGrades();
	public List <Grade> getAllGradesByStudent();
	public List <Grade> getAllGradesByProfessor();
}

