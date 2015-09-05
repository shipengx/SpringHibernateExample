package com.shipeng.entity;

import java.io.Serializable;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Contact implements Serializable {
 
	public Contact() {
	};

	public Contact(String name, String email, String profession) {
		this.name       = name;
		this.email      = email;
		this.profession = profession;
	}
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String profession;


	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfession() {
		return profession;
	}	
	
	public void setProfession(String profession) { 
		this.profession = profession;
	}
}//end entity class


