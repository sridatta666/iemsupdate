package com.iems.entity;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="emp_skill")
public class Emp_Skills 
{
	
	@Column(name="eid")
	int eid;
	@Column(name="skillid")
	int skillid;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getSkillid() {
		return skillid;
	}
	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

}
