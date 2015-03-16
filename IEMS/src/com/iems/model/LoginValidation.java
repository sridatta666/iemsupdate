package com.iems.model;

import java.util.List;
import com.iems.dao.EmployeeDao;
import com.iems.entity.Profile;

public class LoginValidation {	
	
    @SuppressWarnings("unchecked")
       public List<Profile> checkValidation(String userid, String password) {
    	EmployeeDao employeeDao=new EmployeeDao();
        //Session session = this.sessionFactory.openSession();
        List<Profile> profileList = (List<Profile>) employeeDao.listQuery("from Profile where userid='"+userid+"' and pwd='"+password+"'");
        return profileList;
    }
	
}
