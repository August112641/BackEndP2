package com.revature;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.dao.PlayistsDaoImpl;
import com.revature.dao.playlistDao;
import com.revature.dao.userDao;
import com.revature.dao.userDaoImpl;
import com.revature.models.User;

import exceptions.UserNotFoundExeption;

public class AnnotationTesting {
	userDao ud = new userDaoImpl();
	playlistDao pd = new PlayistsDaoImpl();

	@Test
	public void userLogin() {
		boolean login;
		List<User> users = new ArrayList<>();
		users.add(new User("mail@mail.com", "jumping", null));
		for(User u: users) {
			if("mail@mail.com".equals(u.getEmail())&& "jumping".equals(u.getPassword())){
				login = true;
			}else {
				login = false;
			}
			assertEquals(true, login);
		}
	}

	@Test
	public void failLogin() {
		boolean login;
		List<User> users = new ArrayList<>();
		users.add(new User("m@mail.com", "ping", null));
		for(User u: users) {
			if("mail@mail.com".equals(u.getEmail())&& "jumping".equals(u.getPassword())){
				login = true;
			}else {
				login = false;
			}
			assertEquals(false, login);
		}
	}

	@Test
	public void nullOrEmptyEmail() {
		boolean login= true;
		List<User> users = new ArrayList<>();
		users.add(new User(null, null, null));
		for(User u: users) {
			if(null==u.getEmail()|| "".equals(u.getEmail())){
				 login = false;
			}
		}
		assertEquals(false, login);
	}

	@Test
	public void nullOrEmptyPassWord() {
		boolean login= true;
		List<User> users = new ArrayList<>();
		users.add(new User(null, null, null));
		for(User u: users) {
			if(null==u.getPassword()|| "".equals(u.getPassword())){
				 login = false;
			}
		}
		assertEquals(false, login);
	}
	



}
