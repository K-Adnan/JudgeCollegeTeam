package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="JC_REGISTRARS")
public class Registrar implements Serializable {
	
	@OneToOne
	private User user;
	
	@Id
	@SequenceGenerator(name = "registrarid_sequence", sequenceName = "registrarid", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registrarid_sequence")
	private int registrarId;
	private String firstName;
	private String lastName;
	private String email;
	
	public Registrar(){
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return registrarId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
}
