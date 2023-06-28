package com.bbt.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bbt.hroauth.entities.Users;
import com.bbt.hroauth.feignclients.UserFeignClient;



@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);			
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public Users findByEmail(String email) {
		Users user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found "+email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("email found "+email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userFeignClient.findByEmail(username).getBody();
		if(user == null) {
			logger.error("Email not found "+username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("email found "+username);
		return user;
	}
	
}
