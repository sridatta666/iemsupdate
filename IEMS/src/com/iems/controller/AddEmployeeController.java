package com.iems.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.dialect.Sybase11Dialect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iems.entity.DepartmentEntity;
import com.iems.entity.DesignationEntity;
import com.iems.entity.Profile;
import com.iems.model.AddEmployeeModel;


@Controller
public class AddEmployeeController {
	 String fname;
	 String lname;
	
	
	 @RequestMapping(value="/AddEmployee")
	   public ModelAndView  homepage(ModelMap modelmap)
	   {
		 Map<Integer,String> department = new HashMap<Integer,String>();
		 AddEmployeeModel employeeModel=new AddEmployeeModel();
		 	List<DepartmentEntity> emp=employeeModel.departmentList();
		 	System.out.println(emp);
			modelmap.addAttribute("deptlist",emp);
			List<DesignationEntity> emp1=employeeModel.designationList();
		 	System.out.println(emp1);
			modelmap.addAttribute("desglist",emp1);	
			modelmap.addAttribute("emplist", employeeModel.listEmployee());
			return  new ModelAndView("AddEmployee", "employee",new Profile());  
	  }
	
	 
	 @RequestMapping(value="/saveEmployee")
	   public ModelAndView  listEmployees(ModelMap model,@ModelAttribute Profile employee)
	   {
		 fname= employee.getFirstname();
		    lname= employee.getLastname();
		   String userid=new String( fname+"."+lname);
		   System.out.println(userid);
		   employee.setUserid(userid);
		   if(employee.getEid()==0)
		   {
		   employee.setPwd("password");
		   employee.setActive(true);
		   }
		  AddEmployeeModel employeeModel=new AddEmployeeModel();
		  employeeModel.insertEmployee(employee);
		   model.put("emplist", employeeModel.listEmployee());
		   return new ModelAndView("AddEmployee","employee",new Profile());
	   }
	 @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
		public ModelAndView editEmployee(ModelMap model,HttpServletRequest request) 
	   {
			//Map<String, Object> model1= new HashMap<String, Object>();
			AddEmployeeModel employeeModel=new AddEmployeeModel();
			Profile emp=new Profile();
			emp.setEid(Integer.parseInt(request.getParameter("id")));
		      employeeModel.deleteEmployee(emp);
		      model.addAttribute("emplist", employeeModel.listEmployee());
		      System.out.println(model);
		      
		      
		      
		      List<DepartmentEntity> emp2=employeeModel.departmentList();
			 	System.out.println(emp2);
				model.addAttribute("deptlist",emp2);
				List<DesignationEntity> emp1=employeeModel.designationList();
			 	System.out.println(emp1);
				model.addAttribute("desglist",emp1);	
				model.addAttribute("emplist", employeeModel.listEmployee());
				
				
			
		      return new ModelAndView("AddEmployee","employee",new Profile()); 
		}
	
	 @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	 public ModelAndView deleteEmployee(ModelMap model,@ModelAttribute Profile employee,HttpServletRequest request) {
	 	AddEmployeeModel employeeModel=new AddEmployeeModel();
	 		System.out.println("{"+request.getParameter("id"));
	 		List<Profile> emp=employeeModel.editEmployee(Integer.parseInt(request.getParameter("id")));
	 		System.out.println("{"+emp.get(0));
	 		model.addAttribute("emplist", prepareEmployee(emp.get(0)));
	 		return new ModelAndView("AddEmployee", "employee",new Profile());
	 	}
	 private Profile prepareEmployee(Profile employee){
			Profile e = new Profile();
			e.setFirstname(employee.getFirstname());
			e.setLastname(employee.getLastname());
			e.setDepartment(employee.getDepartment());
			e.setDesignation(employee.getDesignation());
			e.setUserid((employee.getUserid()));
			return e;
		}
	
}
