package com.sb.InquiryHub.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

	
	@GetMapping("index")
	public String display() {
		return "index";
	}
	
	@GetMapping("test")
	public String welcomeMethod() {
		return "Welcome to Spring Boot Application for Inquiry Hub Portal";
	}
	
	
	@GetMapping("SignUp")
	public String SignUp() {
		return "SignUp";
	}
	
	@GetMapping("SignIn")
	public String SignIn() {
		return "SignIn";
	}
	
	
	@GetMapping("Login")
	public String Login() {
		return "Login";
	}
	
	@GetMapping("adminHome")
	public String adminHome() {
		return "adminHome";
	}
	
	@GetMapping("associativeHome")
	public String AssociativeHome() {
		return "associativeHome";
	}
	
	
	@GetMapping("userHome")
	public String userHome() {
		return "userHome";
	}
	
	@GetMapping("AboutUs")
	public String AboutUs() {
		return "AboutUs";
	}
	
	@GetMapping("ITWeb")
	public String ITWeb() {
		return "ITWeb";
	}
	
	@GetMapping("inquiryITWeb")
	public String InquiryITWeb() {
		return "inquiryITWeb";
	}
	
	
	@GetMapping("UserEdit")
	public String UserEdit() {
		return "UserEdit";
	}
	
	@GetMapping("addAssociate")
	public String AddAssociate() {
		return "addAssociate";
	}
	
	
}
