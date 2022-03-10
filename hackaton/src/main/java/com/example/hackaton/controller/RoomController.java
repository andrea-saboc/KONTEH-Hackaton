package com.example.hackaton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackaton.model.Faculty;
import com.example.hackaton.model.Room;
import com.example.hackaton.repository.RoomRepository;
import com.example.hackaton.service.RoomService;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ResponseEntity<List<Room>> getAll(){
		return new ResponseEntity<>(roomService.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Room>> getByFaculty(@RequestParam String faculty){
		return new ResponseEntity<List<Room>>(roomService.getByFaculty(faculty), HttpStatus.OK);
	}
	
	

}
