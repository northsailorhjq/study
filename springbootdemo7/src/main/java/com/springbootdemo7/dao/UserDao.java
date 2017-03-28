package com.springbootdemo7.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdemo7.domain.User;

public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
