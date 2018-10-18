package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{
	public Optional<Instructor> findById(int id);
	public Optional<Instructor> findByEmail(String email);
	public void deleteById(int id);
}
