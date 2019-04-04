 package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.models.Playlists;
import com.revature.util.HibernateSessionUtil;

@Component
public class PlayistsDaoImpl implements playlistDao{

	@Override
	public List<Playlists> getAllPlaylists() {
		Session session = HibernateSessionUtil.getSession();
		List<Playlists> playlists = null;
		try {
			playlists = session.createQuery("from Playlists").list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return playlists;
	}

	@Override
	public Playlists getPlaylistsById(String id) {
		Session session = HibernateSessionUtil.getSession();
		List<Playlists> playlists = null;
		Playlists playlist =null;
		try {
			playlists = session.createQuery("from Playlists").list();
			for(Playlists p: playlists) {
				if(p.getId().equals(id)) {
					playlist=p;
				}
			}
		}catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();	
		}
		return playlist;
	}

	@Override
	public Playlists createPlayList(Playlists p) {
		Session session = HibernateSessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(p);
			tx.commit();			
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}

		return p;	
	}

	@Override
	public void updatePlayList(Playlists p) {
		Session session = HibernateSessionUtil.getSession();
		Transaction tx = null;
		Playlists playlist =null;
		try {
			tx = session.beginTransaction();
			playlist = (Playlists) session.get(Playlists.class, p.getId());
			if(p.getId() != null) {
				playlist.setId(p.getId());
			}
			session.save(playlist);
			tx.commit();			
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}

	}

	@Override
	public void deletePlaylist(Playlists p) {
		Session session = HibernateSessionUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.delete(session.get(Playlists.class, p.getId()));
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	
}

}
