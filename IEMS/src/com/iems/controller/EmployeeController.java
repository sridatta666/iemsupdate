/**
 * 
 */
package com.iems.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.log4j.lf5.util.DateFormatManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.iems.dao.EmployeeDao;
import com.iems.entity.Education;
import com.iems.entity.Employee;
import com.iems.entity.Experience;
import com.iems.entity.Profile;
import com.iems.entity.SkillsEntity;
import com.iems.model.AddEmployeeModel;
import com.iems.model.EmployeeModel;
import com.iems.model.SkillsModel;
import com.sun.mail.iap.Response;

/**
 * @author hareendrakumar
 *
 */
@Controller
@SessionAttributes("eid")
public class EmployeeController 
{
 int i;
	@RequestMapping(value="/list")
	   public ModelAndView  listEmployees()
	   {
		   EmployeeModel employeeModel=new EmployeeModel();
		   Map<String, Object> model = new HashMap<String, Object>(); 
		   model.put("emplist", employeeModel.listEmployee());
		   return new ModelAndView("List",model);
	   }
	
	@RequestMapping(value="/profile")
	public ModelAndView EmployeeProfile(ModelMap model,@ModelAttribute("eid")int eid){
		EmployeeModel model1=new EmployeeModel();
		SkillsModel skillsmodel=new SkillsModel();
		model.addAttribute("emp1",model1.getEmployee(eid));
		model.addAttribute("pro1",model1.getProfile(eid));
		model.addAttribute("edu", model1.getEducationList(eid));
		model.addAttribute("exp",model1.getExperienceList(eid));
		
	    return new ModelAndView("profile",model);
	}
	@RequestMapping(value="/editprofile")
	public ModelAndView editProfileDetails(ModelMap map,HttpServletRequest req,@ModelAttribute("eid")int eid) throws ParseException{
		
		//SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		//String dob1=req.getParameter("dobfld");
		//Date dob=df.parse(dob1);
		
	//	java.sql.Date sqldate=new java.sql.Date(dob.getTime());
	    String passport=req.getParameter("passportfld");
		String summary=req.getParameter("summaryfld");
		EmployeeModel model=new EmployeeModel();
		Employee emp1=model.getEmployee(eid);
		
		emp1.setDob(emp1.getDob());
		emp1.setPassport(passport);
		emp1.setSummary(summary);
		emp1.setEid(eid);
		emp1.setPhoto("sadsad");
		emp1.setEmpResume("asdasdas");
		model.insertProfile(emp1);
		return new ModelAndView("redirect:/edit");
	}
	
	@RequestMapping(value="/skillselect")
	public ModelAndView addskills(ModelMap modelmap,HttpServletRequest req,@ModelAttribute("eid")int eid){
	EmployeeModel model=new EmployeeModel();
		String[] skillidString=req.getParameterValues("skill");
	String skillString="";
		for (String string : skillidString) {
		skillString=skillString+string;
	}
		System.out.println(skillString);
		int[] skillids=new int[skillidString.length];
	
	for (int i=0;i<skillidString.length;i++) {
	    
		skillids[i]=Integer.parseInt(skillidString[i]);
	
	}	
	
	//model.addSkillToEmployee(eid,skillids);

	//List<String> names=model.getEmployeeSkillNames(eid);
	//System.out.println(names.get(0));
	return new ModelAndView("redirect:/edit");
	}
	
	@RequestMapping(value="/edit")
	public ModelAndView editProfile(ModelMap modelmap,@ModelAttribute("eid")int eid){
		EmployeeModel model1=new EmployeeModel();
		SkillsModel skillmodel=new SkillsModel();
		modelmap.addAttribute("emp1",model1.getEmployee(eid));
	    modelmap.addAttribute("pro1",model1.getProfile(eid));
	    modelmap.addAttribute("skillslist",skillmodel.listSkills());
		modelmap.addAttribute("edu", model1.getEducationList(eid));
	    modelmap.addAttribute("exp", model1.getExperienceList(eid));
		
	    return new ModelAndView("edit1",modelmap);	
	}

