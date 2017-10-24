package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Profile;

public interface ProfileDAO {
	public void addProfile(Profile profile);
	public void removeProfile(int profileId);
	public void updateProfile(Profile profile);
	public Profile getProfile(int profileId);
	public List<Profile> getAllProfiles();

}
