package com.iems.model;

import java.util.List;

import com.iems.dao.EmployeeDao;
import com.iems.entity.DepartmentEntity;
import com.iems.entity.DesignationEntity;
import com.iems.entity.Profile;



public class AddEmployeeModel {
	
	public void insertEmployee(Profile emp)
	{
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.save(emp);
	}

	public List<Profile> listEmployee() {
		// TODO Auto-generated method stub
		String queryString="FROM Profile";
		EmployeeDao employeeDao=new EmployeeDao();
		return (List<Profile>) employeeDao.listQuery(queryString);
	}
	public void deleteEmployee(Profile emp)
	{
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.delete(emp);
	}
	public List<Profile> editEmployee(int eid)
	{
		EmployeeDao employeeDao=new EmployeeDao();
		
	String queryString="FROM Profile where eid=" +eid;
	
	
		return (List<Profile>) employeeDao.listQuery(queryString);
		}
	public List<DepartmentEntity> departmentList() {
		// TODO Auto-generated method stub
		String queryString="FROM DepartmentEntity";
		EmployeeDao employeeDao=new EmployeeDao();
		return (List<DepartmentEntity>) employeeDao.listQuery(queryString);
	}
	public List<DesignationEntity> designationList() {
		// TODO Auto-generated method stub
		String queryString="FROM DesignationEntity";
		EmployeeDao employeeDao=new EmployeeDao();
		return (List<DesignationEntity>) employeeDao.listQuery(queryString);
	}
	
}
