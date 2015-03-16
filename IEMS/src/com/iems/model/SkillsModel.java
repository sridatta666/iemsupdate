package com.iems.model;

import java.util.List;
import com.iems.dao.*;
import com.iems.entity.SkillsEntity;

public class SkillsModel {
	public List<SkillsEntity> listSkills() {
		String queryString="FROM SkillsEntity";
		EmployeeDao employeeDao=new EmployeeDao();
		List<SkillsEntity> listQuery = (List<SkillsEntity>)employeeDao.listQuery(queryString);
		
		return listQuery;
		
	}
	public void insertSkills(SkillsEntity skills) {
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.save(skills);
		
	}
	public void deleteSkills(SkillsEntity skills) {
		
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.delete(skills);
		
	}
	public List<SkillsEntity> editSkills(int st)
	{
	EmployeeDao employeeDao=new EmployeeDao();	
	String queryString="FROM SkillsEntity where skillid="+st;
	return (List<SkillsEntity>)  employeeDao.listQuery(queryString);
	}
	

}
