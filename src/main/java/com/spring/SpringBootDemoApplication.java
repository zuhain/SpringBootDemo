package com.spring;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.backend.persistance.domain.backend.RoleEntity;
import com.spring.backend.persistance.domain.backend.UserEntity;
import com.spring.backend.persistance.domain.backend.UserRoleEntity;
import com.spring.backend.service.UserService;
import com.spring.enums.PlansEnum;
import com.spring.enums.RolesEnum;
import com.spring.utils.UserUtils;

import jdk.internal.jline.internal.Log;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner{
	
	private Logger logger=LoggerFactory.getLogger(SpringBootDemoApplication.class);
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		UserEntity basicUser=UserUtils.createUser();
		Set<UserRoleEntity> userRoles=new HashSet<>();
		userRoles.add(new UserRoleEntity(basicUser, new RoleEntity(RolesEnum.BASIC)));
		logger.debug("Creating user with username {}",basicUser.getUsername());
		userService.createUser(basicUser, PlansEnum.PRO, userRoles);
		logger.debug("User {} created",basicUser.getUsername());
		
	}
}
