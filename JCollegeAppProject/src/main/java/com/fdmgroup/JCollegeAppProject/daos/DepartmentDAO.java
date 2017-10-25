package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Department;

public interface DepartmentDAO {
	
	public void addDepartment (Department department);
	public void updateDepartment (Department department);
	public void removeDepartment (int departmentId);
	public Department getDepartment (int departmentId);
	public List<Department> getAllDepartments();

}
