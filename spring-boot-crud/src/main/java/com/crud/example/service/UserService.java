package com.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.example.domain.User;
import com.crud.example.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user){
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(String id){
		return userRepository.findById(id);
	}
	
	public User updateUser(User user,String id){
		user.setId(id);
		return userRepository.save(user);
	}
	
	public int deleteUser(String id){
		return userRepository.deleteUserById(id);
	}
}
