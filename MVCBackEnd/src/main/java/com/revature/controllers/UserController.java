package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.userDao;
import com.revature.dao.userDaoImpl;
import com.revature.models.User;

import exceptions.UserNotFoundExeption;

@CrossOrigin
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

	@PostMapping
	public String addUser(@RequestParam("email")String email,@RequestParam("password")String password, @RequestParam("playlistId")Integer playlistId) {
		User user = new User(email,password,playlistId);
		ud.createUser(user);
		return "redirect:/users";

	}

	@PutMapping
	public String updateUser(@RequestParam(value= "/{id}")Integer id){
		
			User u = ud.getUserById(id);
			u.setEmail(u.getEmail());
			u.setPassword(u.getPassword());
			u.setPlaylistId(u.getPlaylistId());
			ud.updateUser(u);
		return "redirect:/users";
	}
}
