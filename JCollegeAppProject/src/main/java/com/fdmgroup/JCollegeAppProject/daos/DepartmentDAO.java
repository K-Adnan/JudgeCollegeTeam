package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Department;

public interface DepartmentDAO {
	
	public void addDepartment (Department d);
	public void updateDepartment (Department d);
	public void removeDepartment (int DepartmentId);
	public Department getDepartment (int DepartmentId);
	public List<Department> getAllDepartment();

}
