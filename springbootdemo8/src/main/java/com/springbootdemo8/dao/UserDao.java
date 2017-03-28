package com.springbootdemo8.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdemo8.domain.User;

public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
