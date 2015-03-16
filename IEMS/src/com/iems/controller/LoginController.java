package com.iems.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.iems.model.EmployeeModel;
import com.iems.model.LoginValidation;

@Controller
@SessionAttributes
public class LoginController
{
	
	@RequestMapping(value="/LoginController",method=RequestMethod.POST)			
	public ModelAndView processCredentials(@RequestParam("userName")String userid,@RequestParam("password")String emppassword,HttpServletRequest request) 
	
	{
		
			  LoginValidation login=new LoginValidation();
			  Map<String, Object> model = new HashMap<String, Object>(); 
			  
			  System.out.println("----->"+login.checkValidation(userid, emppassword).size());
			  
			  if(login.checkValidation(userid, emppassword).size()>0)
			  {
				  HttpSession session=request.getSession();
				  session.setAttribute("name", userid);
				  session.setAttribute("eid",new EmployeeModel().getEid(userid).get(0));
				  System.out.println(new EmployeeModel().getEid(userid).get(0));
				 return new ModelAndView("results",model);
			  }
			  else
			  {
				  model.put("message","<b>Sorry, username or password incorrect!,Please Try again....</b>");
				  return new ModelAndView("LoginFailed",model);
			  }		  
			  

	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session )
	{
	     
        session.invalidate();       
        return "logout";
     }
	 
		@RequestMapping(value="/index")
		public String homePage()
		{
			return "index";
		}

}