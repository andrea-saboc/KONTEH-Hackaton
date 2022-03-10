package com.example.hackaton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackaton.dto.CreatingDeskDTO;
import com.example.hackaton.model.Desk;
import com.example.hackaton.model.Room;
import com.example.hackaton.service.DeskService;

@RestController
@RequestMapping(value = "/desks")
public class DeskController {
	
	@Autowired
	private DeskService deskService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ResponseEntity<List<Desk>> getAll(){
		return new ResponseEntity<>(deskService.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Desk>> getByRoom(@RequestParam String roomId){
		System.out.println("Looking for-->"+roomId);
		return new ResponseEntity<List<Desk>>(deskService.getByRoom(roomId), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addDesk(@RequestBody CreatingDeskDTO desk){
		Desk savedDesk = deskService.save(desk);
		if(savedDesk == null) {
			return new ResponseEntity<String>("Error occured while creating desk!", HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<String>("Desk successfully saved!", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteDesk(@PathVariable String id){
		System.out.println("Id: " + id);
		try {
			deskService.deleteDesk(id);
			return new ResponseEntity<String>("Desk successfully deleted!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Error occured during desk deletion!", HttpStatus.NOT_FOUND
					);
		}
		
		
	}

}
