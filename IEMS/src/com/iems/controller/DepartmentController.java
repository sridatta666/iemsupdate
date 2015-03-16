package com.iems.controller;

import org.springframework.stereotype.Controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.iems.entity.DepartmentEntity;
import com.iems.model.DepartmentModel;


@Controller
public class DepartmentController {
	@RequestMapping(value="/Department")
	   public ModelAndView  homepage(ModelMap model)
	   {	
		   DepartmentModel employeeModel=new DepartmentModel();
		   model.addAttribute("departmentlist",employeeModel.listDepartments());
		   System.out.println("hellosss"); 
		   return  new ModelAndView("addDepartment", "departments", new DepartmentEntity());  
	   }
	@RequestMapping(value="/saveDepartment", method=RequestMethod.POST)
	   public ModelAndView printHello(ModelMap model,@ModelAttribute DepartmentEntity departments) 
		 {
	      model.addAttribute("message", "List Of Departments are:");     
	      DepartmentModel employeeModel=new DepartmentModel();
	      employeeModel.insertDepartments(departments);
	      System.out.println("successfully saved");
	      model.addAttribute("departmentlist",employeeModel.listDepartments());
	      return new ModelAndView("results","departments",new DepartmentEntity());
	   }
	
	@RequestMapping(value = "/deleteDepartment", method = RequestMethod.GET)
	public ModelAndView deleteDepartment(ModelMap model,@ModelAttribute DepartmentEntity skills,HttpServletRequest request) 
    {
		DepartmentModel employeeModel=new DepartmentModel();
		DepartmentEntity department1=new DepartmentEntity();
	    department1.setDepartmentid(Integer.parseInt(request.getParameter("id")));  
		employeeModel.deleteDepartments(department1);
		System.out.println("final--");
	    model.addAttribute("departmentlist",employeeModel.listDepartments());
		return new ModelAndView("results", "departments",new DepartmentEntity());
	}
	 @RequestMapping(value = "/editDepartment", method = RequestMethod.GET)
	 public ModelAndView editSkill(ModelMap model,@ModelAttribute DepartmentEntity departments, HttpServletRequest request ) {
		 DepartmentModel employeeModel=new DepartmentModel();
	 		List<DepartmentEntity> emp=employeeModel.editDepartments(Integer.parseInt((request.getParameter("id"))));
	 		System.out.println("---->"+request.getParameter("id"));
	 		System.out.println("employee Departments"+emp.get(0));
	 		 model.addAttribute("departmentlist",employeeModel.listDepartments());
	 		model.addAttribute("emp", emp.get(0));
	 		return new ModelAndView("addDepartment", "departments",new DepartmentEntity());
	 	}

	   

}
