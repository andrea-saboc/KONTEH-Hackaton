package com.example.hackaton.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackaton.model.Faculty;
import com.example.hackaton.model.Room;
import com.example.hackaton.repository.FacultyRepository;
import com.example.hackaton.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private FacultyRepository facultyRepository;
	
	public List<Room> getAll(){
		return roomRepository.findAll();
	}

	public List<Room> getByFaculty(String facultyId) {
		// TODO Auto-generated method stub
		return new ArrayList<Room>( facultyRepository.findById(facultyId).get().getRooms());
	}

}
