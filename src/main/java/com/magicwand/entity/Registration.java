package com.magicwand.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Registration implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_generator")
	@SequenceGenerator(name="registration_generator", sequenceName = "registration_seq")
    private int id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planid", referencedColumnName = "plan_id", insertable = false, updatable = false)
    private Plan plan;
//  
	@Column(name = "planid")
	private int planid;
	
    public int getPlanid() {
		return planid;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	@Column(name = "registeredname")
    private String registeredName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "dob")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @Column(name = "username")
    private String userName;
    
    @Column(name = "passwd")
    private String password;
    
    @Column(name = "cnfrm_passwd")
    private String confirmPassword;

	@Override
	public String toString() {
		return "Registration [id=" + id + ", registeredName=" + registeredName + ", email=" + email + ", mobile="
				+ mobile + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", userName=" + userName
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}

	public int getId() {
		return id;
	}

	 
//
//	    public Plan getPlan() {
//	return plan;
//	}
//
//	public void setPlan(Plan plan) {
//	this.plan = plan;
//	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegisteredName() {
		return registeredName;
	}

	public void setRegisteredName(String registeredName) {
		this.registeredName = registeredName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
    
    
    
    
    }
