package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	public Optional<Task> findById(int id);
	public void deleteById(int id);
}
