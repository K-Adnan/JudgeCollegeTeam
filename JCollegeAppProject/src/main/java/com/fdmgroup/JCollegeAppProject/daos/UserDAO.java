package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

public interface UserDAO {
	public void addUser(User profile);

	public void removeUser(String username);

	public void updateUser(User profile);

	public User getUser(String username);

	public List<User> getAllUsers();

	public List<User> getAllUsersByProfessor(Professor professor);

	public List<User> getAllUsersByStudent(Student student);

	public List<User> getAllUsersByRegistrar(Registrar registrar);

	public List<User> getAllUsersByITAdmin(ITAdmin itAdmin);

}
