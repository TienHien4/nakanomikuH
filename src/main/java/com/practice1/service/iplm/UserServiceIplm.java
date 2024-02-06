package com.practice1.service.iplm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice1.entities.Role;
import com.practice1.entities.User;
import com.practice1.repository.RoleRepository;
import com.practice1.repository.UserRepository;
import com.practice1.service.UserService;
@Service
public class UserServiceIplm implements UserService{

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	@Override
	
	
	public User createUser(User user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		 user.setRoles(Arrays.asList(roleRepo.findByroleName("USER")));
			return userRepo.save(user);
	}
	
	

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}




}
