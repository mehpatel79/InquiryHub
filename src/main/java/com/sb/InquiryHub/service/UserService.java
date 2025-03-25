package com.sb.InquiryHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.InquiryHub.model.User;
import com.sb.InquiryHub.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUserList(){
		return userRepository.findAll();
	}

	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public User saveUser(User user) {
		User userData = userRepository.save(user);
		return userData;
	}
	
	
	public List<User> getUserValidate(String userEmail, String password){
		return userRepository.getUserByUserEmailAndPassword(userEmail, password);
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
}
