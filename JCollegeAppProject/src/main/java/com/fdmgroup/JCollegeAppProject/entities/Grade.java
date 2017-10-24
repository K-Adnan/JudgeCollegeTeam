package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COURSES")
public class Grade implements Serializable {

	@Id
	@SequenceGenerator(name = "itadminid_sequence", sequenceName = "itadminid", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itadminid_sequence")
	private int gradeId;
	private Student student;
	private Professor professor;
	private Course course;
	private char gradeValue;

	public Grade() {

	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public char getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(char gradeValue) {
		this.gradeValue = gradeValue;
	}

	public int getGradeId() {
		return gradeId;
	}

}
