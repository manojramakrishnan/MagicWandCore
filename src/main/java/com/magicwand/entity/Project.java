package com.magicwand.entity;
import java.util.Date;
//import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
	@SequenceGenerator(name="project_generator", sequenceName = "project_seq")    
	private int project_id;
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "application_id", referencedColumnName = "application_id", insertable = false, updatable = false)
     // private Application application;
//	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id", referencedColumnName = "org_id", insertable = false, updatable = false)
    private Organization organization;
	
	
	@Column(name = "organization_id")
	private int organization_id;
	
    public int getOrganization_id() {
		return organization_id;
	}

	public void setOrganizationId(int organization_id) {
		this.organization_id = organization_id;
	}
	@Column(name = "project_name")
    private String project_name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "created_by")
    private String created_by;
    
    @Column(name = "modified_by")
    private String modified_by;

    @Column(name = "created_dttm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_dttm;
    
    @Column(name = "modified_dttm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified_dttm;
    
	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ",  project_name="+ project_name + ",  description=" + description + ", created_by=" + created_by + ", modified_by=" + modified_by + ", created_dttm=" + created_dttm + ", modified_dttm=" + modified_dttm + "]";
	}
	public int getProjectid() {
		return project_id;
	}

	public void setProjectid(int project_id) {
		this.project_id = project_id;
	}
				 
	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
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
	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getCreated_dttm() {
		return created_dttm;
	}

	public void setCreated_dttm(Date created_dttm) {
		this.created_dttm = created_dttm;
	}
	
	public Date getModified_dttm() {
		return modified_dttm;
	}

	public void setModified_dttm(Date modified_dttm) {
		this.modified_dttm = modified_dttm;
	}
    
	/*@Id
    @GeneratedValue
    private Integer application_id;

	@OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> application;

	public Integer getApplication_id() {
		return application_id;
	}

	public void setApplication_id(Integer application_id) {
		this.application_id = application_id;
	}
	 */

}
