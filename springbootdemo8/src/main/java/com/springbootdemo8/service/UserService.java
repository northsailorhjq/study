package com.springbootdemo8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springbootdemo8.dao.UserDao;
import com.springbootdemo8.domain.User;
public class UserService implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username){
		User user=userDao.findByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;
	}

}
