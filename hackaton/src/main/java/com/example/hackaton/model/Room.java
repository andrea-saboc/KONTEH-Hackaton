package com.example.hackaton.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Room {
	
	@Id
	@Column(name = "id", nullable = false)
	private String id;
	
	private String name;
	
	
	@OneToMany(targetEntity = Desk.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Desk> desks;
	
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Room(String id, String name, Set<Desk> desks) {
		super();
		this.id = id;
		this.name = name;
		this.desks = desks;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Desk> getDesks() {
		return desks;
	}
	public void setDesks(Set<Desk> desks) {
		this.desks = desks;
	}
	
	
	

}
