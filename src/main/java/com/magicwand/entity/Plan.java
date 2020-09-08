package com.magicwand.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "plan")
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plan_generator")
	@SequenceGenerator(name="plan_generator", sequenceName = "plan_seq")
    private int plan_id;
	
    @Column(name = "plan_type")
    private String plan_type;
    
    @Column(name = "features")
    private String features;

    @Column(name = "start_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date start_date;
    
    @Column(name = "end_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date end_date;
    
    @Column(name = "plan_duration")
    private String plan_duration;
    
    @Column(name = "amount")
    private int amount;
    

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "plan")
//    private Registration regn = new Registration();
    
	@Override
	public String toString() {
		return "Plan [plan_id=" + plan_id + ", plan_type=" + plan_type + ", features=" + features + ", start_date=" + start_date + ", end_date=" + end_date + ", plan_duration=" + plan_duration + ", amount=" + amount + "]";
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlan_type() {
		return plan_type;
	}
	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getPlan_duration() {
		return plan_duration;
	}
	public void setPlan_duration(String plan_duration) {
		this.plan_duration = plan_duration;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
