package com.siddharthachhabra.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siddharthachhabra.entity.User;
import com.siddharthachhabra.service.RestMethodService;

@RestController
public class RestMethodController {
	
	@Autowired
	private RestMethodService methodService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public HashMap<Integer,String> getUsers(){
		return methodService.getUsers();
	}
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public String getUser(@PathVariable("userId") int userId){
		return methodService.getUser(userId);
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addUser(@RequestBody User user){
		methodService.addOrUpdate(user.getUserId(),user.getUserName());
		return "User added Successfully!";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.DELETE)
	public String deleteUser(@RequestBody User user){
		methodService.removeUser(user.getUserId());
		return "User deleted Successfully!";
	}

}
