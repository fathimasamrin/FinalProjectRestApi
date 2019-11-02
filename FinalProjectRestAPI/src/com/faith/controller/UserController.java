package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IUserDao;
import com.faith.model.User;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController{
	
	@Autowired
	 private IUserDao dao;
	
	@RequestMapping(value="/userdetails",method=RequestMethod.GET)
	public List getUserDetails()
	{
		List list;
		System.out.println("Get all users details");
		list=dao.getAllDetails();
		return list;
	}
	@RequestMapping(value="/userdetails/{searchString}",method=RequestMethod.GET)
	public User getUserDetails(@PathVariable("searchString") String searchString)
	{
		System.out.println("Get as single user details");
		User user=dao.searchUserDetails(searchString);
		return user;
	}
	
	@RequestMapping(value="/userbyid/{uId}",method=RequestMethod.GET)
	public User getUserById(@PathVariable("uId") int uId)
	{
		
		User user=dao.getUserById(uId);
		return user;
	}
	
	@RequestMapping(value="/insertuser",method=RequestMethod.POST)
	public void insertDetails(@RequestBody User user)
	{
		dao.insertUserDetails(user);
	}
	
	@RequestMapping(value="/updateuser",method=RequestMethod.PUT)
	public void updateDetails(@RequestBody User user)
	{
		dao.updateUserDetails(user);
	}
	
	//get by names
	
		@RequestMapping (value = "/userdetbyname/{username}/{password}", method = RequestMethod.GET)
		public User getUserDetails (@PathVariable("username") String username,@PathVariable("password") String password){
			
			User user = (User)dao.searchUserDetails(username,password);
			System.out.println("get all user details by username and password");
			return user;
		}
	
	

}
