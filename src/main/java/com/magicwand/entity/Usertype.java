package com.magicwand.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Usertype {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usertype_generator")
	@SequenceGenerator(name="usertype_generator", sequenceName = "usertype_seq")
    private int usertype_id;
	
	 @Column(name = "userTypeName")
	 private String userTypeName;
	
    public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	@Column(name = "description")
    private String description;
    
    @Column(name = "created_by")
    private String created_by;

    @Column(name = "created_dttm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:MM:ss")
    @Temporal(TemporalType.TIME)
    private Date created_dttm;
    
	@Override
	public String toString() {
		return "Usertype [usertype_id=" + usertype_id + ", description=" + description + ", created_by=" + created_by + ", created_dttm=" + created_dttm + "]";
	}

	public int getUsertype_id() {
		return usertype_id;
	}

	public void setUsertype_id(int usertype_id) {
		this.usertype_id = usertype_id;
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
	
    }

