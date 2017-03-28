package com.springbootdemo8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.springbootdemo8.service.UserService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * 注册UserService 的 bean
	 * 
	 * @return
	 */
	@Bean
	UserDetailsService userService() {
		return new UserService();
	}

	/**
	 * 添加自定义的认证
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()// 定义所有行为都必须认证
				.and().formLogin().loginPage("/login")// 定制登录行为，登录页面可以任意访问
				.failureUrl("/login?error").permitAll().and().logout().permitAll();// 定制注销行为，注销请求可以任意访问
	}
}
