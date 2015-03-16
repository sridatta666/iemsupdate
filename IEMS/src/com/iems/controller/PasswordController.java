package com.iems.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;







import com.iems.entity.Profile;
import com.iems.model.PasswordModel;
import com.iems.controller.*;

@Controller
public class PasswordController {
	 @RequestMapping(value="/save")
	
	   public ModelAndView  listEmployees(ModelMap model,@ModelAttribute Profile employee,HttpServletRequest request)
	   {
		 System.out.println("hello1");
		 HttpSession session=request.getSession();
		 PasswordModel employeeModel=new PasswordModel();
		 String oldpwd=request.getParameter("pwd");
		 String newpwd=request.getParameter("newpwd");
		 String conpwd=request.getParameter("reenterpwd");	 
		 String userid=session.getAttribute("name").toString();
			List<Profile> emp=employeeModel.selectEmployee(userid);
			String pwd=emp.get(0).getPwd();
		System.out.println(emp.get(0).getPwd());
		
		
		 if(pwd.equals(oldpwd))
		 {
		if(newpwd.equals(conpwd))
		{    
		  employeeModel.updateEmployee(newpwd,userid);
		  System.out.println("hello");
		}
		 }
		return  new ModelAndView("changePassword");   
	   }

	 @RequestMapping(value="/changePassword")
		
	   public String homepage()
	   {
	 return "changePassword";
	   }
}
