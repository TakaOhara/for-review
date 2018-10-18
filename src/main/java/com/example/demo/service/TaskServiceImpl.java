package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.TaskForm;
import com.example.demo.entity.Task;
import com.example.demo.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository repository;
	
	@Override
	public List<Task> findAll() {
		List<Task> list = repository.findAll();
		return list;
	}

	@Override
	public Optional<TaskForm> getTaskForm(int id) {
		Optional<Task> task = repository.findById(id);
		if(!task.isPresent()) {
			return Optional.ofNullable(null);
		}
		TaskForm form = new TaskForm(
				task.get().getTypeId(),
				task.get().getTitle(),
				task.get().getDetail(),
				task.get().getDeadline(),
				false);
		return Optional.ofNullable(form);
	}

	@Override
	public void save(Task task) {
		repository.saveAndFlush(task);

	}

	@Override
	public void deleteById(int id) {
		Optional<Task> task =  repository.findById(id);
		System.out.println(task.isPresent());
		if(task.isPresent()) {
			repository.deleteById(id);
		}

	}

}
