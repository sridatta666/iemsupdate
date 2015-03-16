package com.iems.entity;


	
	
	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;


	@Entity
	@Table(name="department")
	public class DepartmentEntity implements Serializable{

		private static final long serialVersionUID = -723583058586873479L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "deptid")
		private int departmentid;
		
		@Column(name="deptname")
		private String departmentname;
		
		

		
		public int getDepartmentid() {
			return departmentid;
		}

		public void setDepartmentid(int departmentid) {
			this.departmentid = departmentid;
		}

		public String getDepartmentname() {
			return departmentname;
		}

		public void setDepartmentname(String departmentname) {
			this.departmentname = departmentname;
		}

		

	}
