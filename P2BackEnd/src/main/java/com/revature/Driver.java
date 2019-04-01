package com.revature;

import java.util.List;

import com.revature.beans.User;
import com.revature.dao.userDaoImpl;
import com.revature.dao.userDao;

public class Driver {
	public static void main(String[] args) {
//		Session session = HibernateSessionUtil.getSession();
//		session.close();
	
		userDao ud = new userDaoImpl();

//		User u1 = new User("August112641@gmail.com", "password", 1);
//		ud.createUser(u1);
//
//		List<User> users= ud.getAllUsers();
//		for(User u: users) {
//			System.out.println(u);
//		}
		
		
//		System.out.println(ud.getUserById(50));
	
//		User update = ud.getUserById(50);
//		update.setEmail("test update");
//		update.setPassword("supersecretword");
//		update.setPlaylistId(400);
//		ud.updateUser(update);
//////	
//		User delete = ud.getUserById(300);
//		ud.deleteUser(delete);
	}
}
