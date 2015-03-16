package com.iems.model;

import java.util.List;

import com.iems.dao.*;
import com.iems.entity.DesignationEntity;

public class DesignationModel {
	public List<DesignationEntity> listDesignations() {
		String queryString="FROM DesignationEntity";
		EmployeeDao employeeDao=new EmployeeDao();
		List<DesignationEntity> listQuery = (List<DesignationEntity>)employeeDao.listQuery(queryString);
		List<DesignationEntity> Designation=listQuery;
		return Designation;
		
	}
	public void insertDesignations(DesignationEntity designation) {
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.save(designation);
		
	}
	public void deleteDesignations(DesignationEntity designation) {
		
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.delete(designation);
		
	}
	public List<DesignationEntity> editDesignations(int st)
	{
		
		EmployeeDao employeeDao=new EmployeeDao();
		
	String queryString="FROM DesignationEntity where designationid="+st;
	return (List<DesignationEntity>)  employeeDao.listQuery(queryString);
	}
	

}
