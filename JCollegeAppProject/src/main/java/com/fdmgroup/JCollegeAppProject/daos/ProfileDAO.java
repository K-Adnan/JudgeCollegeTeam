package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Profile;

public interface ProfileDAO {
	public void addProfile(Profile profile);
	public void removeProfile(String username);
	public void updateProfile(Profile profile);
	public Profile getProfile(String username);
	public List<Profile> getAllProfiles();

}
