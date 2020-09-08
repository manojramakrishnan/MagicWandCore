package com.magicwand.entity;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_generator")
	@SequenceGenerator(name="team_generator", sequenceName = "team_seq")
    private int team_id;
	
    @Column(name = "team_name")
    private String team_name;
    
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
    
    @Transient
    private List<Integer> userIds ;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "uid", insertable = false, updatable = false)
    private User user;
    
    private Integer userId;
    

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "plan")
//    private Registration regn = new Registration();
    
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}

	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", team_name=" + team_name + ", created_by=" + created_by + ", created_dttm=" + created_dttm + ", modified_by=" + modified_by + ", modified_dttm=" + modified_dttm + "]";
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
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
