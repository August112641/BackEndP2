package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.userDao;
import com.revature.models.User;

import exceptions.UserNotFoundExeption;

@RestController
public class UserController {

	@Autowired
	userDao ud;

	@GetMapping("/users")
	public List<User> getUsers(@RequestParam(value = "id", required =false)Integer id){
		if(id!=null) {
			User u = ud.getUserById(id);
			if(u == null) {
				throw new UserNotFoundExeption();
			}else {
				ArrayList<User> users = new ArrayList<>();
				users.add(u);
				return users;
			}
		}
		return ud.getAllUsers();
	}

	@RequestMapping(method=RequestMethod.GET, value="/users/{id}")
	public User getUserById(@PathVariable("id")Integer id) {
		User u = ud.getUserById(id);
		if(u==null) {
			throw new UserNotFoundExeption();
		}
		return u;
	}

	@PostMapping("/users")
	public String addCat(@RequestParam("email")String email,@RequestParam("password")String password, @RequestParam("playlistId")Integer playlistId) {
		User user = new User();
		ud.createUser(user);
		return "redirect:/users";

	}

//	@PutMapping("/users")
//	public List<User> updateUser(@RequestParam(value = "id")Integer id){
//		if(id!=null) {
//			User u = ud.getUserById(id);
//			if(u == null) {
//				throw new UserNotFoundExeption();
//			}else {
//				ArrayList<User> users = new ArrayList<>();
//				users.add(u);
//				return users;
//			}
//		}
//		return ud.getAllUsers();
//	}
}
