package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COURSES")
public class Course implements Serializable {

	@Id
	private String courseName;
	private int courseCode;
	private String courseInfo;
	private Date startDate;
	private Date endDate;
	private String studentsEnrolled;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Department department;

	@ManyToOne
	private Professor professor;

	public Course() {
		super();
	}

	public Course(String courseName, int courseCode, String courseInfo, Date startDate, Date endDate,
			String studentsEnrolled, Department department, Professor professor) {
		super();
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.courseInfo = courseInfo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentsEnrolled = studentsEnrolled;
		this.department = department;
		this.professor = professor;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(String studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseCode=" + courseCode + ", courseInfo=" + courseInfo
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", studentsEnrolled=" + studentsEnrolled
				+ ", professor=" + professor + "]";
	}

}
