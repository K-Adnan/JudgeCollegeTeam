package com.fdmgroup.JCollegeAppProject.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {
	
	@Id
	@SequenceGenerator(name = "departmentid_sequence", sequenceName = "departmentid", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentid_sequence")
	private int departmentId;
	private String departmentName;
	private List<Course> listOfCourses;
	private List<Professor> listOfProfessors;
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Course> getListOfCourses() {
		return listOfCourses;
	}
	public void setListOfCourses(List<Course> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}
	public List<Professor> getListOfProfessors() {
		return listOfProfessors;
	}
	public void setListOfProfessors(List<Professor> listOfProfessors) {
		this.listOfProfessors = listOfProfessors;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	
}
