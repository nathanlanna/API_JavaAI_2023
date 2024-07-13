package me.nathan.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.nathan.domain.entity.User;
import me.nathan.domain.repository.UserRepository;
import me.nathan.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User createUser(User userToCreate) {
		
		if(userToCreate.getId()!=null && userRepository.existsById(userToCreate.getId())) {
			throw new IllegalArgumentException("the User ID already exists");
		}
		
		return userRepository.save(userToCreate);
	}

}
