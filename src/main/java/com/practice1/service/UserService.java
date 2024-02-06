package com.practice1.service;

import com.practice1.entities.Role;
import com.practice1.entities.User;

public interface UserService {

	public User createUser(User user);

	public boolean checkEmail(String email);

}
