package com.sb.InquiryHub.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sb.InquiryHub.model.Hubtype;
import com.sb.InquiryHub.model.User;
import com.sb.InquiryHub.service.AssociateCompanyService;
import com.sb.InquiryHub.service.HubtypeService;
import com.sb.InquiryHub.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HubtypeService hubtypeService;
	
	@Autowired
	private AssociateCompanyService associateCompanyService;

	@PostMapping("/RegistrationSubmit")    
	public ModelAndView save(@ModelAttribute User user)  
	{    
		
			ModelAndView modelAndView = new ModelAndView();    
			modelAndView.addObject("user", userService.saveUser(user));      

			modelAndView.setViewName("index");        
		return modelAndView;    
	}    
	
	@GetMapping("/userlist")    
	public ModelAndView userList(@ModelAttribute User user)  
	{    
			ModelAndView modelAndView = new ModelAndView();    
			modelAndView.setViewName("index");        
			modelAndView.addObject("userList", userService.getUserList());      
		return modelAndView;    
	}

	@GetMapping("userinfo")
	public List<User> getUserList(){
		return userService.getUserList();
	}
	
	
	
	@PostMapping("/LoginUser")    
	public ModelAndView LoginAdmin(@ModelAttribute User user)  
	{    
			
			ModelAndView modelAndView = new ModelAndView();    
			List <User> userList = userService.getUserValidate(user.getUserEmail(), user.getPassword());
			
			if(userList.isEmpty()) {

				modelAndView.setViewName("userLogin");        
				
			}else {
				modelAndView.setViewName("userHome");        
			}
		return modelAndView;    
	}

	
	@GetMapping("/user/edit/{id}")
	public ModelAndView editUser(@PathVariable("id") Integer id) {	
		ModelAndView modelAndView = new ModelAndView();    
		
		modelAndView.setViewName("UserEdit");        
		modelAndView.addObject("userEdit", userService.getUserById(id));  
		modelAndView.addObject("htList", hubtypeService.getHubTypeList());
		modelAndView.addObject("acList", associateCompanyService.getAssociateCompanyList());
		return modelAndView;    
	}
	
	@PostMapping("/Update")    
	public ModelAndView update(@ModelAttribute User user)  
	{    
			ModelAndView modelAndView = new ModelAndView();    
			userService.saveUser(user);
			modelAndView.setViewName("adminUserInfo");        
			modelAndView.addObject("userList", userService.getUserList());      
			
		return modelAndView;    
	}

	@GetMapping("/Cancel")    
	public ModelAndView cancel(@ModelAttribute User user)  
	{    
			ModelAndView modelAndView = new ModelAndView();    
			modelAndView.setViewName("adminUserInfo");        
			modelAndView.addObject("userList", userService.getUserList());      
			
		return modelAndView;    
	}

	
	@GetMapping("/user/delete/{id}")
	public ModelAndView deleteUser(@PathVariable("id") Integer id) {	
		userService.deleteUser(id);
		ModelAndView modelAndView = new ModelAndView();    
		modelAndView.setViewName("adminUserInfo");        
		modelAndView.addObject("userList", userService.getUserList());      
	return modelAndView;    
	}
	
	
	
	
	
}
