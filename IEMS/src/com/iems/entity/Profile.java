/**
 * 
 */
package com.iems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author hareendrakumar
 *
 */
@Entity
@Table(name="profiledetails1")
public class Profile 
{
	@Id
	@Column(name="eid")
	int eid;
	@Column(name="firstname")
	String firstname;
	@Column(name="lastname")
	String lastname;
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Column(name="userid")
	String userid;
	@Column(name="desgid")
	int designation;
	@Column(name="deptid")
	int department;
	@Column(name="emppassword")
	String pwd;
	@Column(name="active")
	boolean active;
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getDesignation() {
		return designation;
	}
	public void setDesignation(int designation) {
		this.designation = designation;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	
	

}
