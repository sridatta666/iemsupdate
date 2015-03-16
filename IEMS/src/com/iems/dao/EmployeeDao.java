package com.iems.dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;

import com.iems.entity.Education;
import com.iems.entity.Employee;
import com.iems.entity.Experience;
import com.iems.entity.Profile;


public class EmployeeDao 
{



	Session session;
	public EmployeeDao()
	{
		  Configuration cfg=new AnnotationConfiguration(); 
	      cfg.configure("hibernate.cfg.xml");
	      SessionFactory factory=cfg.buildSessionFactory();  
	      session=factory.openSession();   
	}
	
	public void save(Object obj) {
		
	    Transaction t=session.getTransaction();
	    t.begin();
	    session.saveOrUpdate(obj);
	    session.flush();
	    t.commit();
	    //Object res= transientInstance;
	    session.close();
	}
	public void delete(Object obj){
	    Transaction t=session.getTransaction();
	    t.begin();
	    session.delete(obj);
	    t.commit();	   
	    session.close();
	}
	public List<?> listQuery(String queryString)
	{
		Query query = session.createQuery(queryString);
		List<?> res= query.list();	
		session.close();
		return res;
	}
	public int executeQuery(String queryString)
	{
		Query query = session.createQuery(queryString);
		Transaction tx=session.beginTransaction();
		int res= query.executeUpdate();
		tx.commit();
		session.close();	
		return res;
	}
	public int executeSQLQuery(String queryString)
	{
		SQLQuery query = session.createSQLQuery(queryString);
		Transaction tx=session.beginTransaction();
		int res= query.executeUpdate();
		tx.commit();
		session.close();	
		return res;
	}
	public List<?> listSQLQuery(String queryString)
	{
		SQLQuery query = session.createSQLQuery(queryString);
		List<?> res=  query.list();
		session.close();	
		return res;
	}
	public List<?> mapSQLQuery(String queryString)
	{
		SQLQuery query = session.createSQLQuery(queryString);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<?> res=  query.list();
		session.close();	
		return res;
	}
	   public int updateEducation(int eid, int columnid,String degree){
		   SQLQuery query = session.createSQLQuery("insert into education values("+eid+","+columnid+",'"+degree+"')");
		   int i=query.executeUpdate();
		   
		   return i;
	   }

	   
	   
	public Employee getEmployee(int empid){
		
		return (Employee)session.get(Employee.class, empid);
	}
	
	public Education getEducation(int empid){
		return(Education) session.get(Education.class,empid);
		}
	
		public Profile getProfile(int empid){
		return (Profile)session.get(Profile.class,empid);
		}
		
		public Experience getExperience(int empid){
		return (Experience)session.get(Experience.class,empid);
		}

}
