package com.sb.InquiryHub.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.sb.InquiryHub.model.AssociateCompany;
import com.sb.InquiryHub.model.Hubtype;
import com.sb.InquiryHub.model.InquiryDB;
import com.sb.InquiryHub.model.User;
import com.sb.InquiryHub.repository.AssociateCompanyRepository;
import com.sb.InquiryHub.repository.HubtypeRepository;
import com.sb.InquiryHub.service.InquiryDBService;
import com.sb.InquiryHub.service.UserService;

@Controller
public class ACController {

	@Autowired
	private AssociateCompanyRepository acRepository;
	
	@Autowired
	private HubtypeRepository hubtypeRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InquiryDBService inquiryDBService;
	
	@GetMapping("/SearchList1")
	public String showACList(@PathVariable Integer id, Model model) {
		
	Optional<Hubtype> hubtype = hubtypeRepository.findById(id);
	
	List<AssociateCompany> acList = acRepository.findByHubtypeId(id);
	
	return "SearchList";
	
	}
	
	
	
	@GetMapping("/associateHome/New/{id}/{acname}")    
	public ModelAndView inquiryNew(@ModelAttribute @PathVariable("id") Integer id, @PathVariable("acname") String acname, InquiryDB inquiryDB, User user)  
	{    
		
				ModelAndView modelAndView = new ModelAndView();    
			
				User userData = userService.getUserById(id);
		
				// List<InquiryDB> inquiryList = inquiryDBService.getInquiryDBbyHubAndStatus(acName, "New");
	
				List<InquiryDB> inquiryList = inquiryDBService.getInquiryListbyHub(acname);
				
				modelAndView.setViewName("associativeNew");        
				modelAndView.addObject("userName", userData.getUserName());
				modelAndView.addObject("inquiryList", inquiryList);     
				
				modelAndView.addObject("userList", userData);      
				return modelAndView;    
	}

	
	@GetMapping("Pending/{id}/{acname}")    
	public ModelAndView inquiryPending(@ModelAttribute @PathVariable("id") Integer id, @PathVariable("acname") String acname, InquiryDB inquiryDB, User user)  
	{    
				ModelAndView modelAndView = new ModelAndView();    
			
				User userData = userService.getUserById(id);
		
				// List<InquiryDB> inquiryList = inquiryDBService.getInquiryDBbyHubAndStatus(acName, "Pending");

				List<InquiryDB> inquiryList = inquiryDBService.getInquiryListbyHub(acname);
		
				modelAndView.setViewName("associativePending");        
				modelAndView.addObject("userName", userData.getUserName());
				modelAndView.addObject("inquiryList", inquiryList);     
				modelAndView.addObject("userList", userData);      

				return modelAndView;    
	}
	
	
	@GetMapping("Join/{id}/{acname}")    
	public ModelAndView inquiryJoin(@ModelAttribute @PathVariable("id") Integer id, @PathVariable("acname") String acname, InquiryDB inquiryDB, User user)  
	{    
				ModelAndView modelAndView = new ModelAndView();    
			
				User userData = userService.getUserById(id);
		
				// List<InquiryDB> inquiryList = inquiryDBService.getInquiryDBbyHubAndStatus(acName, "Join");
		
				List<InquiryDB> inquiryList = inquiryDBService.getInquiryListbyHub(acname);

				modelAndView.setViewName("associativeJoin");        
				modelAndView.addObject("userName", userData.getUserName());
				modelAndView.addObject("inquiryList", inquiryList);     
				modelAndView.addObject("userList", userData);      

				return modelAndView;    
	}
	
	@GetMapping("NotJoin/{id}/{acname}")    
	public ModelAndView inquiryNotJoin(@ModelAttribute @PathVariable("id") Integer id, @PathVariable("acname") String acname, InquiryDB inquiryDB, User user)  
	{    
				ModelAndView modelAndView = new ModelAndView();    
			
				User userData = userService.getUserById(id);
		
				// List<InquiryDB> inquiryList = inquiryDBService.getInquiryDBbyHubAndStatus(acName, "NotJoin");
		
				List<InquiryDB> inquiryList = inquiryDBService.getInquiryListbyHub(acname);

				modelAndView.setViewName("associativeNotJoin");        
				modelAndView.addObject("userName", userData.getUserName());
				modelAndView.addObject("inquiryList", inquiryList);     
				modelAndView.addObject("userList", userData);      

				return modelAndView;    
	}
	
	
	
	@GetMapping("/JoinInquiry/{id}/{userid}")
	public ModelAndView JoinInquiry(@PathVariable("id") Integer id, @PathVariable("userid") Integer userid) {	

		ModelAndView modelAndView = new ModelAndView();    

		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String updateDate = date.format(dateformat);
		
		
		InquiryDB inquiryDB = inquiryDBService.getInquiryDBById(id);
		
		User userList = userService.getUserById(userid);
		
		inquiryDB.setInquiryStatus("Join");
		inquiryDB.setUpdatedDate(updateDate);
		inquiryDB.setInquiryAttendBy(userList.getUserName());
		
		inquiryDBService.saveInquiry(inquiryDB);
		
		modelAndView.setViewName("associativeHome");        
		modelAndView.addObject("userList", userList);      

		modelAndView.addObject("inquiryList", inquiryDBService.getInquiryList());

		return modelAndView;    
	}
	

	@GetMapping("/NotJoinInquiry/{id}/{userid}")
	public ModelAndView NotJoinInquiry(@PathVariable("id") Integer id, @PathVariable("userid") Integer userid) {	

		ModelAndView modelAndView = new ModelAndView();    

		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String updateDate = date.format(dateformat);
		
		
		InquiryDB inquiryDB = inquiryDBService.getInquiryDBById(id);
		
		User userList = userService.getUserById(userid);
		
		inquiryDB.setInquiryStatus("NotJoin");
		inquiryDB.setUpdatedDate(updateDate);
		inquiryDB.setInquiryAttendBy(userList.getUserName());
		
		inquiryDBService.saveInquiry(inquiryDB);
		
		modelAndView.setViewName("associativeHome");        
		modelAndView.addObject("userList", userList);      

		modelAndView.addObject("inquiryList", inquiryDBService.getInquiryList());

		return modelAndView;    
	}

	@GetMapping("/WaitInquiry/{id}/{userid}")
	public ModelAndView WaitInquiry(@PathVariable("id") Integer id, @PathVariable("userid") Integer userid) {	

		ModelAndView modelAndView = new ModelAndView();    

		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String updateDate = date.format(dateformat);
		
		
		InquiryDB inquiryDB = inquiryDBService.getInquiryDBById(id);
		
		User userList = userService.getUserById(userid);
		
		inquiryDB.setInquiryStatus("Pending");
		inquiryDB.setUpdatedDate(updateDate);
		inquiryDB.setInquiryAttendBy(userList.getUserName());
		
		inquiryDBService.saveInquiry(inquiryDB);
		
		modelAndView.setViewName("associativeHome");        
		modelAndView.addObject("userList", userList);      

		modelAndView.addObject("inquiryList", inquiryDBService.getInquiryList());

		return modelAndView;    
	}

	


	
	
	
}
