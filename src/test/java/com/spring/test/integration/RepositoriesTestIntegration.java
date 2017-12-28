package com.spring.test.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.SpringBootDemoApplication;
import com.spring.backend.persistance.domain.backend.PlanEntity;
import com.spring.backend.persistance.domain.backend.RoleEntity;
import com.spring.backend.persistance.domain.backend.UserEntity;
import com.spring.backend.persistance.domain.backend.UserRoleEntity;
import com.spring.backend.persistance.repositories.PlanRepository;
import com.spring.backend.persistance.repositories.RoleRepository;
import com.spring.backend.persistance.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoriesTestIntegration {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PlanRepository planRepository;
	
	@Before
	public void init() {
		Assert.assertNotNull(userRepository);
		Assert.assertNotNull(roleRepository);
		Assert.assertNotNull(planRepository);
	}
	
	@Test
	public void testPlanRepository() {
		PlanEntity plan=new PlanEntity();
		plan.setId(1);
		plan.setName("Basic");
		planRepository.save(plan);
		PlanEntity retrievedPlan=planRepository.findOne(1);
		Assert.assertNotNull(retrievedPlan);
	}
	
	@Test
	public void testRoleRepository() {
		RoleEntity roleEntity=new RoleEntity();
		roleEntity.setId(1);
		roleEntity.setName("User");
		roleRepository.save(roleEntity);
		RoleEntity retrievedRole=roleRepository.findOne(1);
		Assert.assertNotNull(retrievedRole);
	}
	
	@Test
	public void testUserRepository() {
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
		
		PlanEntity plan=new PlanEntity();
		plan.setId(1);
		plan.setName("Basic");
		planRepository.save(plan);
		user.setPlanEntity(plan);
		
		RoleEntity roleEntity=new RoleEntity();
		roleEntity.setId(1);
		roleEntity.setName("User");
		roleRepository.save(roleEntity);
		
		Set<UserRoleEntity> userRoles=new HashSet<>();
		UserRoleEntity userRole=new UserRoleEntity();
		userRole.setRoleEntity(roleEntity);
		userRole.setUserEntity(user);
		userRoles.add(userRole);
		
		user.getUserRoles().addAll(userRoles);
		for(UserRoleEntity ure:userRoles) {
			roleRepository.save(ure.getRoleEntity());
		}
		
		user=userRepository.save(user);
		UserEntity retrievedUser=userRepository.findOne(user.getId());
		Assert.assertNotNull(retrievedUser);
		Assert.assertNotNull(retrievedUser.getPlanEntity());
		Assert.assertNotNull(retrievedUser);
		
	}
}
