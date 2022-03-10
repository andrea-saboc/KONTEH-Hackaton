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

@Service
public class DeskService {
	
	@Autowired
	private DeskRepository deskRepository;

	
	public List<com.example.hackaton.model.Desk> getAll() {
		// TODO Auto-generated method stub
		return deskRepository.findAll();
	}
	
}
