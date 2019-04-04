package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "USERS")
@Component
public class User {
	@Id
	@Column (name="USER_ID")
	@SequenceGenerator(sequenceName="bee_seq", name="b_seq")
	@GeneratedValue(generator="b_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;

	@Column(name="EMAIL", unique=true)
	private String email;

	@Column(name="PASS")
	private String password;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="PLAYLISTS",
			joinColumns= {@JoinColumn(name="USER_ID")},
			inverseJoinColumns = {@JoinColumn(name="PLAYLIST_ID")})
	private List<Playlists> playlist = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Playlists> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Playlists> playlist) {
		this.playlist = playlist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((playlist == null) ? 0 : playlist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (playlist == null) {
			if (other.playlist != null)
				return false;
		} else if (!playlist.equals(other.playlist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", playlist=" + playlist + "]";
	}

	public User(Integer id, String email, String password, List<Playlists> playlist) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.playlist = playlist;
	}

	public User(String email, String password, List<Playlists> playlist) {
		super();
		this.email = email;
		this.password = password;
		this.playlist = playlist;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, List<Playlists> playlist) {
		super();
		this.id = id;
		this.playlist = playlist;
	}
	
}
