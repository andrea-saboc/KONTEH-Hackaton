package com.example.hackaton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackaton.model.Faculty;
import com.example.hackaton.model.Room;
import com.example.hackaton.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	
	public List<Room> getAll(){
		return roomRepository.findAll();
	}

}
