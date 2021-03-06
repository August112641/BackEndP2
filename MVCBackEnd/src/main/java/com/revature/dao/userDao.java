package com.revature.dao;

import java.util.List;

import com.revature.models.User;


public interface userDao {
	public List<User> getAllUsers();
	public User getUserById(int id);
	public User createUser(User u);
	public void updateUser(User u);
	public void deleteUser(User u);
	public User getUserByEmail(String email);

}
