package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fdmgroup.JCollegeAppProject.utilities.Gender;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Student")
public class Student extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String address;
	private String phoneNumber;
	@Column(name = "DATE_OF_BIRTH")
	private Date dOB;
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy="studentList")
	private Set<Course> courseList;

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REMOVE}, mappedBy="student", orphanRemoval=true)
	private Set<Grade> gradeList;

	public Student() {
		super();
	}

	public Student(String address, String phoneNumber, Date dOB, Gender gender,
			Set<Course> courseList, Set<Grade> gradeList) {
		super();
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.dOB = dOB;
		this.gender = gender;
		this.courseList = courseList;
		this.gradeList = gradeList;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Set<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(Set<Course> courseList) {
		this.courseList = courseList;
	}

	public Set<Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(Set<Grade> gradeList) {
		this.gradeList = gradeList;
	}
	
	public void addCourse(Course course){
		courseList.add(course);
		course.addStudent(this);
	}
	
	public void removeCourse(Course course){
		int index = 0;
		// Iterating over all courses in course list until the course that is passed in, is found
//		for (int i=0;i<courseList.size();i++){
//			if (courseList.get(i).getCourseCode() == course.getCourseCode()){
//				index = i;	// Setting the index to be the course to be deleted
//			}
//		}
		courseList.remove(course);
//		courseList.remove(index);
	}

	@Override
	public String toString() {
		return "Student [address=" + address
				+ ", phoneNumber=" + phoneNumber + ", dOB=" + dOB + ", gender=" + gender + "]";
	}

	
}
