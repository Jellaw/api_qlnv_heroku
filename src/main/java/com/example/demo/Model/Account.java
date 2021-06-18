package com.example.demo.Model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account implements Serializable {
	private static final long serialVersionUID = 2L;
	private String username;
	private String password;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	public Account(){
		id=0;
	}
	public Account(String username, String password, long id) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
