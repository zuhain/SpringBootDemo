package com.spring.backend.persistance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.backend.persistance.domain.backend.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer>{

}
