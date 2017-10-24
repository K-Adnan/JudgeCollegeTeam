package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JC_PROFILES")
public class User implements Serializable {

	@Id
	private String username;
	private String password;
	private Date registrationDate;
	private String role;
	
	public User() {
		this.registrationDate = new Date();
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.registrationDate = new Date();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
