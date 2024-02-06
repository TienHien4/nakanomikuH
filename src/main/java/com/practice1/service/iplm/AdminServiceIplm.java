package com.practice1.service.iplm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice1.entities.Admin;
import com.practice1.repository.AdminRepository;
import com.practice1.repository.RoleRepository;
import com.practice1.service.AdminService;
@Service
public class AdminServiceIplm implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public Admin createAdmin(Admin admin) {
		admin.setPassword(passwordEncode.encode(admin.getPassword()));
		 admin.setRoles(Arrays.asList(roleRepo.findByroleName("ADMIN")));
		return adminRepo.save(admin);
	}

	@Override
	public boolean checkEmail(String email) {
		return adminRepo.existsByEmail(email);
	}

}
