package com.practice1.service;

import com.practice1.entities.Admin;

public interface AdminService {
	public Admin createAdmin(Admin admin);

	public boolean checkEmail(String email);

}
