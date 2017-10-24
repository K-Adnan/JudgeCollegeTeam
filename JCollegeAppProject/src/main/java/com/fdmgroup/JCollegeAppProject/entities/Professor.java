package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Professor")
public class Professor extends User implements Serializable {

	private String firstName;
	private String lastName;
	private String address;
	private int phone;
	private int fax;
	private String email;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Course course;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Department department;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Grade> gradeList;

	public Professor() {
		super();
	}

	public Professor(String firstName, String lastName, String address, int phone, int fax,
			String email, Course course, Department department, List<Grade> gradeList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
		this.course = course;
		this.department = department;
		this.gradeList = gradeList;
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
