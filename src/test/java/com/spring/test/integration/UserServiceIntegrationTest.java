package com.spring.test.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.backend.persistance.domain.backend.RoleEntity;
import com.spring.backend.persistance.domain.backend.UserEntity;
import com.spring.backend.persistance.domain.backend.UserRoleEntity;
import com.spring.backend.persistance.repositories.UserRepository;
import com.spring.backend.service.UserService;
import com.spring.enums.PlansEnum;
import com.spring.enums.RolesEnum;
import com.spring.utils.UserUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {
	
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void createnewUser() {
		UserEntity basicUser=UserUtils.createUser();
		Set<UserRoleEntity> userRoles=new HashSet<>();
		userRoles.add(new UserRoleEntity(basicUser, new RoleEntity(RolesEnum.PRO)));
		
		UserEntity user=userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getId());
	}
	
	@Test
	public void findUserTest() {
		RepositoriesTestIntegration obj=new RepositoriesTestIntegration();
		UserEntity userEntity=obj.createUser();
		UserEntity retrievedUser=userRepository.findByUsername("user1");
		Assert.assertNotNull(retrievedUser);
	}
}
