package com.practice1.conf.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice1.entities.Admin;
import com.practice1.repository.AdminRepository;
@Service
public class AdminDetailsServiceIplm implements UserDetailsService{
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public AdminDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Admin admin = adminRepo.findByUsername(username);

		if (admin != null) {
			return new AdminDetails(admin);
		}

		throw new UsernameNotFoundException("user not available");
	}

}
