package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.User;

public interface UserDAO {
	public void addUser(User profile);
	public void removeUser(String username);
	public void updateUser(User profile);
	public User getUser(String username);
	public List<User> getAllUsers();

}
