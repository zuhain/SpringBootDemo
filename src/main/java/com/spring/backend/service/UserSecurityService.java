package com.spring.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.backend.persistance.domain.backend.UserEntity;
import com.spring.backend.persistance.repositories.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService{
	
	private static final Logger logger=LoggerFactory.getLogger(UserSecurityService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=userRepository.findByUsername(username);
		if(null==userEntity) {
			logger.debug("Username {} not found",username);
			throw new UsernameNotFoundException("Username "+username+" not found");
		}
		return userEntity;
	}

}
