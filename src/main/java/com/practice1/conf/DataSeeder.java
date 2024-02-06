package com.practice1.conf;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.practice1.entities.Admin;
import com.practice1.entities.Role;
import com.practice1.entities.User;
import com.practice1.repository.UserRepository;
import com.practice1.repository.AdminRepository;
import com.practice1.repository.RoleRepository;

@Component
public class DataSeeder implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg) {


		// Admin account
		if (adminRepository.findByUsername("admin") == null) {
			Admin admin = new Admin();
			admin.setEmail("admin@gmail.com");
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("123456"));
			admin.setRoles(Arrays.asList(roleRepo.findByroleName("ADMIN")));
			adminRepository.save(admin);
		}

		// Member account
		if (userRepository.findByUsername("member") == null) {
			User member = new User();
			member.setEmail("member@gmail.com");
			member.setUsername("member");
			member.setPassword(passwordEncoder.encode("123456"));
			member.setRoles(Arrays.asList(roleRepo.findByroleName("USER")));
			userRepository.save(member);
		}
		
		// Shipper account
		
	}
}
