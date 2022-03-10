package com.example.hackaton.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hackaton.model.Desk;
import com.example.hackaton.repository.DeskRepository;
import com.example.hackaton.repository.RoomRepository;

@Service
public class DeskService {
	
	@Autowired
	private DeskRepository deskRepository;
	@Autowired
	private RoomRepository roomRepository;

	
	public List<com.example.hackaton.model.Desk> getAll() {
		// TODO Auto-generated method stub
		return deskRepository.findAll();
	}


	public List<Desk> getByRoom(String room) {
		// TODO Auto-generated method stub
		return new ArrayList<Desk>( roomRepository.findById(room).get().getDesks());
	}


	public Desk save(Desk desk) {
		// TODO Auto-generated method stub
		Desk newDesk = null;
		try {
			newDesk = deskRepository.save(desk);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return newDesk;
	}
	
}
