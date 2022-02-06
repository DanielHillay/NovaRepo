package com.spearhead.nova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.User;
import com.spearhead.nova.repository.UserRepository;
import com.spearhead.nova.service.UserService;


@Service
public class UserImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void updateStatusById(Long userId) {
		// TODO Auto-generated method stub
		userRepository.updateStatusById(userId);
		
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}







//	@Override
//	public void addRoleToUser(String email, String Rolename) {
//		// TODO Auto-generated method stub
//		
//	}
}
