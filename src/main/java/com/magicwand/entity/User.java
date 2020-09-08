package com.magicwand.entity;

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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name = "user_generator", sequenceName = "user_seq")
	private int uid;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "regId", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private Registration register;

	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String userName;

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

	@Column(name = "passwd",length = 50, nullable = false)
	private String password;

	@Column(name = "cnfrm_passwd",length = 50, nullable = false)
	private String confirmPassword;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usertype_id", referencedColumnName = "usertype_id", insertable = false, updatable = false)
	private Usertype usertype;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roleTypeId", referencedColumnName = "roletype_id", insertable = false, updatable = false)
	private Role role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "planId", referencedColumnName = "plan_id", insertable = false, updatable = false)
	private Plan plan;

	@Column(name = "planId",length = 50, nullable = false)
	private int planId;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	@Column(name = "roleTypeId",length = 50, nullable = false)
	private int roleTypeId;

	public int getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(int roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	@Column(name = "userTypeId",length = 50, nullable = false)
	private int userTypeId;

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Column(name = "regId")
	private int regId;

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	@Column(name = "payment_status",length = 50, nullable = false)
	private String payment_status;

//    @Column(name = "planof_expiry")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
//    @Temporal(TemporalType.DATE)
//    private Date planof_expiry;

	@Column(name = "status",length = 50, nullable = false)
	private String status;

	@Column(name = "usertoken",length = 50, nullable = true)
	private String usertoken;

	@Column(name = "created_by",length = 50, nullable = false)
	private String created_by;

	@Column(name = "modified_by",length = 50, nullable = false)
	private String modified_by;

	@Column(name = "created_dttm",length = 50, nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:MM:ss")
	@Temporal(TemporalType.TIME)
	private Date created_dttm;

	@Column(name = "modified_dttm",length = 50, nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:MM:ss")
	@Temporal(TemporalType.TIME)
	private Date modified_dttm;

	@Override
	public String toString() {
		return "User [uid=" + uid + ",  payment_status=" + payment_status + ",  status=" + status + ", usertoken="
				+ usertoken + ", created_by=" + created_by + ", modified_by=" + modified_by + ", created_dttm="
				+ created_dttm + ", modified_dttm=" + modified_dttm + "]";
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

//	public Date getPlanof_expiry() {
//		return planof_expiry;
//	}
//
//	public void setPlanof_expiry(Date planof_expiry) {
//		this.planof_expiry = planof_expiry;
//	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// usertoken
	public String getUsertoken() {
		return usertoken;
	}

	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
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

}
