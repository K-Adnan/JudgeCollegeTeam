package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table  (name = "ITADMINS")
public class ITAdmin implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itadminid_sequence",
	sequenceName="itadminid", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itadminid_sequence")

	private int id;
	private String name;
	public ITAdmin() {
		super();
		
	}
	
	
	public ITAdmin(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "ITAdmin [name=" + name + "]";
	}
	
	
	
	
}
