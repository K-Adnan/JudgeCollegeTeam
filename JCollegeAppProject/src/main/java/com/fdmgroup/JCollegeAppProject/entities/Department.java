package com.fdmgroup.JCollegeAppProject.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JC_DEPARTMENTS")
public class Department {
	
	@Id
	@SequenceGenerator(name = "departmentid_sequence", sequenceName = "departmentid", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentid_sequence")
	private int departmentId;
	private String departmentName;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "department")
	private List<Course> listOfCourses;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "department")
	private List<Professor> listOfProfessors;
	
	public Department(){
	}
	
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
