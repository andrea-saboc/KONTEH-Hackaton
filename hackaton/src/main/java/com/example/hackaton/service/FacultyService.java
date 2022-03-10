package com.example.hackaton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackaton.model.Faculty;
import com.example.hackaton.repository.DeskRepository;
import com.example.hackaton.repository.FacultyRepository;

@Service
public class FacultyService {
	@Autowired
	private FacultyRepository facultyRepository;
	
	public List<Faculty> getAll(){
		return facultyRepository.findAll();
	}
}
