package com.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.domain.User;
import com.crud.example.service.UserService;
import com.crud.example.util.ResponseHandler;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	ResponseEntity<Object> saveUser(@RequestBody User user){
		User savedUser = userService.saveUser(user);
		if(savedUser!=null){
			return ResponseHandler.generateResponse(HttpStatus.OK,false,"User saved successfully",savedUser);
		}else{
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,true,"Unable to save user", null);
		}
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	ResponseEntity<Object> getUserById(@PathVariable String id){
		User user = userService.getUserById(id);
		if(user!=null){
			return ResponseHandler.generateResponse(HttpStatus.OK,false,"Here is the user data",user);
		}else{
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,true,"User does not exists", null);
		}
	}
	@RequestMapping(value="/users",method=RequestMethod.PUT)
	ResponseEntity<Object> updateUser(@RequestBody User user,@RequestParam String id){
		User updatedUser = userService.updateUser(user, id);
		if(updatedUser!=null){
			return ResponseHandler.generateResponse(HttpStatus.OK,false,"User updated successfully",updatedUser);
		}else{
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,true,"Unable to update user", null);
		}
	}
	@RequestMapping(value="/users",method=RequestMethod.GET)
	ResponseEntity<Object> getUserList(){
		List<User> userList = userService.getAllUsers();
	    return ResponseHandler.generateResponse(HttpStatus.OK,false,"User list",userList);
		
	}
	@RequestMapping(value="/users",method=RequestMethod.DELETE)
	ResponseEntity<Object> saveUser(@RequestParam String id){
		int deleteResponse = userService.deleteUser(id);
		if(deleteResponse>0){
			return ResponseHandler.generateResponse(HttpStatus.OK,false,"User deleted successfully",null);
		}else{
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,true,"Unable to delete user", null);
		}
	}
}
