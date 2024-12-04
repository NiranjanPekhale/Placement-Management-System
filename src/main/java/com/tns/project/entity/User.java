package com.tns.project.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private long id;
	private String name;
	private String type;
	private String password;
	
/*	
	@OneToOne(mappedBy="user")
	private College college;
	
	
	

	public User(long id, String name, String password, College college) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.college = college;
	}


*/
	
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}



	public User(long id, String name, String type, String password) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.password = password;
}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + "]";
	}

	



/*

	public College getCollege() {
		return college;
	}



	public void setCollege(College college) {
		this.college = college;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", college=" + college + "]";
	}
	
*/
	

}
