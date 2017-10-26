package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JC_COURSES")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "courseid_sequence", sequenceName = "courseid", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseid_sequence")
	private int courseCode;
	private String courseName;
	private String courseInfo;
	private Date startDate;
	private Date endDate;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<Student> studentList;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Department department;

	@ManyToOne
	@JoinColumn(name="PROFFESSOR_USERNAME")
	private Professor professor;

	public Course() {
		super();
	}

	public Course(String courseName, String courseInfo, Date startDate, Date endDate, Department department, Professor professor) {
		super();
		this.courseName = courseName;
		this.courseInfo = courseInfo;
		this.startDate = startDate;
		this.endDate = endDate;
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
		if (professor != null){
			professor.addCourse(this);
		}
		
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", courseInfo=" + courseInfo
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", department=" + department + ", professor="
				+ professor + "]";
	}
	
	public Set<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(Set<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void addCourse(Student student){
		studentList.add(student);
		student.addCourse(this);
	}

	

}