	@RequestMapping(value="/addedu")
    public ModelAndView addeducation(HttpServletRequest req,HttpServletResponse res,@ModelAttribute("eid")int eid){
		

	   	String deg=req.getParameter("Degreefld");
		String uni=req.getParameter("Boardfld");
		String yr=req.getParameter("Yearfld");
		String edu=deg+","+uni+","+yr;
	    
		EmployeeModel model=new EmployeeModel();
	    Education education1=prepareEducationBean(eid, edu);
		if(!(req.getParameter("eduid").isEmpty())){
		int id=Integer.parseInt(req.getParameter("eduid"));
		education1.setId(id);
		System.out.println(id);
		}
		model.insertedu(education1);
		return new ModelAndView("redirect:/edit");
		
	}
	 @RequestMapping(value = "/editedu", method = RequestMethod.GET)
	 public ModelAndView editEducation(ModelMap model,@ModelAttribute("eid")int eid,HttpServletRequest request,HttpServletResponse response) {
	 	EmployeeModel employeeModel=new EmployeeModel();
	 		int columnid=Integer.parseInt(request.getParameter("educolumnid"));
	        	   
	 		//model.addAttribute("eduString",employeeModel.getColumn1(columnid,eid));
	 		String total=(String)employeeModel.getColumn1(columnid,eid).get(0);
	 		String[] degreelist=total.split(",");		
	 		model.addAttribute("degreestring",degreelist[0]);
	 		model.addAttribute("boardstring",degreelist[1]);
	 		model.addAttribute("yearstring",degreelist[2]);
	 		model.addAttribute("educolumnidfld",request.getParameter("educolumnid"));
	 		System.out.println(degreelist[0]+" "+degreelist[1]+" "+degreelist[2]);
	 		editProfile(model,eid);
	 		return new ModelAndView("edit1",model);
	 }
     
	 @RequestMapping(value="/deleteedu")
	 public ModelAndView deleteEducation(ModelMap modelmap,@ModelAttribute("eid")int eid,HttpServletRequest request,HttpServletResponse response) {
	 
		EmployeeModel model=new EmployeeModel();
		model.deleteedu(model.getEducationListbycolumn(eid,Integer.parseInt(request.getParameter("educolumnid"))).get(0));
	         return new ModelAndView("redirect:/edit");
	 }
    @RequestMapping(value="/addexp") 
    public ModelAndView addexp(HttpServletRequest req,HttpServletResponse res,@ModelAttribute("eid")int eid){
 		
			
		   	String org=req.getParameter("orgfld");
			String desg=req.getParameter("desgfld");
			String start=req.getParameter("strtfld");
			String end=req.getParameter("endfld");
			String exp=org+","+desg+","+start+","+end;
			EmployeeModel model=new EmployeeModel();
			Experience experience1=prepareExperienceBean(eid, exp);
			if(!(req.getParameter("expid").isEmpty())){
			int id=Integer.parseInt(req.getParameter("expid"));
			experience1.setId(id);
			System.out.println(id);
			}
			model.insertexp(experience1);
			return new ModelAndView("redirect:/edit");
			
		}
    @RequestMapping(value = "/editexp", method = RequestMethod.GET)
	 public ModelAndView editExperience(ModelMap model,@ModelAttribute("eid")int eid,HttpServletRequest request,HttpServletResponse response) {
	 	EmployeeModel employeeModel=new EmployeeModel();
	 		int columnid=Integer.parseInt(request.getParameter("expcolumnid"));
	        	   
	 		//model.addAttribute("eduString",employeeModel.getColumn2(columnid,eid));
	 		String total=(String)employeeModel.getColumn2(columnid,eid).get(0);
	 		String[] organizationlist=total.split(",");		
	 		model.addAttribute("orgstring",organizationlist[0]);
	 		model.addAttribute("desgstring",organizationlist[1]);
	 		model.addAttribute("startstring",organizationlist[2]);
	 		model.addAttribute("endstring",organizationlist[3]);
	 		model.addAttribute("expcolumnidfld",request.getParameter("expcolumnid"));
	 		System.out.println(organizationlist[0]+" "+organizationlist[1]+" "+organizationlist[2]+" "+organizationlist[3]);
	 		editProfile(model,eid);
	 		return new ModelAndView("edit1",model);
	 }
    @RequestMapping(value="/deleteexp")
	 public ModelAndView deleteExperience(ModelMap modelmap,@ModelAttribute("eid")int eid,HttpServletRequest request,HttpServletResponse response) {
	 
		EmployeeModel model=new EmployeeModel();
		model.deleteexp(model.getExperienceListbycolumn(eid,Integer.parseInt(request.getParameter("expcolumnid"))).get(0));
	         return new ModelAndView("redirect:/edit");
	 }
    
	private Education prepareEducationBean(int empid,String edu){
		Education bean = new Education();
		bean.setEid(empid);
		bean.setDegree(edu);
		
		return bean;
	}
	
	
	  
     private Experience prepareExperienceBean(int empid,String exp){
			Experience bean = new Experience();
			bean.setEid(empid);
			bean.setOrganization(exp);
			
			return bean;
		}
		
		
}
