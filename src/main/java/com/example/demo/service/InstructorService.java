package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.InstructorForm;
import com.example.demo.entity.Instructor;

public interface InstructorService {

	public List<Instructor> findAll();
		
	public Optional<InstructorForm> getInstructorForm(int id);

	public void save(Instructor instructor);
	
	public void deleteById(int id);
}
