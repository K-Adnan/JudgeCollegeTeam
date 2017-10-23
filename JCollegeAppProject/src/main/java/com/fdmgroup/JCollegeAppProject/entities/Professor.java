package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name= "PROFESSORS")
public class Professor implements Serializable{
	
@Id
@SequenceGenerator(name="professorid_sequence", sequenceName="professorid_sequence", initialValue=1,allocationSize=1)
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="professorid_sequence")
private int professorId;
private String firstName;
private String lastName;
private String address;
private int phone;
private int fax;
private String email;

@OneToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
private Profile profile;
@OneToOne (fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
private Course course;
@ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
private Department department;
@OneToMany (fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
private List<Grade> gradeList;

public Professor() {
	super();
}



public Professor(int professorId, String firstName, String lastName, String address, int phone, int fax, String email,
		Profile profile, Course course, Department department, List<Grade> gradeList) {
	super();
	this.professorId = professorId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.phone = phone;
	this.fax = fax;
	this.email = email;
	this.profile = profile;
	this.course = course;
	this.department = department;
	this.gradeList = gradeList;
}









public int getProfessorId() {
	return professorId;
}

public void setProfessorId(int professorId) {
	this.professorId = professorId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getPhone() {
	return phone;
}

public void setPhone(int phone) {
	this.phone = phone;
}

public int getFax() {
	return fax;
}

public void setFax(int fax) {
	this.fax = fax;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Profile getProfile() {
	return profile;
}

public void setProfile(Profile profile) {
	this.profile = profile;
}

public Course getCourse() {
	return course;
}

public void setCourse(Course course) {
	this.course = course;
}

public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}

public List<Grade> getGradeList() {
	return gradeList;
}

public void setGradeList(List<Grade> gradeList) {
	this.gradeList = gradeList;
}






}
