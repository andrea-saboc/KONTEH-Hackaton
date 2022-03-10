package com.example.hackaton.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Faculty {
	
	@Id
	private String id;
	
	private String name;
	
	@OneToMany(targetEntity = Room.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Room> rooms;
	
	@Embedded
	private WorkingHours working_hours;

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



	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public WorkingHours getWorking_hours() {
		return working_hours;
	}

	public void setWorking_hours(WorkingHours working_hours) {
		this.working_hours = working_hours;
	}

	public Faculty(String id, String name, Set<Room> rooms, WorkingHours working_hours) {
		super();
		this.id = id;
		this.name = name;
		this.rooms = rooms;
		this.working_hours = working_hours;
	}

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
