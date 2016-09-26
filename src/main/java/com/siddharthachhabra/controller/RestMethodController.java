package com.siddharthachhabra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siddharthachhabra.entity.User;
import com.siddharthachhabra.service.RestMethodService;

@RestController
public class RestMethodController {
	
	@Autowired
	private RestMethodService methodService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String getUser(@RequestParam("userId") String userId){
		return methodService.getUser(Integer.parseInt(userId));
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
