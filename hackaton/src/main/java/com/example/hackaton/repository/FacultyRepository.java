package com.example.hackaton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackaton.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {

}
