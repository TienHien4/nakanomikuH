package com.practice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice1.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public boolean existsByEmail(String email);

	User findByUsername(String username);

}
