package com.magicwand.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_generator")
	@SequenceGenerator(name="role_generator", sequenceName = "role_seq")
    private int roletype_id;
	
    @Column(name = "role")
    private String role;
    
    @Column(name = "description")
    private String description;

    
	@Override
	public String toString() {
		return "Roletype [roletype_id=" + roletype_id + ", role=" + role + ", description=" + description + "]";
	}

	public int getRoletype_id() {
		return roletype_id;
	}

	public void setRoletype_id(int roletype_id) {
		this.roletype_id = roletype_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
