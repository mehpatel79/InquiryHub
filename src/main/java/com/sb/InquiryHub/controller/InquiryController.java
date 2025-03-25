package com.sb.InquiryHub.controller;

import java.text.SimpleDateFormat;   
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sb.InquiryHub.model.AssociateCompany;
import com.sb.InquiryHub.model.InquiryDB;
import com.sb.InquiryHub.model.User;
import com.sb.InquiryHub.service.AssociateCompanyService;
import com.sb.InquiryHub.service.HubtypeService;
import com.sb.InquiryHub.service.InquiryDBService;
import com.sb.InquiryHub.service.UserService;

@Controller
@RequestMapping("/")
public class InquiryController {

	@Autowired
	private InquiryDBService inquiryDBService;
	
	@Autowired
	private AssociateCompanyService associateCompanyService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("ITWeb/{id}/{acname}")    
	public ModelAndView ITWebInquiry(@ModelAttribute @PathVariable("id") Integer id, @PathVariable("acname") String acname, InquiryDB inquiryDB)  
	{    
			ModelAndView modelAndView = new ModelAndView();    
		
			User userData = userService.getUserById(id);
			// System.out.println("username : " + userData.getUserName());

			modelAndView.addObject("userData", userData);
			modelAndView.addObject("userName", userData.getUserName());
			modelAndView.addObject("userID", userData.getId());
			modelAndView.addObject("acName", acname);
			modelAndView.setViewName("ITWeb");        
			
			
		return modelAndView;    
	}
	
	
	@PostMapping("inquiryITWeb")    
	public ModelAndView save(@ModelAttribute String acname, InquiryDB inquiryDB)  
	{    
			ModelAndView modelAndView = new ModelAndView();    
		
			LocalDateTime date = LocalDateTime.now();
			
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			
			String creationDate = date.format(dateformat);
			
			// String date1 = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(LocalDateTime.now()));
			inquiryDB.setCreationDate(creationDate);
			inquiryDB.setInquiryStatus("New");
			modelAndView.setViewName("SignIn");        
			
			// System.out.println("inquiry db : " + inquiryDB.toString());
			inquiryDBService.saveInquiry(inquiryDB);
			
		return modelAndView;    
	}
	
	
	@PostMapping("search")    
	public ModelAndView Login(@ModelAttribute AssociateCompany associateCompany)  
	{    
			
			ModelAndView modelAndView = new ModelAndView();    
										
					List <AssociateCompany> acList1 = associateCompanyService.getAssociateCompanyWithHubtype(1);
					List <AssociateCompany> acList2 = associateCompanyService.getAssociateCompanyWithHubtype(2);
					List <AssociateCompany> acList3 = associateCompanyService.getAssociateCompanyWithHubtype(3);
					List <AssociateCompany> acList4 = associateCompanyService.getAssociateCompanyWithHubtype(4);
					List <AssociateCompany> acList5 = associateCompanyService.getAssociateCompanyWithHubtype(5);
					List <AssociateCompany> acList6 = associateCompanyService.getAssociateCompanyWithHubtype(6);
										
					modelAndView.setViewName("SearchList");       
					modelAndView.addObject("companyList1", acList1); 
					modelAndView.addObject("companyList2", acList2); 
					modelAndView.addObject("companyList3", acList3); 
					modelAndView.addObject("companyList4", acList4); 
					modelAndView.addObject("companyList5", acList5); 
					modelAndView.addObject("companyList6", acList6); 
					
				
			return modelAndView;    
	}

	
	
	@GetMapping("/CancelInquiry")    
	public ModelAndView cancel(@ModelAttribute @PathVariable Integer id)  
	{    
		
			User userData = userService.getUserById(id);
			
			ModelAndView modelAndView = new ModelAndView();    
			modelAndView.addObject("userData", userData);
			modelAndView.setViewName("ITWeb");        
			
		return modelAndView;    
	}

	
	
}
