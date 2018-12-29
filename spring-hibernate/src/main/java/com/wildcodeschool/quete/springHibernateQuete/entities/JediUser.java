package com.wildcodeschool.quete.springHibernateQuete.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JediUser {
	
	public JediUser() {
	}
		
		public JediUser(String name, String surName) {
			this.name = name;
			this.surName = surName;
		}
		
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surName;
	
	@Override
	public String toString() {
		return "JediUser [id=" + id + ", name=" + name + ", surName=" + surName + "]";
	}
	
	
		//GETTERS ET SETTERS
		
		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurName() {
			return surName;
		}

		public void setSurName(String surName) {
			this.surName = surName;
		}
		
		
	}

