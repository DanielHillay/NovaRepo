package com.spearhead.nova.service;

import java.util.List;

import com.spearhead.nova.model.User;

public interface UserService {

	public List<User> getUser();
	//public void addRoleToUser(String email, String Rolename);

	public void updateStatusById(Long userId);

	public void deleteUser(Long userId);



	

}
