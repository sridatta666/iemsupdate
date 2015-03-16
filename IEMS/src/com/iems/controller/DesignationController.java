package com.iems.controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iems.entity.DesignationEntity;
import com.iems.entity.SkillsEntity;
import com.iems.model.DesignationModel;
import com.iems.model.SkillsModel;


@Controller
public class DesignationController {
	@RequestMapping(value="/Designation")
	   public ModelAndView  homepage(ModelMap model)
	   {	
		   DesignationModel employeeModel=new DesignationModel();
		   model.addAttribute("designationlist",employeeModel.listDesignations());
		   System.out.println("hellosss"); 
		   return  new ModelAndView("addDesignation", "designations", new DesignationEntity());  
	   }
	@RequestMapping(value="/saveDesignation", method=RequestMethod.POST)
	   public ModelAndView printHello(ModelMap model,@ModelAttribute DesignationEntity designation) 
		 {
	      model.addAttribute("message", "List Of Designations are:");     
	      DesignationModel employeeModel=new DesignationModel();
	      employeeModel.insertDesignations(designation);
	      System.out.println("successfully saved");
	      model.addAttribute("designationlist",employeeModel.listDesignations());
	      return new ModelAndView("results","designations",new DesignationEntity());
	   }
	
	@RequestMapping(value = "/deleteDesignation", method = RequestMethod.GET)
	public ModelAndView deleteDesignation(ModelMap model,@ModelAttribute DesignationEntity designation,HttpServletRequest request) 
    {
		DesignationModel employeeModel=new DesignationModel();
		DesignationEntity designation1=new DesignationEntity();
	    designation1.setDesignationid((Integer.parseInt(request.getParameter("id"))));  
		employeeModel.deleteDesignations(designation1);
		System.out.println("final--");
	    model.addAttribute("designationlist",employeeModel.listDesignations());
		return new ModelAndView("results", "designations",new DesignationEntity());
	}
	 @RequestMapping(value = "/editDesignation", method = RequestMethod.GET)
	 public ModelAndView editDesignation(ModelMap model,@ModelAttribute DesignationEntity designation, HttpServletRequest request ) {
		 DesignationModel employeeModel=new DesignationModel();
	 		List<DesignationEntity> emp=employeeModel.editDesignations(Integer.parseInt((request.getParameter("id"))));
	 		System.out.println("---->"+request.getParameter("id"));
	 		System.out.println("employee Designations"+emp.get(0));
	 		 model.addAttribute("designationlist",employeeModel.listDesignations());
	 		model.addAttribute("emp", emp.get(0));
	 		return new ModelAndView("addDesignation", "designations",new DesignationEntity());
	 	}

	   

}
