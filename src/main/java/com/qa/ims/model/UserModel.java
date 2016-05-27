package com.qa.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserModel {

	@GeneratedValue
	private long id;
	@Id
	@Column(name = "user_username")
	@NotNull
	private String username;
	@NotNull
	@Column(name = "user_password")
	private String password;

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserModel() {

	}

}
