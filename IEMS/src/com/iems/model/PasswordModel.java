package com.iems.model;

import java.util.List;

import com.iems.dao.EmployeeDao;
import com.iems.entity.Profile;



public class PasswordModel {
	

	public List<Profile> listEmployee() {
		// TODO Auto-generated method stub
		String queryString="FROM Profile";
		EmployeeDao employeeDao=new EmployeeDao();
		return (List<Profile>) employeeDao.listQuery(queryString);
	}
	
	
public int updateEmployee(String newpwd,String userid)
{
	EmployeeDao employeeDao=new EmployeeDao();
	
	return employeeDao.executeQuery("update Profile set pwd='"+newpwd+"' where userid='"+userid+"'");
}

public List<Profile> selectEmployee(String userid)
{
	EmployeeDao employeeDao=new EmployeeDao();
	String queryString="From Profile where userid='"+userid+"'";
	return (List<Profile>)employeeDao.listQuery(queryString);
}	
}
