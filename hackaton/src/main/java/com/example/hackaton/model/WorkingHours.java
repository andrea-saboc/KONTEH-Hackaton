package com.example.hackaton.model;

import java.sql.Time;

import javax.persistence.Embeddable;

@Embeddable
public class WorkingHours {
	
	private final String opens;
	private final String closes;
	
	
	
	public WorkingHours() {
		this.opens = "6:60";
		this.closes = "4:70";

	}



	
	

}
