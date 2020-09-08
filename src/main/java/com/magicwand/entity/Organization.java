package com.magicwand.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "organization")
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_generator")
	@SequenceGenerator(name="organization_generator", sequenceName = "organization_seq")
    private int org_id;
	
	@Column(name = "org_name")
    private String org_name;
    
    @Column(name = "description")
    private String description;

    
	@Override
	public String toString() {
		return "Organization [org_id=" + org_id + ", org_name=" + org_name + ", description=" + description + "]";
	}

	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
		/*@Id
	    @GeneratedValue
	    private Integer project_id;

		@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Project> project;
		 public Integer getProject_id() {
				return project_id;
			}

			public void setProject_id(Integer project_id) {
				this.project_id = project_id;
			}*/
	}
	

