package com.spring.backend.persistance.domain.backend;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlanEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	
	public PlanEntity() {
		
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
		PlanEntity other = (PlanEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
