package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Person {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user")
	@SequenceGenerator(name="user", sequenceName="USERS_ID_SEQ")
	private int id;
	@Column(nullable=false, unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	
	public Person() {
		super();
	}

	public Person(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
