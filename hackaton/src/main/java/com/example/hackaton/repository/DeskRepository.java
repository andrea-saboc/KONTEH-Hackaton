package com.example.hackaton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackaton.model.Desk;

@Repository
public interface DeskRepository extends JpaRepository<Desk, String> {

}
