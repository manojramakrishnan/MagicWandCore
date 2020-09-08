package com.magicwand.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_generator")
	@SequenceGenerator(name="application_generator", sequenceName = "application_seq")
    private int application_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", insertable = false, updatable = false)
    private Project project;
	
    
	
	@Column(name = "project_id")
	private int project_id;

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	@Column(name = "application_name")
    private String application_name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "created_by")
    private String created_by;

    @Column(name = "created_dttm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:MM:ss")
    @Temporal(TemporalType.TIME)
    private Date created_dttm;
    
    @Column(name = "modified_by")
    private String modified_by;
    
    @Column(name = "modified_dttm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:MM:ss")
    @Temporal(TemporalType.TIME)
    private Date modified_dttm;
    
	@Override
	public String toString() {
		return "Application [appication_id=" + application_id + ", application_name=" + application_name + ", description=" + description + ", created_by=" + created_by + ", created_dttm=" + created_dttm + ", modified_by=" + modified_by + ", modified_dttm=" + modified_dttm + "]";
	}

	public int getApplication_id() {
		return application_id;
	}

	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}
	public String getApplication_name() {
		return application_name;
	}
	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Date getCreated_dttm() {
		return created_dttm;
	}

	public void setCreated_dttm(Date created_dttm) {
		this.created_dttm = created_dttm;
	}
	public String getModified_by() {
		return created_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public Date getModified_dttm() {
		return modified_dttm;
	}

	public void setModified_dttm(Date modified_dttm) {
		this.modified_dttm = modified_dttm;
	}

}
