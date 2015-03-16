package com.iems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



	@Entity
	@Table(name="experience")
	public class Experience {	

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id")
		int id;
		@Column(name="eid")
		int eid;
		@Column(name="columnid")
		int columnid;
		@Column(name="organization")
		String organization;

		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getEid() {
			return eid;
		}
		public void setEid(int eid) {
			this.eid = eid;
		}
		public int getColumnid() {
			return columnid;
		}
		public void setColumnid(int columnid) {
			this.columnid = columnid;
		}
		public String getOrganization() {
			return organization;
		}
		public void setOrganization(String organization) {
			this.organization = organization;
		}
			
	
}
