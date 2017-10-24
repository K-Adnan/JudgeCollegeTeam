package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JC_GRADES")
public class Grade implements Serializable {

	@Id
	@SequenceGenerator(name = "gradeid_sequence", sequenceName = "gradeid", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gradeid_sequence")
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
