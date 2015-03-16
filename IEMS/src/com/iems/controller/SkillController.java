package com.iems.controller;

import org.springframework.stereotype.Controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.iems.entity.SkillsEntity;
import com.iems.model.SkillsModel;


@Controller
public class SkillController {
	@RequestMapping(value="/Skill")
	   public ModelAndView  homepage(ModelMap model)
	   {	
		   SkillsModel employeeModel=new SkillsModel();
		   model.addAttribute("skilllist",employeeModel.listSkills());
		   System.out.println("hellosss"); 
		   return  new ModelAndView("addSkill", "skills", new SkillsEntity());  
	   }
	@RequestMapping(value="/saveSkill", method=RequestMethod.POST)
	   public ModelAndView printHello(ModelMap model,@ModelAttribute SkillsEntity skills) 
		 {
	      model.addAttribute("message", "List Of Skills are:");     
	      SkillsModel employeeModel=new SkillsModel();
	      employeeModel.insertSkills(skills);
	      System.out.println("successfully saved");
	      model.addAttribute("skilllist",employeeModel.listSkills());
	      return new ModelAndView("results","skills",new SkillsEntity());
	   }
	
	@RequestMapping(value = "/deleteSkill", method = RequestMethod.GET)
	public ModelAndView deleteSkill(ModelMap model,@ModelAttribute SkillsEntity skills,HttpServletRequest request) 
    {
	    SkillsModel employeeModel=new SkillsModel();
	    SkillsEntity skills1=new SkillsEntity();
	    skills1.setSkillid(Integer.parseInt(request.getParameter("id")));  
		employeeModel.deleteSkills(skills1);
		System.out.println("final--");
	    model.addAttribute("skilllist",employeeModel.listSkills());
		return new ModelAndView("results", "skills",new SkillsEntity());
	}
	 @RequestMapping(value = "/editSkill", method = RequestMethod.GET)
	 public ModelAndView editSkill(ModelMap model,@ModelAttribute SkillsEntity skills, HttpServletRequest request ) {
		    SkillsModel employeeModel=new SkillsModel();
	 		List<SkillsEntity> emp=employeeModel.editSkills(Integer.parseInt((request.getParameter("id"))));
	 		System.out.println("---->"+request.getParameter("id"));
	 		System.out.println("employee skills"+emp.get(0));
	 		 model.addAttribute("skilllist",employeeModel.listSkills());
	 		model.addAttribute("emp", emp.get(0));
	 		return new ModelAndView("addSkill", "skills",new SkillsEntity());
	 	}

	   

}
