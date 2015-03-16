package com.iems.model;

import java.util.List;

import com.iems.dao.*;
import com.iems.entity.DepartmentEntity;


public class DepartmentModel {
	public List<DepartmentEntity> listDepartments() {
		String queryString="FROM DepartmentEntity";
		EmployeeDao employeeDao=new EmployeeDao();
		List<DepartmentEntity> listQuery = (List<DepartmentEntity>)employeeDao.listQuery(queryString);
		List<DepartmentEntity> Department=listQuery;
		return Department;
		
	}
	public void insertDepartments(DepartmentEntity department) {
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.save(department);
		
	}
	public void deleteDepartments(DepartmentEntity department) {
		
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.delete(department);
		
	}
	public List<DepartmentEntity> editDepartments(int st)
	{
		
		EmployeeDao employeeDao=new EmployeeDao();
		
	String queryString="FROM DepartmentEntity where departmentid="+st;
	return (List<DepartmentEntity>)  employeeDao.listQuery(queryString);
	}
	

}
