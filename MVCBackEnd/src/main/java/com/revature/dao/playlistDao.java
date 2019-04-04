package com.revature.dao;

import java.util.List;

import com.revature.models.Playlists;


public interface playlistDao {
	public List<Playlists> getAllPlaylists();
	public Playlists getPlaylistsById(String id);
	public Playlists createPlayList(Playlists p);
	public void updatePlayList(Playlists p);
	public void deletePlaylist(Playlists p);

}
