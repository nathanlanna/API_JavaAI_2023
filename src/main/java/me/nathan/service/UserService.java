package me.nathan.service;

import org.springframework.stereotype.Service;

import me.nathan.domain.entity.User;


public interface UserService{

	User findById(Long id);
	
	User createUser(User user);
}
