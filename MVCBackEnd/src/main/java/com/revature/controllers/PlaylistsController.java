package com.revature.controllers;

import java.util.List;

import org.jboss.logging.Logger;
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

import com.revature.dao.playlistDao;
import com.revature.models.Playlists;

import exceptions.PlaylistNotFoundExeption;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/playlists")
public class PlaylistsController {

	@Autowired
	playlistDao pd;
	private Logger log = Logger.getLogger(PlaylistsController.class);

	@GetMapping
	public List<Playlists> getPlaylists(){
		return pd.getAllPlaylists();
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Playlists getPlaylistById(@PathVariable("id")String id) {
		
		Playlists p = pd.getPlaylistsById(id);
		if(p==null) {
			throw new PlaylistNotFoundExeption();
		}
		return p;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Playlists addPlaylist(@RequestBody Playlists playlist){
		return pd.createPlayList(new Playlists(playlist.getId()));
	}

	@PutMapping(value="/{id}")
	public void updatePlaylist(@PathVariable("id")String id, @RequestBody Playlists playlist){
		System.out.println(id);

		Playlists p = pd.getPlaylistsById(id);
		System.out.println(p);

		p.setId(playlist.getId());
		
		pd.updatePlayList(p);
	}

	@DeleteMapping(value="/{id}")
	public void deltelaylist(@PathVariable("id")String id){
		Playlists p = pd.getPlaylistsById(id);
		pd.deletePlaylist(p);
	}

}
