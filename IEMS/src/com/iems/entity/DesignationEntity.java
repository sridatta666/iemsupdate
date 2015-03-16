package com.iems.entity;


	
	
	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;


	@Entity
	@Table(name="designation")
	public class DesignationEntity implements Serializable{

		private static final long serialVersionUID = -723583058586873479L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "desgid")
		private int designationid;
		
		@Column(name="desgname")
		private String designationname;
		
		public int getDesignationid() {
			return designationid;
		}
		public void setDesignationid(int designationid) {
			this.designationid = designationid;
		}
		public String getDesignationname() {
			return designationname;
		}
		public void setDesignationname(String designationname) {
			this.designationname = designationname;
		}
		
		


	}


