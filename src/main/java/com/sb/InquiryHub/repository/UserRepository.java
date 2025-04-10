package com.sb.InquiryHub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.InquiryHub.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	List<User> getUserByUserEmailAndPassword(String userEmail, String password);

	
}


