package com.siddharthachhabra.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class RestMethodService {
	
	private HashMap<Integer,String> userMap;
	
	public RestMethodService(){
		userMap=new HashMap<Integer,String>();
	}
	
	public void addOrUpdate(int id,String name){
		userMap.put(id, name);
	}
	
	public void removeUser(int id){
		userMap.remove(id);
	}
	
	public String getUser(int id){
		return userMap.get(id);
	}

}
