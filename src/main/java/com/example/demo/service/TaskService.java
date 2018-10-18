package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.TaskForm;
import com.example.demo.entity.Task;

public interface TaskService {

	public List<Task> findAll();
		
	public Optional<TaskForm> getTaskForm(int id);

	public void save(Task task);
	
	public void deleteById(int id);
}
