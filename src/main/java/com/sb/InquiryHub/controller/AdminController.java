package com.sb.InquiryHub.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sb.InquiryHub.model.AssociateCompany;
import com.sb.InquiryHub.model.Hubtype;
import com.sb.InquiryHub.model.InquiryDB;
import com.sb.InquiryHub.model.User;
import com.sb.InquiryHub.service.AssociateCompanyService;
import com.sb.InquiryHub.service.HubtypeService;
import com.sb.InquiryHub.service.InquiryDBService;
import com.sb.InquiryHub.service.UserService;


@Controller
@RequestMapping("/")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AssociateCompanyService associateCompanyService;
	
	@Autowired
	private HubtypeService hubtypeService;
	
	@Autowired
	private InquiryDBService inquiryDBService;
		
	@PostMapping("/Login")    
	public ModelAndView Login(@ModelAttribute User user)  
	{    
			
			ModelAndView modelAndView = new ModelAndView();    
			List <User> userList = userService.getUserValidate(user.getUserEmail(), user.getPassword());

			if(userList.isEmpty()) {

					modelAndView.setViewName("SignIn");        
				
			} else {
				
				String userType = userList.getFirst().getUserType();

				if (user.getUserType().equals(userType)) {
			
				switch(userType) {
			
					case "superadmin" : 
										modelAndView.setViewName("adminHome");        
										modelAndView.addObject("loginList", userList);      
										break;
					case "associative" :
										
										String acName = userList.getFirst().getAssociateName();
								
										List<InquiryDB> inquiryList = inquiryDBService.getInquiryListbyHub(acName);
							
										modelAndView.setViewName("associativeHome");      
										modelAndView.addObject("inquiryList", inquiryList);     
										modelAndView.addObject("userList", userList.get(0));      
										break;
					case "normal" :
										// List <Hubtype> htList = hubTypeService.getHubTypeList();
										
										List <AssociateCompany> acList1 = associateCompanyService.getAssociateCompanyWithHubtype(1);
										List <AssociateCompany> acList2 = associateCompanyService.getAssociateCompanyWithHubtype(2);
										List <AssociateCompany> acList3 = associateCompanyService.getAssociateCompanyWithHubtype(3);
										List <AssociateCompany> acList4 = associateCompanyService.getAssociateCompanyWithHubtype(4);
										List <AssociateCompany> acList5 = associateCompanyService.getAssociateCompanyWithHubtype(5);
										List <AssociateCompany> acList6 = associateCompanyService.getAssociateCompanyWithHubtype(6);
										
										// System.out.println("hubtype name id : " + acList1.getFirst().getHubtype().getHubTypeName());
										modelAndView.setViewName("userHome");       
										modelAndView.addObject("userList", userList);
										modelAndView.addObject("companyList1", acList1); 
										modelAndView.addObject("companyList2", acList2); 
										modelAndView.addObject("companyList3", acList3); 
										modelAndView.addObject("companyList4", acList4); 
										modelAndView.addObject("companyList5", acList5); 
										modelAndView.addObject("companyList6", acList6); 
										break;
					
				}
				}
				else {
					modelAndView.setViewName("SignIn");        
					
				}
			}
			return modelAndView;    
	}

	
	@GetMapping("adminHome/UserInfo")    
	public ModelAndView UserInfo(@ModelAttribute User user)  
	{    
		ModelAndView modelAndView = new ModelAndView();    

		modelAndView.setViewName("adminUserInfo");        
		modelAndView.addObject("userList", userService.getUserList());      
		return modelAndView;    
		
	}
	
	@GetMapping("/ACInfo")    
	public ModelAndView AssCompanyInfo(@ModelAttribute AssociateCompany associateCompany)  
	{    
		ModelAndView modelAndView = new ModelAndView();    

		modelAndView.setViewName("adminACInfo");        
		modelAndView.addObject("htList", hubtypeService.getHubTypeList());
		modelAndView.addObject("acList", associateCompanyService.getAssociateCompanyList());
		
		return modelAndView;    
		
	}
	
	
	@GetMapping("/HubtypeInfo")    
	public ModelAndView HubtypeInfo(@ModelAttribute Hubtype hubtype)  
	{    
		ModelAndView modelAndView = new ModelAndView();    

		modelAndView.setViewName("adminHubtypeInfo");        
		modelAndView.addObject("htList", hubtypeService.getHubTypeList());      
		return modelAndView;    
		
	}

	@GetMapping("/InquiryInfo")    
	public ModelAndView InquiryInfo(@ModelAttribute InquiryDB inquiryDB)  
	{    
		ModelAndView modelAndView = new ModelAndView();    

		modelAndView.setViewName("adminInquiryInfo");        
		modelAndView.addObject("inquiryList", inquiryDBService.getInquiryList());      
		return modelAndView;    
		
	}

	
	
	
	
}
