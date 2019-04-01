package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.models.User;
import com.revature.util.HibernateSessionUtil;

@Component
public class userDaoImpl implements userDao{

	@Override
	public List<User> getAllUsers() {
		Session session = HibernateSessionUtil.getSession();
		List<User> users = null;
		try {
			users = session.createQuery("from User").list();
		}catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();	
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		Session session = HibernateSessionUtil.getSession();
		List<User> users = null;
		User user =null;
		try {
			users = session.createQuery("from User").list();
			for(User u: users) {
				if(u.getId()==id) {
					user=u;
				}
			}
		}catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();	
		}
		return user;
	}

	@Override
	public User createUser(User u) {
		Session session = HibernateSessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(u);
			tx.commit();			
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}

		return u;	
	}

	@Override
	public void updateUser(User u) {
		Session session = HibernateSessionUtil.getSession();
		Transaction tx = null;
		User user =null;
		try {
			tx = session.beginTransaction();
			user = (User)session.get(User.class, u.getId());
//			if(u.getId() != null) {
//				u.setId(u.getId());
//			}
			if(u.getEmail() != null) {
				user.setEmail(u.getEmail());
			}
			if(u.getPassword() != null) {
				user.setPassword(u.getPassword());
			}
			if(u.getPlaylistId() != null) {
				user.setPlaylistId(u.getPlaylistId());
			}
			session.save(user);
			tx.commit();			
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}

	}

	@Override
	public void deleteUser(User u) {
		Session session = HibernateSessionUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.delete(session.get(User.class, u.getId()));
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	
}

}
