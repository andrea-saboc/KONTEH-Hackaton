package com.example.hackaton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackaton.model.Desk;
import com.example.hackaton.model.Faculty;
import com.example.hackaton.service.FacultyService;

@RestController
@RequestMapping(value = "/faculties")
public class FacultyController {
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Faculty>> getAll(){
		return new ResponseEntity<>(facultyService.getAll(), HttpStatus.OK);
	}
}
