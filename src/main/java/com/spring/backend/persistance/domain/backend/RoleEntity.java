package com.spring.backend.persistance.domain.backend;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.spring.enums.RolesEnum;

@Entity
public class RoleEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy="roleEntity",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<UserRoleEntity> userRole=new HashSet<>();
	
	public RoleEntity() {
		
	}
	
	public RoleEntity(RolesEnum rolesEnum) {
		this.id=rolesEnum.getId();
		this.name=rolesEnum.getRoleName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserRoleEntity> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRoleEntity> userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		RoleEntity other = (RoleEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
