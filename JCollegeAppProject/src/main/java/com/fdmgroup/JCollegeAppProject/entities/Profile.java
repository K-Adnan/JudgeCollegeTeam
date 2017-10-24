package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JC_PROFILES")
public class Profile implements Serializable {

	@Id
	private String username;
	private String password;
	private Date registrationDate;

	public Profile() {
		this.registrationDate = new Date();
	}

	public Profile(String username, String password) {
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

}
