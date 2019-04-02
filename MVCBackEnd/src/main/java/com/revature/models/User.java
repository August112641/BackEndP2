package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASS")

	private String password;
	
	@Column(name="PLAYLIST")

	private Integer playlistId;

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

	public Integer getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(Integer playlistId) {
		this.playlistId = playlistId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((playlistId == null) ? 0 : playlistId.hashCode());
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
		if (playlistId == null) {
			if (other.playlistId != null)
				return false;
		} else if (!playlistId.equals(other.playlistId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", playlistId=" + playlistId + "]";
	}

	public User(Integer id, String email, String password, Integer playlistId) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.playlistId = playlistId;
	}

	public User(String email, String password, Integer playlistId) {
		super();
		this.email = email;
		this.password = password;
		this.playlistId = playlistId;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
