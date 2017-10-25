package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "JC_USERS")
@DiscriminatorColumn(name="ROLE")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String password;
	@Transient
	private String confirmPassword;
	private Date registrationDate;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private int noOfIncorrectAttempts;
	
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getNoOfIncorrectAttempts() {
		return noOfIncorrectAttempts;
	}

	public void setNoOfIncorrectAttempts(int noOfIncorrectAttempts) {
		this.noOfIncorrectAttempts = noOfIncorrectAttempts;
	}

}
