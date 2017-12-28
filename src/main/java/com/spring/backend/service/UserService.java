package com.spring.backend.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.persistance.domain.backend.PlanEntity;
import com.spring.backend.persistance.domain.backend.UserEntity;
import com.spring.backend.persistance.domain.backend.UserRoleEntity;
import com.spring.backend.persistance.repositories.PlanRepository;
import com.spring.backend.persistance.repositories.RoleRepository;
import com.spring.backend.persistance.repositories.UserRepository;
import com.spring.enums.PlansEnum;

@Service
@Transactional(readOnly=true)
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PlanRepository planRepository;
	
	@Transactional
	public UserEntity createUser(UserEntity userEntity,PlansEnum plansEnum,Set<UserRoleEntity> userRoles) {
		PlanEntity plan=new PlanEntity(plansEnum);
		if(!planRepository.exists(plansEnum.getId()))
			plan=planRepository.save(plan);
		userEntity.setPlanEntity(plan);
		for(UserRoleEntity role:userRoles) {
			roleRepository.save(role.getRoleEntity());
		}
		userEntity.getUserRoles().addAll(userRoles);
		userEntity=userRepository.save(userEntity);
		return userEntity;
	}
}
