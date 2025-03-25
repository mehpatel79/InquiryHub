package com.sb.InquiryHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sb.InquiryHub.model.AssociateCompany;
import com.sb.InquiryHub.model.Hubtype;
import com.sb.InquiryHub.model.User;
import com.sb.InquiryHub.service.AssociateCompanyService;
import com.sb.InquiryHub.service.HubtypeService;

@Controller
@RequestMapping("/")
public class HubController {

	@Autowired
	private AssociateCompanyService associateCompanyService;
	
	@Autowired
	private HubtypeService hubtypeService;

	
		
	@PostMapping("addAssociate")    
	public ModelAndView saveAssociateHub(@ModelAttribute AssociateCompany associateCompany)  
	{    
		
		ModelAndView modelAndView = new ModelAndView();    

		System.out.println("associate : " + associateCompany.toString());
		//associateCompanyService.saveAssociate(associateCompany);
		modelAndView.setViewName("adminACInfo");        
		modelAndView.addObject("acList", associateCompanyService.getAssociateCompanyList());      
		return modelAndView;    
	}    

	@PostMapping("addHubtype")    
	public ModelAndView saveHubtype(@ModelAttribute Hubtype hubtype)  
	{    
		ModelAndView modelAndView = new ModelAndView();    
		hubtypeService.saveHubType(hubtype);
		modelAndView.setViewName("adminHubtypeInfo");        
		modelAndView.addObject("htList", hubtypeService.getHubTypeList());      
		return modelAndView;    
	}    


		
}
