package com.spring.utils;

import com.spring.backend.persistance.domain.backend.UserEntity;

public class UserUtils {
	
	private UserUtils() {
		throw new AssertionError("Not instantiable");
	}
	
	public static UserEntity createUser() {
		UserEntity user=new UserEntity();
		user.setUsername("user1");
		user.setPassword("password");
		user.setCountry("India");
		user.setDescription("Basic user");
		user.setFirstName("first");
		user.setLastName("last");
		user.setPhoneNumber("34676");
		user.setProfileImageUrl("http://images.com");
		user.setEnabled(true);
		user.setEmail("www.user.com");
		
		return user;
	}
}
