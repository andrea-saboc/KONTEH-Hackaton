package com.example.hackaton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "desk")
public class Desk {
	
	@Id
	private String id;
	@Column
	private int orderr;
	
	
	
	
	public Desk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Desk(String id, int order) {
		super();
		this.id = id;
		this.orderr = order;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrder() {
		return orderr;
	}
	public void setOrder(int order) {
		this.orderr = order;
	}
	@Override
	public String toString() {
		return "Desk [id=" + id + ", orderr=" + orderr + "]";
	}
	
	
	
	
}
