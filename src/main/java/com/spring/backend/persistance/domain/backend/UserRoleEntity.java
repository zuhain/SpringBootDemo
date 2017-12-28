package com.spring.backend.persistance.domain.backend;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRoleEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private UserEntity userEntity;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="roleId")
	private RoleEntity roleEntity;
	
	public UserRoleEntity() {
		
	}
	
	public UserRoleEntity(UserEntity userEntity,RoleEntity roleEntity) {
		this.userEntity=userEntity;
		this.roleEntity=roleEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleEntity == null) ? 0 : roleEntity.hashCode());
		result = prime * result + ((userEntity == null) ? 0 : userEntity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleEntity other = (UserRoleEntity) obj;
		if (roleEntity == null) {
			if (other.roleEntity != null)
				return false;
		} else if (!roleEntity.equals(other.roleEntity))
			return false;
		if (userEntity == null) {
			if (other.userEntity != null)
				return false;
		} else if (!userEntity.equals(other.userEntity))
			return false;
		return true;
	}
	
	
}
