package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;

public interface CourseDAO {

	public void addCourse(Course course);

	public void removeCourse(int courseCode);

	public void updateCourse(Course course);

	public Course getCourse(int courseCode);

	public List<Course> getAllCourses();

	public List<Course> getAllCoursesByDepartment(Department department);

}
