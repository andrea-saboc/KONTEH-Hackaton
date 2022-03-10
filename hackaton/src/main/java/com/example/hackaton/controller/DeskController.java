package com.example.hackaton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackaton.model.Desk;
import com.example.hackaton.service.DeskService;

@RestController
@RequestMapping(value = "/desks")
public class DeskController {
	
	@Autowired
	private DeskService deskService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Desk>> getAll(){
		return new ResponseEntity<>(deskService.getAll(), HttpStatus.OK);
	}

}
