package com.revature.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.userDao;
import com.revature.dao.userDaoImpl;
import com.revature.models.User;

import exceptions.UserNotFoundExeption;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	userDao ud = new userDaoImpl();

	@GetMapping
	public List<User> getUsers(){
		return ud.getAllUsers();
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public User getUserById(@PathVariable("id")Integer id) {
		User u = ud.getUserById(id);
		if(u==null) {
			throw new UserNotFoundExeption();
		}
		return u;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
		public User addUser(@RequestBody User user){
		return ud.createUser(new User(user.getEmail(), user.getPassword(), user.getPlaylistId()));
	}

	@PutMapping(value="/{id}")
	public void updateUser(@PathVariable("id")Integer id, @RequestBody User user){

		User u = ud.getUserById(id);
		System.out.println(u);
		
		u.setEmail(user.getEmail());
		
		u.setPassword(user.getPassword());
		
		u.setPlaylistId(user.getPlaylistId());
		
		ud.updateUser(u);
		System.out.println(u);
		
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteUser(@PathVariable("id")Integer id){
		User u = ud.getUserById(id);
		ud.deleteUser(u);
		
	}

}
