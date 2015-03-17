package com.iems.model;
import java.util.List;

import org.hibernate.SQLQuery;

import com.iems.dao.*;
import com.iems.entity.Education;
import com.iems.entity.Emp_Skills;
import com.iems.entity.Experience;
import com.iems.entity.Profile;
import com.iems.entity.Employee;
import com.iems.entity.SkillsEntity;
public class EmployeeModel {
       
	


		
		public void insertEmployee(Profile emp)
		{
			EmployeeDao employeeDao=new EmployeeDao();
			employeeDao.save(emp);
		}
		public void insertedu(Education bean){
		new EmployeeDao().save(bean);
			
		}
		public void insertProfile(Employee bean){
			new EmployeeDao().save(bean);	
			}
		public void insertexp(Experience bean){
			new EmployeeDao().save(bean);	
			}

		public Employee getEmployee(int empid){
			EmployeeDao dao=new EmployeeDao();
			return dao.getEmployee(empid);
			}
		public Education getEducation(int empid){
			EmployeeDao dao=new EmployeeDao();
			return dao.getEducation(empid);
			}
			public Experience getExperience(int empid){
			EmployeeDao dao=new EmployeeDao();
			return dao.getExperience(empid);
			}
			public Profile getProfile(int empid){
			EmployeeDao dao=new EmployeeDao();
			return dao.getProfile(empid);
			}
        public void deleteedu(Education edu){
        	EmployeeDao dao=new EmployeeDao();
        	dao.delete(edu);
        	
        }
        public void deleteexp(Experience edu){
        	EmployeeDao dao=new EmployeeDao();
        	dao.delete(edu);
        	
        }
		public List getEid(String userid){
			EmployeeDao dao=new EmployeeDao();
			String queryString="select eid from profiledetails where userid='"+userid+"'";
			return (List) dao.listSQLQuery(queryString);
			}

		public void addSkillToEmployee(int eid,int[] Stringids){
			EmployeeDao dao=new EmployeeDao();
			for(int i=0;i<Stringids.length;i++){
			Emp_Skills empskill=new Emp_Skills();
		    empskill.setEid(eid);
		    empskill.setSkillid(Stringids[i]);
			
			}
		}
		
		
		public List<Employee> listEmployee() {
			// TODO Auto-generated method stub
			String queryString="FROM Employee";
			EmployeeDao employeeDao=new EmployeeDao();
			return (List<Employee>) employeeDao.listQuery(queryString);
		}
		public List<Education> getEducationList(int eid){
			String queryString="FROM Education where eid="+eid;
			EmployeeDao empdao=new EmployeeDao();
			
			return (List<Education>)empdao.listQuery(queryString);  
			
		}
//		public List<String> getEmployeeSkillNames(int eid){
//			String queryString="SELECT skills.skillname FROM skills INNER JOIN emp_skill ON skills.skillid=emp_skill.skillid where emp_skill.eid="+eid;
//			EmployeeDao empdao=new EmployeeDao();
//			
//			return (List<String>)empdao.listSQLQuery(queryString);  
//			
//		}
		
		
		public List<Education> getEducationListbycolumn(int eid,int columnid){
			String queryString="FROM Education where eid="+eid+" AND id="+columnid;
			EmployeeDao empdao=new EmployeeDao();
			
			return (List<Education>)empdao.listQuery(queryString);  
			
		}
		
		public List<Experience> getExperienceList(int eid){
			String queryString="FROM Experience where eid="+eid;
			EmployeeDao empdao=new EmployeeDao();
			
			return (List<Experience>)empdao.listQuery(queryString);  
			
		}
		public List<Experience> getExperienceListbycolumn(int eid,int columnid){
			String queryString="FROM Experience where eid="+eid+" AND id="+columnid;
			EmployeeDao empdao=new EmployeeDao();
			
			return (List<Experience>)empdao.listQuery(queryString);  
			
		}
        public List getColumn1(int columnid,int empid){
        	String queryString="select degree from education where id="+columnid+" And eid="+empid;  
        	EmployeeDao empdao=new EmployeeDao();
        	
        	return (List)empdao.listSQLQuery(queryString);
        } 
        public List getColumn2(int columnid,int empid){
        	String queryString="select organization from experience where id="+columnid+" And eid="+empid;  
        	EmployeeDao empdao=new EmployeeDao();
        	
        	return (List)empdao.listSQLQuery(queryString);
        }
		
		
		
	   	
		
		public List getSkillIds(Employee emp){
			
			EmployeeDao employeeDao=new EmployeeDao();
			String queryString="FROM Emp_Skills where eid="+emp.getEid();
			return (List)employeeDao.listQuery(queryString);
			
		}
		
	}


